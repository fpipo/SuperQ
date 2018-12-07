package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleDevolucionController {

    SqtDetalleDevolucionService sqtDetalleDevolucionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleDevolucionService.list(params), model:[sqtDetalleDevolucionCount: sqtDetalleDevolucionService.count()]
    }

    def show(Long id) {
        respond sqtDetalleDevolucionService.get(id)
    }

    def create() {
        respond new SqtDetalleDevolucion(params)
    }

    def save(SqtDetalleDevolucion sqtDetalleDevolucion) {
        if (sqtDetalleDevolucion == null) {
            notFound()
            return
        }

        try {
            sqtDetalleDevolucionService.save(sqtDetalleDevolucion)
        } catch (ValidationException e) {
            respond sqtDetalleDevolucion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleDevolucion.label', default: 'SqtDetalleDevolucion'), sqtDetalleDevolucion.id])
                redirect sqtDetalleDevolucion
            }
            '*' { respond sqtDetalleDevolucion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleDevolucionService.get(id)
    }

    def update(SqtDetalleDevolucion sqtDetalleDevolucion) {
        if (sqtDetalleDevolucion == null) {
            notFound()
            return
        }

        try {
            sqtDetalleDevolucionService.save(sqtDetalleDevolucion)
        } catch (ValidationException e) {
            respond sqtDetalleDevolucion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleDevolucion.label', default: 'SqtDetalleDevolucion'), sqtDetalleDevolucion.id])
                redirect sqtDetalleDevolucion
            }
            '*'{ respond sqtDetalleDevolucion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleDevolucionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleDevolucion.label', default: 'SqtDetalleDevolucion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleDevolucion.label', default: 'SqtDetalleDevolucion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
