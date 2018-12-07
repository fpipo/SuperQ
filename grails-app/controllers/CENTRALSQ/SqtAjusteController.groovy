package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAjusteController {

    SqtAjusteService sqtAjusteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAjusteService.list(params), model:[sqtAjusteCount: sqtAjusteService.count()]
    }

    def show(Long id) {
        respond sqtAjusteService.get(id)
    }

    def create() {
        respond new SqtAjuste(params)
    }

    def save(SqtAjuste sqtAjuste) {
        if (sqtAjuste == null) {
            notFound()
            return
        }

        try {
            sqtAjusteService.save(sqtAjuste)
        } catch (ValidationException e) {
            respond sqtAjuste.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAjuste.label', default: 'SqtAjuste'), sqtAjuste.id])
                redirect sqtAjuste
            }
            '*' { respond sqtAjuste, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAjusteService.get(id)
    }

    def update(SqtAjuste sqtAjuste) {
        if (sqtAjuste == null) {
            notFound()
            return
        }

        try {
            sqtAjusteService.save(sqtAjuste)
        } catch (ValidationException e) {
            respond sqtAjuste.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAjuste.label', default: 'SqtAjuste'), sqtAjuste.id])
                redirect sqtAjuste
            }
            '*'{ respond sqtAjuste, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAjusteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAjuste.label', default: 'SqtAjuste'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAjuste.label', default: 'SqtAjuste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
