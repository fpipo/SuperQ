package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTipoController {

    SqtTipoService sqtTipoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTipoService.list(params), model:[sqtTipoCount: sqtTipoService.count()]
    }

    def show(Long id) {
        respond sqtTipoService.get(id)
    }

    def create() {
        respond new SqtTipo(params)
    }

    def save(SqtTipo sqtTipo) {
        if (sqtTipo == null) {
            notFound()
            return
        }

        try {
            sqtTipoService.save(sqtTipo)
        } catch (ValidationException e) {
            respond sqtTipo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTipo.label', default: 'SqtTipo'), sqtTipo.id])
                redirect sqtTipo
            }
            '*' { respond sqtTipo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTipoService.get(id)
    }

    def update(SqtTipo sqtTipo) {
        if (sqtTipo == null) {
            notFound()
            return
        }

        try {
            sqtTipoService.save(sqtTipo)
        } catch (ValidationException e) {
            respond sqtTipo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTipo.label', default: 'SqtTipo'), sqtTipo.id])
                redirect sqtTipo
            }
            '*'{ respond sqtTipo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTipoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTipo.label', default: 'SqtTipo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTipo.label', default: 'SqtTipo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
