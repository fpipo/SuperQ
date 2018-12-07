package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtImpuestoController {

    SqtImpuestoService sqtImpuestoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtImpuestoService.list(params), model:[sqtImpuestoCount: sqtImpuestoService.count()]
    }

    def show(Long id) {
        respond sqtImpuestoService.get(id)
    }

    def create() {
        respond new SqtImpuesto(params)
    }

    def save(SqtImpuesto sqtImpuesto) {
        if (sqtImpuesto == null) {
            notFound()
            return
        }

        try {
            sqtImpuestoService.save(sqtImpuesto)
        } catch (ValidationException e) {
            respond sqtImpuesto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtImpuesto.label', default: 'SqtImpuesto'), sqtImpuesto.id])
                redirect sqtImpuesto
            }
            '*' { respond sqtImpuesto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtImpuestoService.get(id)
    }

    def update(SqtImpuesto sqtImpuesto) {
        if (sqtImpuesto == null) {
            notFound()
            return
        }

        try {
            sqtImpuestoService.save(sqtImpuesto)
        } catch (ValidationException e) {
            respond sqtImpuesto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtImpuesto.label', default: 'SqtImpuesto'), sqtImpuesto.id])
                redirect sqtImpuesto
            }
            '*'{ respond sqtImpuesto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtImpuestoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtImpuesto.label', default: 'SqtImpuesto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtImpuesto.label', default: 'SqtImpuesto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
