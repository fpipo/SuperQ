package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPagoVentaController {

    SqtPagoVentaService sqtPagoVentaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPagoVentaService.list(params), model:[sqtPagoVentaCount: sqtPagoVentaService.count()]
    }

    def show(Long id) {
        respond sqtPagoVentaService.get(id)
    }

    def create() {
        respond new SqtPagoVenta(params)
    }

    def save(SqtPagoVenta sqtPagoVenta) {
        if (sqtPagoVenta == null) {
            notFound()
            return
        }

        try {
            sqtPagoVentaService.save(sqtPagoVenta)
        } catch (ValidationException e) {
            respond sqtPagoVenta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPagoVenta.label', default: 'SqtPagoVenta'), sqtPagoVenta.id])
                redirect sqtPagoVenta
            }
            '*' { respond sqtPagoVenta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPagoVentaService.get(id)
    }

    def update(SqtPagoVenta sqtPagoVenta) {
        if (sqtPagoVenta == null) {
            notFound()
            return
        }

        try {
            sqtPagoVentaService.save(sqtPagoVenta)
        } catch (ValidationException e) {
            respond sqtPagoVenta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPagoVenta.label', default: 'SqtPagoVenta'), sqtPagoVenta.id])
                redirect sqtPagoVenta
            }
            '*'{ respond sqtPagoVenta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPagoVentaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPagoVenta.label', default: 'SqtPagoVenta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPagoVenta.label', default: 'SqtPagoVenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
