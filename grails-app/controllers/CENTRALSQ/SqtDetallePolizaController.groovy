package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetallePolizaController {

    SqtDetallePolizaService sqtDetallePolizaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetallePolizaService.list(params), model:[sqtDetallePolizaCount: sqtDetallePolizaService.count()]
    }

    def show(Long id) {
        respond sqtDetallePolizaService.get(id)
    }

    def create() {
        respond new SqtDetallePoliza(params)
    }

    def save(SqtDetallePoliza sqtDetallePoliza) {
        if (sqtDetallePoliza == null) {
            notFound()
            return
        }

        try {
            sqtDetallePolizaService.save(sqtDetallePoliza)
        } catch (ValidationException e) {
            respond sqtDetallePoliza.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetallePoliza.label', default: 'SqtDetallePoliza'), sqtDetallePoliza.id])
                redirect sqtDetallePoliza
            }
            '*' { respond sqtDetallePoliza, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetallePolizaService.get(id)
    }

    def update(SqtDetallePoliza sqtDetallePoliza) {
        if (sqtDetallePoliza == null) {
            notFound()
            return
        }

        try {
            sqtDetallePolizaService.save(sqtDetallePoliza)
        } catch (ValidationException e) {
            respond sqtDetallePoliza.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetallePoliza.label', default: 'SqtDetallePoliza'), sqtDetallePoliza.id])
                redirect sqtDetallePoliza
            }
            '*'{ respond sqtDetallePoliza, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetallePolizaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetallePoliza.label', default: 'SqtDetallePoliza'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetallePoliza.label', default: 'SqtDetallePoliza'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
