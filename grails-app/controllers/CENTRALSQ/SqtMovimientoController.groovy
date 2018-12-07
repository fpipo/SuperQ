package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMovimientoController {

    SqtMovimientoService sqtMovimientoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMovimientoService.list(params), model:[sqtMovimientoCount: sqtMovimientoService.count()]
    }

    def show(Long id) {
        respond sqtMovimientoService.get(id)
    }

    def create() {
        respond new SqtMovimiento(params)
    }

    def save(SqtMovimiento sqtMovimiento) {
        if (sqtMovimiento == null) {
            notFound()
            return
        }

        try {
            sqtMovimientoService.save(sqtMovimiento)
        } catch (ValidationException e) {
            respond sqtMovimiento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMovimiento.label', default: 'SqtMovimiento'), sqtMovimiento.id])
                redirect sqtMovimiento
            }
            '*' { respond sqtMovimiento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMovimientoService.get(id)
    }

    def update(SqtMovimiento sqtMovimiento) {
        if (sqtMovimiento == null) {
            notFound()
            return
        }

        try {
            sqtMovimientoService.save(sqtMovimiento)
        } catch (ValidationException e) {
            respond sqtMovimiento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMovimiento.label', default: 'SqtMovimiento'), sqtMovimiento.id])
                redirect sqtMovimiento
            }
            '*'{ respond sqtMovimiento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMovimientoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMovimiento.label', default: 'SqtMovimiento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMovimiento.label', default: 'SqtMovimiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
