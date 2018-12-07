package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleCodigoCambioController {

    SqtDetalleCodigoCambioService sqtDetalleCodigoCambioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleCodigoCambioService.list(params), model:[sqtDetalleCodigoCambioCount: sqtDetalleCodigoCambioService.count()]
    }

    def show(Long id) {
        respond sqtDetalleCodigoCambioService.get(id)
    }

    def create() {
        respond new SqtDetalleCodigoCambio(params)
    }

    def save(SqtDetalleCodigoCambio sqtDetalleCodigoCambio) {
        if (sqtDetalleCodigoCambio == null) {
            notFound()
            return
        }

        try {
            sqtDetalleCodigoCambioService.save(sqtDetalleCodigoCambio)
        } catch (ValidationException e) {
            respond sqtDetalleCodigoCambio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleCodigoCambio.label', default: 'SqtDetalleCodigoCambio'), sqtDetalleCodigoCambio.id])
                redirect sqtDetalleCodigoCambio
            }
            '*' { respond sqtDetalleCodigoCambio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleCodigoCambioService.get(id)
    }

    def update(SqtDetalleCodigoCambio sqtDetalleCodigoCambio) {
        if (sqtDetalleCodigoCambio == null) {
            notFound()
            return
        }

        try {
            sqtDetalleCodigoCambioService.save(sqtDetalleCodigoCambio)
        } catch (ValidationException e) {
            respond sqtDetalleCodigoCambio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleCodigoCambio.label', default: 'SqtDetalleCodigoCambio'), sqtDetalleCodigoCambio.id])
                redirect sqtDetalleCodigoCambio
            }
            '*'{ respond sqtDetalleCodigoCambio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleCodigoCambioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleCodigoCambio.label', default: 'SqtDetalleCodigoCambio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleCodigoCambio.label', default: 'SqtDetalleCodigoCambio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
