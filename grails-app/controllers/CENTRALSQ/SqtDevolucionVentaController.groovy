package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDevolucionVentaController {

    SqtDevolucionVentaService sqtDevolucionVentaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDevolucionVentaService.list(params), model:[sqtDevolucionVentaCount: sqtDevolucionVentaService.count()]
    }

    def show(Long id) {
        respond sqtDevolucionVentaService.get(id)
    }

    def create() {
        respond new SqtDevolucionVenta(params)
    }

    def save(SqtDevolucionVenta sqtDevolucionVenta) {
        if (sqtDevolucionVenta == null) {
            notFound()
            return
        }

        try {
            sqtDevolucionVentaService.save(sqtDevolucionVenta)
        } catch (ValidationException e) {
            respond sqtDevolucionVenta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDevolucionVenta.label', default: 'SqtDevolucionVenta'), sqtDevolucionVenta.id])
                redirect sqtDevolucionVenta
            }
            '*' { respond sqtDevolucionVenta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDevolucionVentaService.get(id)
    }

    def update(SqtDevolucionVenta sqtDevolucionVenta) {
        if (sqtDevolucionVenta == null) {
            notFound()
            return
        }

        try {
            sqtDevolucionVentaService.save(sqtDevolucionVenta)
        } catch (ValidationException e) {
            respond sqtDevolucionVenta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDevolucionVenta.label', default: 'SqtDevolucionVenta'), sqtDevolucionVenta.id])
                redirect sqtDevolucionVenta
            }
            '*'{ respond sqtDevolucionVenta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDevolucionVentaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDevolucionVenta.label', default: 'SqtDevolucionVenta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDevolucionVenta.label', default: 'SqtDevolucionVenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
