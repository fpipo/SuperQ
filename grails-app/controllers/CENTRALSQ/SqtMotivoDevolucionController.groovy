package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMotivoDevolucionController {

    SqtMotivoDevolucionService sqtMotivoDevolucionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMotivoDevolucionService.list(params), model:[sqtMotivoDevolucionCount: sqtMotivoDevolucionService.count()]
    }

    def show(Long id) {
        respond sqtMotivoDevolucionService.get(id)
    }

    def create() {
        respond new SqtMotivoDevolucion(params)
    }

    def save(SqtMotivoDevolucion sqtMotivoDevolucion) {
        if (sqtMotivoDevolucion == null) {
            notFound()
            return
        }

        try {
            sqtMotivoDevolucionService.save(sqtMotivoDevolucion)
        } catch (ValidationException e) {
            respond sqtMotivoDevolucion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMotivoDevolucion.label', default: 'SqtMotivoDevolucion'), sqtMotivoDevolucion.id])
                redirect sqtMotivoDevolucion
            }
            '*' { respond sqtMotivoDevolucion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMotivoDevolucionService.get(id)
    }

    def update(SqtMotivoDevolucion sqtMotivoDevolucion) {
        if (sqtMotivoDevolucion == null) {
            notFound()
            return
        }

        try {
            sqtMotivoDevolucionService.save(sqtMotivoDevolucion)
        } catch (ValidationException e) {
            respond sqtMotivoDevolucion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMotivoDevolucion.label', default: 'SqtMotivoDevolucion'), sqtMotivoDevolucion.id])
                redirect sqtMotivoDevolucion
            }
            '*'{ respond sqtMotivoDevolucion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMotivoDevolucionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMotivoDevolucion.label', default: 'SqtMotivoDevolucion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMotivoDevolucion.label', default: 'SqtMotivoDevolucion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
