package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMovimientoContableController {

    SqtMovimientoContableService sqtMovimientoContableService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMovimientoContableService.list(params), model:[sqtMovimientoContableCount: sqtMovimientoContableService.count()]
    }

    def show(Long id) {
        respond sqtMovimientoContableService.get(id)
    }

    def create() {
        respond new SqtMovimientoContable(params)
    }

    def save(SqtMovimientoContable sqtMovimientoContable) {
        if (sqtMovimientoContable == null) {
            notFound()
            return
        }

        try {
            sqtMovimientoContableService.save(sqtMovimientoContable)
        } catch (ValidationException e) {
            respond sqtMovimientoContable.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMovimientoContable.label', default: 'SqtMovimientoContable'), sqtMovimientoContable.id])
                redirect sqtMovimientoContable
            }
            '*' { respond sqtMovimientoContable, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMovimientoContableService.get(id)
    }

    def update(SqtMovimientoContable sqtMovimientoContable) {
        if (sqtMovimientoContable == null) {
            notFound()
            return
        }

        try {
            sqtMovimientoContableService.save(sqtMovimientoContable)
        } catch (ValidationException e) {
            respond sqtMovimientoContable.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMovimientoContable.label', default: 'SqtMovimientoContable'), sqtMovimientoContable.id])
                redirect sqtMovimientoContable
            }
            '*'{ respond sqtMovimientoContable, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMovimientoContableService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMovimientoContable.label', default: 'SqtMovimientoContable'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMovimientoContable.label', default: 'SqtMovimientoContable'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
