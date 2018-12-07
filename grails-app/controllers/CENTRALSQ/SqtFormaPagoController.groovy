package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtFormaPagoController {

    SqtFormaPagoService sqtFormaPagoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtFormaPagoService.list(params), model:[sqtFormaPagoCount: sqtFormaPagoService.count()]
    }

    def show(Long id) {
        respond sqtFormaPagoService.get(id)
    }

    def create() {
        respond new SqtFormaPago(params)
    }

    def save(SqtFormaPago sqtFormaPago) {
        if (sqtFormaPago == null) {
            notFound()
            return
        }

        try {
            sqtFormaPagoService.save(sqtFormaPago)
        } catch (ValidationException e) {
            respond sqtFormaPago.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtFormaPago.label', default: 'SqtFormaPago'), sqtFormaPago.id])
                redirect sqtFormaPago
            }
            '*' { respond sqtFormaPago, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtFormaPagoService.get(id)
    }

    def update(SqtFormaPago sqtFormaPago) {
        if (sqtFormaPago == null) {
            notFound()
            return
        }

        try {
            sqtFormaPagoService.save(sqtFormaPago)
        } catch (ValidationException e) {
            respond sqtFormaPago.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtFormaPago.label', default: 'SqtFormaPago'), sqtFormaPago.id])
                redirect sqtFormaPago
            }
            '*'{ respond sqtFormaPago, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtFormaPagoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtFormaPago.label', default: 'SqtFormaPago'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtFormaPago.label', default: 'SqtFormaPago'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
