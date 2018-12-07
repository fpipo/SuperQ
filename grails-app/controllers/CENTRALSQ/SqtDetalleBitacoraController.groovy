package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleBitacoraController {

    SqtDetalleBitacoraService sqtDetalleBitacoraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleBitacoraService.list(params), model:[sqtDetalleBitacoraCount: sqtDetalleBitacoraService.count()]
    }

    def show(Long id) {
        respond sqtDetalleBitacoraService.get(id)
    }

    def create() {
        respond new SqtDetalleBitacora(params)
    }

    def save(SqtDetalleBitacora sqtDetalleBitacora) {
        if (sqtDetalleBitacora == null) {
            notFound()
            return
        }

        try {
            sqtDetalleBitacoraService.save(sqtDetalleBitacora)
        } catch (ValidationException e) {
            respond sqtDetalleBitacora.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleBitacora.label', default: 'SqtDetalleBitacora'), sqtDetalleBitacora.id])
                redirect sqtDetalleBitacora
            }
            '*' { respond sqtDetalleBitacora, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleBitacoraService.get(id)
    }

    def update(SqtDetalleBitacora sqtDetalleBitacora) {
        if (sqtDetalleBitacora == null) {
            notFound()
            return
        }

        try {
            sqtDetalleBitacoraService.save(sqtDetalleBitacora)
        } catch (ValidationException e) {
            respond sqtDetalleBitacora.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleBitacora.label', default: 'SqtDetalleBitacora'), sqtDetalleBitacora.id])
                redirect sqtDetalleBitacora
            }
            '*'{ respond sqtDetalleBitacora, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleBitacoraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleBitacora.label', default: 'SqtDetalleBitacora'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleBitacora.label', default: 'SqtDetalleBitacora'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
