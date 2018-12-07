package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtFacturaController {

    SqtFacturaService sqtFacturaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtFacturaService.list(params), model:[sqtFacturaCount: sqtFacturaService.count()]
    }

    def show(Long id) {
        respond sqtFacturaService.get(id)
    }

    def create() {
        respond new SqtFactura(params)
    }

    def save(SqtFactura sqtFactura) {
        if (sqtFactura == null) {
            notFound()
            return
        }

        try {
            sqtFacturaService.save(sqtFactura)
        } catch (ValidationException e) {
            respond sqtFactura.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtFactura.label', default: 'SqtFactura'), sqtFactura.id])
                redirect sqtFactura
            }
            '*' { respond sqtFactura, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtFacturaService.get(id)
    }

    def update(SqtFactura sqtFactura) {
        if (sqtFactura == null) {
            notFound()
            return
        }

        try {
            sqtFacturaService.save(sqtFactura)
        } catch (ValidationException e) {
            respond sqtFactura.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtFactura.label', default: 'SqtFactura'), sqtFactura.id])
                redirect sqtFactura
            }
            '*'{ respond sqtFactura, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtFacturaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtFactura.label', default: 'SqtFactura'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtFactura.label', default: 'SqtFactura'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
