package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtBitacoraController {

    SqtBitacoraService sqtBitacoraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtBitacoraService.list(params), model:[sqtBitacoraCount: sqtBitacoraService.count()]
    }

    def show(Long id) {
        respond sqtBitacoraService.get(id)
    }

    def create() {
        respond new SqtBitacora(params)
    }

    def save(SqtBitacora sqtBitacora) {
        if (sqtBitacora == null) {
            notFound()
            return
        }

        try {
            sqtBitacoraService.save(sqtBitacora)
        } catch (ValidationException e) {
            respond sqtBitacora.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtBitacora.label', default: 'SqtBitacora'), sqtBitacora.id])
                redirect sqtBitacora
            }
            '*' { respond sqtBitacora, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtBitacoraService.get(id)
    }

    def update(SqtBitacora sqtBitacora) {
        if (sqtBitacora == null) {
            notFound()
            return
        }

        try {
            sqtBitacoraService.save(sqtBitacora)
        } catch (ValidationException e) {
            respond sqtBitacora.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtBitacora.label', default: 'SqtBitacora'), sqtBitacora.id])
                redirect sqtBitacora
            }
            '*'{ respond sqtBitacora, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtBitacoraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtBitacora.label', default: 'SqtBitacora'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtBitacora.label', default: 'SqtBitacora'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
