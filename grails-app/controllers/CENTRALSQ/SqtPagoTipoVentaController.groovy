package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPagoTipoVentaController {

    SqtPagoTipoVentaService sqtPagoTipoVentaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPagoTipoVentaService.list(params), model:[sqtPagoTipoVentaCount: sqtPagoTipoVentaService.count()]
    }

    def show(Long id) {
        respond sqtPagoTipoVentaService.get(id)
    }

    def create() {
        respond new SqtPagoTipoVenta(params)
    }

    def save(SqtPagoTipoVenta sqtPagoTipoVenta) {
        if (sqtPagoTipoVenta == null) {
            notFound()
            return
        }

        try {
            sqtPagoTipoVentaService.save(sqtPagoTipoVenta)
        } catch (ValidationException e) {
            respond sqtPagoTipoVenta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPagoTipoVenta.label', default: 'SqtPagoTipoVenta'), sqtPagoTipoVenta.id])
                redirect sqtPagoTipoVenta
            }
            '*' { respond sqtPagoTipoVenta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPagoTipoVentaService.get(id)
    }

    def update(SqtPagoTipoVenta sqtPagoTipoVenta) {
        if (sqtPagoTipoVenta == null) {
            notFound()
            return
        }

        try {
            sqtPagoTipoVentaService.save(sqtPagoTipoVenta)
        } catch (ValidationException e) {
            respond sqtPagoTipoVenta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPagoTipoVenta.label', default: 'SqtPagoTipoVenta'), sqtPagoTipoVenta.id])
                redirect sqtPagoTipoVenta
            }
            '*'{ respond sqtPagoTipoVenta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPagoTipoVentaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPagoTipoVenta.label', default: 'SqtPagoTipoVenta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPagoTipoVenta.label', default: 'SqtPagoTipoVenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
