package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtReembolsoController {

    SqtReembolsoService sqtReembolsoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtReembolsoService.list(params), model:[sqtReembolsoCount: sqtReembolsoService.count()]
    }

    def show(Long id) {
        respond sqtReembolsoService.get(id)
    }

    def create() {
        respond new SqtReembolso(params)
    }

    def save(SqtReembolso sqtReembolso) {
        if (sqtReembolso == null) {
            notFound()
            return
        }

        try {
            sqtReembolsoService.save(sqtReembolso)
        } catch (ValidationException e) {
            respond sqtReembolso.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtReembolso.label', default: 'SqtReembolso'), sqtReembolso.id])
                redirect sqtReembolso
            }
            '*' { respond sqtReembolso, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtReembolsoService.get(id)
    }

    def update(SqtReembolso sqtReembolso) {
        if (sqtReembolso == null) {
            notFound()
            return
        }

        try {
            sqtReembolsoService.save(sqtReembolso)
        } catch (ValidationException e) {
            respond sqtReembolso.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtReembolso.label', default: 'SqtReembolso'), sqtReembolso.id])
                redirect sqtReembolso
            }
            '*'{ respond sqtReembolso, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtReembolsoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtReembolso.label', default: 'SqtReembolso'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtReembolso.label', default: 'SqtReembolso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
