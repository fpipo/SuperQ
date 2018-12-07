package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTiendaTipoVentaController {

    SqtTiendaTipoVentaService sqtTiendaTipoVentaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTiendaTipoVentaService.list(params), model:[sqtTiendaTipoVentaCount: sqtTiendaTipoVentaService.count()]
    }

    def show(Long id) {
        respond sqtTiendaTipoVentaService.get(id)
    }

    def create() {
        respond new SqtTiendaTipoVenta(params)
    }

    def save(SqtTiendaTipoVenta sqtTiendaTipoVenta) {
        if (sqtTiendaTipoVenta == null) {
            notFound()
            return
        }

        try {
            sqtTiendaTipoVentaService.save(sqtTiendaTipoVenta)
        } catch (ValidationException e) {
            respond sqtTiendaTipoVenta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTiendaTipoVenta.label', default: 'SqtTiendaTipoVenta'), sqtTiendaTipoVenta.id])
                redirect sqtTiendaTipoVenta
            }
            '*' { respond sqtTiendaTipoVenta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTiendaTipoVentaService.get(id)
    }

    def update(SqtTiendaTipoVenta sqtTiendaTipoVenta) {
        if (sqtTiendaTipoVenta == null) {
            notFound()
            return
        }

        try {
            sqtTiendaTipoVentaService.save(sqtTiendaTipoVenta)
        } catch (ValidationException e) {
            respond sqtTiendaTipoVenta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTiendaTipoVenta.label', default: 'SqtTiendaTipoVenta'), sqtTiendaTipoVenta.id])
                redirect sqtTiendaTipoVenta
            }
            '*'{ respond sqtTiendaTipoVenta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTiendaTipoVentaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTiendaTipoVenta.label', default: 'SqtTiendaTipoVenta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTiendaTipoVenta.label', default: 'SqtTiendaTipoVenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
