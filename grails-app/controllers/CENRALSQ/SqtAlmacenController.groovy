package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAlmacenController {

    SqtAlmacenService sqtAlmacenService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAlmacenService.list(params), model:[sqtAlmacenCount: sqtAlmacenService.count()]
    }

    def show(Long id) {
        respond sqtAlmacenService.get(id)
    }

    def create() {
        respond new SqtAlmacen(params)
    }

    def save(SqtAlmacen sqtAlmacen) {
        if (sqtAlmacen == null) {
            notFound()
            return
        }

        try {
            sqtAlmacenService.save(sqtAlmacen)
        } catch (ValidationException e) {
            respond sqtAlmacen.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAlmacen.label', default: 'SqtAlmacen'), sqtAlmacen.id])
                redirect sqtAlmacen
            }
            '*' { respond sqtAlmacen, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAlmacenService.get(id)
    }

    def update(SqtAlmacen sqtAlmacen) {
        if (sqtAlmacen == null) {
            notFound()
            return
        }

        try {
            sqtAlmacenService.save(sqtAlmacen)
        } catch (ValidationException e) {
            respond sqtAlmacen.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAlmacen.label', default: 'SqtAlmacen'), sqtAlmacen.id])
                redirect sqtAlmacen
            }
            '*'{ respond sqtAlmacen, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAlmacenService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAlmacen.label', default: 'SqtAlmacen'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAlmacen.label', default: 'SqtAlmacen'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
