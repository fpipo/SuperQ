package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDepositoCierreController {

    SqtDepositoCierreService sqtDepositoCierreService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDepositoCierreService.list(params), model:[sqtDepositoCierreCount: sqtDepositoCierreService.count()]
    }

    def show(Long id) {
        respond sqtDepositoCierreService.get(id)
    }

    def create() {
        respond new SqtDepositoCierre(params)
    }

    def save(SqtDepositoCierre sqtDepositoCierre) {
        if (sqtDepositoCierre == null) {
            notFound()
            return
        }

        try {
            sqtDepositoCierreService.save(sqtDepositoCierre)
        } catch (ValidationException e) {
            respond sqtDepositoCierre.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDepositoCierre.label', default: 'SqtDepositoCierre'), sqtDepositoCierre.id])
                redirect sqtDepositoCierre
            }
            '*' { respond sqtDepositoCierre, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDepositoCierreService.get(id)
    }

    def update(SqtDepositoCierre sqtDepositoCierre) {
        if (sqtDepositoCierre == null) {
            notFound()
            return
        }

        try {
            sqtDepositoCierreService.save(sqtDepositoCierre)
        } catch (ValidationException e) {
            respond sqtDepositoCierre.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDepositoCierre.label', default: 'SqtDepositoCierre'), sqtDepositoCierre.id])
                redirect sqtDepositoCierre
            }
            '*'{ respond sqtDepositoCierre, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDepositoCierreService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDepositoCierre.label', default: 'SqtDepositoCierre'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDepositoCierre.label', default: 'SqtDepositoCierre'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
