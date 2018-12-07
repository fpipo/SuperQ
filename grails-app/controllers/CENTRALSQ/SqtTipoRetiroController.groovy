package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTipoRetiroController {

    SqtTipoRetiroService sqtTipoRetiroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTipoRetiroService.list(params), model:[sqtTipoRetiroCount: sqtTipoRetiroService.count()]
    }

    def show(Long id) {
        respond sqtTipoRetiroService.get(id)
    }

    def create() {
        respond new SqtTipoRetiro(params)
    }

    def save(SqtTipoRetiro sqtTipoRetiro) {
        if (sqtTipoRetiro == null) {
            notFound()
            return
        }

        try {
            sqtTipoRetiroService.save(sqtTipoRetiro)
        } catch (ValidationException e) {
            respond sqtTipoRetiro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTipoRetiro.label', default: 'SqtTipoRetiro'), sqtTipoRetiro.id])
                redirect sqtTipoRetiro
            }
            '*' { respond sqtTipoRetiro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTipoRetiroService.get(id)
    }

    def update(SqtTipoRetiro sqtTipoRetiro) {
        if (sqtTipoRetiro == null) {
            notFound()
            return
        }

        try {
            sqtTipoRetiroService.save(sqtTipoRetiro)
        } catch (ValidationException e) {
            respond sqtTipoRetiro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTipoRetiro.label', default: 'SqtTipoRetiro'), sqtTipoRetiro.id])
                redirect sqtTipoRetiro
            }
            '*'{ respond sqtTipoRetiro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTipoRetiroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTipoRetiro.label', default: 'SqtTipoRetiro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTipoRetiro.label', default: 'SqtTipoRetiro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
