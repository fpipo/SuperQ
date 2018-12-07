package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleDevolucionVentaController {

    SqtDetalleDevolucionVentaService sqtDetalleDevolucionVentaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleDevolucionVentaService.list(params), model:[sqtDetalleDevolucionVentaCount: sqtDetalleDevolucionVentaService.count()]
    }

    def show(Long id) {
        respond sqtDetalleDevolucionVentaService.get(id)
    }

    def create() {
        respond new SqtDetalleDevolucionVenta(params)
    }

    def save(SqtDetalleDevolucionVenta sqtDetalleDevolucionVenta) {
        if (sqtDetalleDevolucionVenta == null) {
            notFound()
            return
        }

        try {
            sqtDetalleDevolucionVentaService.save(sqtDetalleDevolucionVenta)
        } catch (ValidationException e) {
            respond sqtDetalleDevolucionVenta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleDevolucionVenta.label', default: 'SqtDetalleDevolucionVenta'), sqtDetalleDevolucionVenta.id])
                redirect sqtDetalleDevolucionVenta
            }
            '*' { respond sqtDetalleDevolucionVenta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleDevolucionVentaService.get(id)
    }

    def update(SqtDetalleDevolucionVenta sqtDetalleDevolucionVenta) {
        if (sqtDetalleDevolucionVenta == null) {
            notFound()
            return
        }

        try {
            sqtDetalleDevolucionVentaService.save(sqtDetalleDevolucionVenta)
        } catch (ValidationException e) {
            respond sqtDetalleDevolucionVenta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleDevolucionVenta.label', default: 'SqtDetalleDevolucionVenta'), sqtDetalleDevolucionVenta.id])
                redirect sqtDetalleDevolucionVenta
            }
            '*'{ respond sqtDetalleDevolucionVenta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleDevolucionVentaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleDevolucionVenta.label', default: 'SqtDetalleDevolucionVenta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleDevolucionVenta.label', default: 'SqtDetalleDevolucionVenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
