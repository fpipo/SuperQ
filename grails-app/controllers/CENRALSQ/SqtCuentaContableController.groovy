package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCuentaContableController {

    SqtCuentaContableService sqtCuentaContableService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCuentaContableService.list(params), model:[sqtCuentaContableCount: sqtCuentaContableService.count()]
    }

    def show(Long id) {
        respond sqtCuentaContableService.get(id)
    }

    def create() {
        respond new SqtCuentaContable(params)
    }

    def save(SqtCuentaContable sqtCuentaContable) {
        if (sqtCuentaContable == null) {
            notFound()
            return
        }

        try {
            sqtCuentaContableService.save(sqtCuentaContable)
        } catch (ValidationException e) {
            respond sqtCuentaContable.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCuentaContable.label', default: 'SqtCuentaContable'), sqtCuentaContable.id])
                redirect sqtCuentaContable
            }
            '*' { respond sqtCuentaContable, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCuentaContableService.get(id)
    }

    def update(SqtCuentaContable sqtCuentaContable) {
        if (sqtCuentaContable == null) {
            notFound()
            return
        }

        try {
            sqtCuentaContableService.save(sqtCuentaContable)
        } catch (ValidationException e) {
            respond sqtCuentaContable.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCuentaContable.label', default: 'SqtCuentaContable'), sqtCuentaContable.id])
                redirect sqtCuentaContable
            }
            '*'{ respond sqtCuentaContable, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCuentaContableService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCuentaContable.label', default: 'SqtCuentaContable'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCuentaContable.label', default: 'SqtCuentaContable'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
