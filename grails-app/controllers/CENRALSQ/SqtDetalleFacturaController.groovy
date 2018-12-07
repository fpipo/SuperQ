package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleFacturaController {

    SqtDetalleFacturaService sqtDetalleFacturaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleFacturaService.list(params), model:[sqtDetalleFacturaCount: sqtDetalleFacturaService.count()]
    }

    def show(Long id) {
        respond sqtDetalleFacturaService.get(id)
    }

    def create() {
        respond new SqtDetalleFactura(params)
    }

    def save(SqtDetalleFactura sqtDetalleFactura) {
        if (sqtDetalleFactura == null) {
            notFound()
            return
        }

        try {
            sqtDetalleFacturaService.save(sqtDetalleFactura)
        } catch (ValidationException e) {
            respond sqtDetalleFactura.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleFactura.label', default: 'SqtDetalleFactura'), sqtDetalleFactura.id])
                redirect sqtDetalleFactura
            }
            '*' { respond sqtDetalleFactura, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleFacturaService.get(id)
    }

    def update(SqtDetalleFactura sqtDetalleFactura) {
        if (sqtDetalleFactura == null) {
            notFound()
            return
        }

        try {
            sqtDetalleFacturaService.save(sqtDetalleFactura)
        } catch (ValidationException e) {
            respond sqtDetalleFactura.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleFactura.label', default: 'SqtDetalleFactura'), sqtDetalleFactura.id])
                redirect sqtDetalleFactura
            }
            '*'{ respond sqtDetalleFactura, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleFacturaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleFactura.label', default: 'SqtDetalleFactura'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleFactura.label', default: 'SqtDetalleFactura'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
