package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDevolucionController {

    SqtDevolucionService sqtDevolucionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDevolucionService.list(params), model:[sqtDevolucionCount: sqtDevolucionService.count()]
    }

    def show(Long id) {
        respond sqtDevolucionService.get(id)
    }

    def create() {
        respond new SqtDevolucion(params)
    }

    def save(SqtDevolucion sqtDevolucion) {
        if (sqtDevolucion == null) {
            notFound()
            return
        }

        try {
            sqtDevolucionService.save(sqtDevolucion)
        } catch (ValidationException e) {
            respond sqtDevolucion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDevolucion.label', default: 'SqtDevolucion'), sqtDevolucion.id])
                redirect sqtDevolucion
            }
            '*' { respond sqtDevolucion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDevolucionService.get(id)
    }

    def update(SqtDevolucion sqtDevolucion) {
        if (sqtDevolucion == null) {
            notFound()
            return
        }

        try {
            sqtDevolucionService.save(sqtDevolucion)
        } catch (ValidationException e) {
            respond sqtDevolucion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDevolucion.label', default: 'SqtDevolucion'), sqtDevolucion.id])
                redirect sqtDevolucion
            }
            '*'{ respond sqtDevolucion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDevolucionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDevolucion.label', default: 'SqtDevolucion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDevolucion.label', default: 'SqtDevolucion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
