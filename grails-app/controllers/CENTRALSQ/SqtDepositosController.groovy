package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDepositosController {

    SqtDepositosService sqtDepositosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDepositosService.list(params), model:[sqtDepositosCount: sqtDepositosService.count()]
    }

    def show(Long id) {
        respond sqtDepositosService.get(id)
    }

    def create() {
        respond new SqtDepositos(params)
    }

    def save(SqtDepositos sqtDepositos) {
        if (sqtDepositos == null) {
            notFound()
            return
        }

        try {
            sqtDepositosService.save(sqtDepositos)
        } catch (ValidationException e) {
            respond sqtDepositos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDepositos.label', default: 'SqtDepositos'), sqtDepositos.id])
                redirect sqtDepositos
            }
            '*' { respond sqtDepositos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDepositosService.get(id)
    }

    def update(SqtDepositos sqtDepositos) {
        if (sqtDepositos == null) {
            notFound()
            return
        }

        try {
            sqtDepositosService.save(sqtDepositos)
        } catch (ValidationException e) {
            respond sqtDepositos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDepositos.label', default: 'SqtDepositos'), sqtDepositos.id])
                redirect sqtDepositos
            }
            '*'{ respond sqtDepositos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDepositosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDepositos.label', default: 'SqtDepositos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDepositos.label', default: 'SqtDepositos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
