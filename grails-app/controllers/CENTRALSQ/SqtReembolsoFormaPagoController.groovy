package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtReembolsoFormaPagoController {

    SqtReembolsoFormaPagoService sqtReembolsoFormaPagoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtReembolsoFormaPagoService.list(params), model:[sqtReembolsoFormaPagoCount: sqtReembolsoFormaPagoService.count()]
    }

    def show(Long id) {
        respond sqtReembolsoFormaPagoService.get(id)
    }

    def create() {
        respond new SqtReembolsoFormaPago(params)
    }

    def save(SqtReembolsoFormaPago sqtReembolsoFormaPago) {
        if (sqtReembolsoFormaPago == null) {
            notFound()
            return
        }

        try {
            sqtReembolsoFormaPagoService.save(sqtReembolsoFormaPago)
        } catch (ValidationException e) {
            respond sqtReembolsoFormaPago.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtReembolsoFormaPago.label', default: 'SqtReembolsoFormaPago'), sqtReembolsoFormaPago.id])
                redirect sqtReembolsoFormaPago
            }
            '*' { respond sqtReembolsoFormaPago, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtReembolsoFormaPagoService.get(id)
    }

    def update(SqtReembolsoFormaPago sqtReembolsoFormaPago) {
        if (sqtReembolsoFormaPago == null) {
            notFound()
            return
        }

        try {
            sqtReembolsoFormaPagoService.save(sqtReembolsoFormaPago)
        } catch (ValidationException e) {
            respond sqtReembolsoFormaPago.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtReembolsoFormaPago.label', default: 'SqtReembolsoFormaPago'), sqtReembolsoFormaPago.id])
                redirect sqtReembolsoFormaPago
            }
            '*'{ respond sqtReembolsoFormaPago, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtReembolsoFormaPagoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtReembolsoFormaPago.label', default: 'SqtReembolsoFormaPago'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtReembolsoFormaPago.label', default: 'SqtReembolsoFormaPago'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
