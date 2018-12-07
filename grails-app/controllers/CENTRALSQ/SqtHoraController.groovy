package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtHoraController {

    SqtHoraService sqtHoraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtHoraService.list(params), model:[sqtHoraCount: sqtHoraService.count()]
    }

    def show(Long id) {
        respond sqtHoraService.get(id)
    }

    def create() {
        respond new SqtHora(params)
    }

    def save(SqtHora sqtHora) {
        if (sqtHora == null) {
            notFound()
            return
        }

        try {
            sqtHoraService.save(sqtHora)
        } catch (ValidationException e) {
            respond sqtHora.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtHora.label', default: 'SqtHora'), sqtHora.id])
                redirect sqtHora
            }
            '*' { respond sqtHora, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtHoraService.get(id)
    }

    def update(SqtHora sqtHora) {
        if (sqtHora == null) {
            notFound()
            return
        }

        try {
            sqtHoraService.save(sqtHora)
        } catch (ValidationException e) {
            respond sqtHora.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtHora.label', default: 'SqtHora'), sqtHora.id])
                redirect sqtHora
            }
            '*'{ respond sqtHora, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtHoraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtHora.label', default: 'SqtHora'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtHora.label', default: 'SqtHora'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
