package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtNsegmentoController {

    SqtNsegmentoService sqtNsegmentoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtNsegmentoService.list(params), model:[sqtNsegmentoCount: sqtNsegmentoService.count()]
    }

    def show(Long id) {
        respond sqtNsegmentoService.get(id)
    }

    def create() {
        respond new SqtNsegmento(params)
    }

    def save(SqtNsegmento sqtNsegmento) {
        if (sqtNsegmento == null) {
            notFound()
            return
        }

        try {
            sqtNsegmentoService.save(sqtNsegmento)
        } catch (ValidationException e) {
            respond sqtNsegmento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtNsegmento.label', default: 'SqtNsegmento'), sqtNsegmento.id])
                redirect sqtNsegmento
            }
            '*' { respond sqtNsegmento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtNsegmentoService.get(id)
    }

    def update(SqtNsegmento sqtNsegmento) {
        if (sqtNsegmento == null) {
            notFound()
            return
        }

        try {
            sqtNsegmentoService.save(sqtNsegmento)
        } catch (ValidationException e) {
            respond sqtNsegmento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtNsegmento.label', default: 'SqtNsegmento'), sqtNsegmento.id])
                redirect sqtNsegmento
            }
            '*'{ respond sqtNsegmento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtNsegmentoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtNsegmento.label', default: 'SqtNsegmento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtNsegmento.label', default: 'SqtNsegmento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
