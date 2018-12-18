package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAutorizaMovimientoController {

    SqtAutorizaMovimientoService sqtAutorizaMovimientoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAutorizaMovimientoService.list(params), model:[sqtAutorizaMovimientoCount: sqtAutorizaMovimientoService.count()]
    }

    def show(Long id) {
        respond sqtAutorizaMovimientoService.get(id)
    }

    def create() {
        respond new SqtAutorizaMovimiento(params)
    }

    def save(SqtAutorizaMovimiento sqtAutorizaMovimiento) {
        if (sqtAutorizaMovimiento == null) {
            notFound()
            return
        }

        try {
            sqtAutorizaMovimientoService.save(sqtAutorizaMovimiento)
        } catch (ValidationException e) {
            respond sqtAutorizaMovimiento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAutorizaMovimiento.label', default: 'SqtAutorizaMovimiento'), sqtAutorizaMovimiento.id])
                redirect sqtAutorizaMovimiento
            }
            '*' { respond sqtAutorizaMovimiento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAutorizaMovimientoService.get(id)
    }

    def update(SqtAutorizaMovimiento sqtAutorizaMovimiento) {
        if (sqtAutorizaMovimiento == null) {
            notFound()
            return
        }

        try {
            sqtAutorizaMovimientoService.save(sqtAutorizaMovimiento)
        } catch (ValidationException e) {
            respond sqtAutorizaMovimiento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAutorizaMovimiento.label', default: 'SqtAutorizaMovimiento'), sqtAutorizaMovimiento.id])
                redirect sqtAutorizaMovimiento
            }
            '*'{ respond sqtAutorizaMovimiento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAutorizaMovimientoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAutorizaMovimiento.label', default: 'SqtAutorizaMovimiento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAutorizaMovimiento.label', default: 'SqtAutorizaMovimiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
