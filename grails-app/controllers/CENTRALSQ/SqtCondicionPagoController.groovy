package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCondicionPagoController {

    SqtCondicionPagoService sqtCondicionPagoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCondicionPagoService.list(params), model:[sqtCondicionPagoCount: sqtCondicionPagoService.count()]
    }

    def show(Long id) {
        respond sqtCondicionPagoService.get(id)
    }

    def create() {
        respond new SqtCondicionPago(params)
    }

    def save(SqtCondicionPago sqtCondicionPago) {
        if (sqtCondicionPago == null) {
            notFound()
            return
        }

        try {
            sqtCondicionPagoService.save(sqtCondicionPago)
        } catch (ValidationException e) {
            respond sqtCondicionPago.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCondicionPago.label', default: 'SqtCondicionPago'), sqtCondicionPago.id])
                redirect sqtCondicionPago
            }
            '*' { respond sqtCondicionPago, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCondicionPagoService.get(id)
    }

    def update(SqtCondicionPago sqtCondicionPago) {
        if (sqtCondicionPago == null) {
            notFound()
            return
        }

        try {
            sqtCondicionPagoService.save(sqtCondicionPago)
        } catch (ValidationException e) {
            respond sqtCondicionPago.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCondicionPago.label', default: 'SqtCondicionPago'), sqtCondicionPago.id])
                redirect sqtCondicionPago
            }
            '*'{ respond sqtCondicionPago, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCondicionPagoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCondicionPago.label', default: 'SqtCondicionPago'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCondicionPago.label', default: 'SqtCondicionPago'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
