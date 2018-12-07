package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtVentaController {

    SqtVentaService sqtVentaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtVentaService.list(params), model:[sqtVentaCount: sqtVentaService.count()]
    }

    def show(Long id) {
        respond sqtVentaService.get(id)
    }

    def create() {
        respond new SqtVenta(params)
    }

    def save(SqtVenta sqtVenta) {
        if (sqtVenta == null) {
            notFound()
            return
        }

        try {
            sqtVentaService.save(sqtVenta)
        } catch (ValidationException e) {
            respond sqtVenta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtVenta.label', default: 'SqtVenta'), sqtVenta.id])
                redirect sqtVenta
            }
            '*' { respond sqtVenta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtVentaService.get(id)
    }

    def update(SqtVenta sqtVenta) {
        if (sqtVenta == null) {
            notFound()
            return
        }

        try {
            sqtVentaService.save(sqtVenta)
        } catch (ValidationException e) {
            respond sqtVenta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtVenta.label', default: 'SqtVenta'), sqtVenta.id])
                redirect sqtVenta
            }
            '*'{ respond sqtVenta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtVentaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtVenta.label', default: 'SqtVenta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtVenta.label', default: 'SqtVenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
