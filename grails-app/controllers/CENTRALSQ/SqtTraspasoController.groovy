package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTraspasoController {

    SqtTraspasoService sqtTraspasoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTraspasoService.list(params), model:[sqtTraspasoCount: sqtTraspasoService.count()]
    }

    def show(Long id) {
        respond sqtTraspasoService.get(id)
    }

    def create() {
        respond new SqtTraspaso(params)
    }

    def save(SqtTraspaso sqtTraspaso) {
        if (sqtTraspaso == null) {
            notFound()
            return
        }

        try {
            sqtTraspasoService.save(sqtTraspaso)
        } catch (ValidationException e) {
            respond sqtTraspaso.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTraspaso.label', default: 'SqtTraspaso'), sqtTraspaso.id])
                redirect sqtTraspaso
            }
            '*' { respond sqtTraspaso, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTraspasoService.get(id)
    }

    def update(SqtTraspaso sqtTraspaso) {
        if (sqtTraspaso == null) {
            notFound()
            return
        }

        try {
            sqtTraspasoService.save(sqtTraspaso)
        } catch (ValidationException e) {
            respond sqtTraspaso.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTraspaso.label', default: 'SqtTraspaso'), sqtTraspaso.id])
                redirect sqtTraspaso
            }
            '*'{ respond sqtTraspaso, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTraspasoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTraspaso.label', default: 'SqtTraspaso'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTraspaso.label', default: 'SqtTraspaso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
