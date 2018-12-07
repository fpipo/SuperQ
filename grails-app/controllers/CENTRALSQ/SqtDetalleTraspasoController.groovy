package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleTraspasoController {

    SqtDetalleTraspasoService sqtDetalleTraspasoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleTraspasoService.list(params), model:[sqtDetalleTraspasoCount: sqtDetalleTraspasoService.count()]
    }

    def show(Long id) {
        respond sqtDetalleTraspasoService.get(id)
    }

    def create() {
        respond new SqtDetalleTraspaso(params)
    }

    def save(SqtDetalleTraspaso sqtDetalleTraspaso) {
        if (sqtDetalleTraspaso == null) {
            notFound()
            return
        }

        try {
            sqtDetalleTraspasoService.save(sqtDetalleTraspaso)
        } catch (ValidationException e) {
            respond sqtDetalleTraspaso.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleTraspaso.label', default: 'SqtDetalleTraspaso'), sqtDetalleTraspaso.id])
                redirect sqtDetalleTraspaso
            }
            '*' { respond sqtDetalleTraspaso, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleTraspasoService.get(id)
    }

    def update(SqtDetalleTraspaso sqtDetalleTraspaso) {
        if (sqtDetalleTraspaso == null) {
            notFound()
            return
        }

        try {
            sqtDetalleTraspasoService.save(sqtDetalleTraspaso)
        } catch (ValidationException e) {
            respond sqtDetalleTraspaso.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleTraspaso.label', default: 'SqtDetalleTraspaso'), sqtDetalleTraspaso.id])
                redirect sqtDetalleTraspaso
            }
            '*'{ respond sqtDetalleTraspaso, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleTraspasoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleTraspaso.label', default: 'SqtDetalleTraspaso'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleTraspaso.label', default: 'SqtDetalleTraspaso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
