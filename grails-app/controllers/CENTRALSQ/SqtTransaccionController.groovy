package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTransaccionController {

    SqtTransaccionService sqtTransaccionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTransaccionService.list(params), model:[sqtTransaccionCount: sqtTransaccionService.count()]
    }

    def show(Long id) {
        respond sqtTransaccionService.get(id)
    }

    def create() {
        respond new SqtTransaccion(params)
    }

    def save(SqtTransaccion sqtTransaccion) {
        if (sqtTransaccion == null) {
            notFound()
            return
        }

        try {
            sqtTransaccionService.save(sqtTransaccion)
        } catch (ValidationException e) {
            respond sqtTransaccion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTransaccion.label', default: 'SqtTransaccion'), sqtTransaccion.id])
                redirect sqtTransaccion
            }
            '*' { respond sqtTransaccion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTransaccionService.get(id)
    }

    def update(SqtTransaccion sqtTransaccion) {
        if (sqtTransaccion == null) {
            notFound()
            return
        }

        try {
            sqtTransaccionService.save(sqtTransaccion)
        } catch (ValidationException e) {
            respond sqtTransaccion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTransaccion.label', default: 'SqtTransaccion'), sqtTransaccion.id])
                redirect sqtTransaccion
            }
            '*'{ respond sqtTransaccion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTransaccionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTransaccion.label', default: 'SqtTransaccion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTransaccion.label', default: 'SqtTransaccion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
