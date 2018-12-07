package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProductoServicioController {

    SqtProductoServicioService sqtProductoServicioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProductoServicioService.list(params), model:[sqtProductoServicioCount: sqtProductoServicioService.count()]
    }

    def show(Long id) {
        respond sqtProductoServicioService.get(id)
    }

    def create() {
        respond new SqtProductoServicio(params)
    }

    def save(SqtProductoServicio sqtProductoServicio) {
        if (sqtProductoServicio == null) {
            notFound()
            return
        }

        try {
            sqtProductoServicioService.save(sqtProductoServicio)
        } catch (ValidationException e) {
            respond sqtProductoServicio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProductoServicio.label', default: 'SqtProductoServicio'), sqtProductoServicio.id])
                redirect sqtProductoServicio
            }
            '*' { respond sqtProductoServicio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProductoServicioService.get(id)
    }

    def update(SqtProductoServicio sqtProductoServicio) {
        if (sqtProductoServicio == null) {
            notFound()
            return
        }

        try {
            sqtProductoServicioService.save(sqtProductoServicio)
        } catch (ValidationException e) {
            respond sqtProductoServicio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProductoServicio.label', default: 'SqtProductoServicio'), sqtProductoServicio.id])
                redirect sqtProductoServicio
            }
            '*'{ respond sqtProductoServicio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProductoServicioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProductoServicio.label', default: 'SqtProductoServicio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProductoServicio.label', default: 'SqtProductoServicio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
