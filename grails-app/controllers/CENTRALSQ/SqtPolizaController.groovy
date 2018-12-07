package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPolizaController {

    SqtPolizaService sqtPolizaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPolizaService.list(params), model:[sqtPolizaCount: sqtPolizaService.count()]
    }

    def show(Long id) {
        respond sqtPolizaService.get(id)
    }

    def create() {
        respond new SqtPoliza(params)
    }

    def save(SqtPoliza sqtPoliza) {
        if (sqtPoliza == null) {
            notFound()
            return
        }

        try {
            sqtPolizaService.save(sqtPoliza)
        } catch (ValidationException e) {
            respond sqtPoliza.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPoliza.label', default: 'SqtPoliza'), sqtPoliza.id])
                redirect sqtPoliza
            }
            '*' { respond sqtPoliza, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPolizaService.get(id)
    }

    def update(SqtPoliza sqtPoliza) {
        if (sqtPoliza == null) {
            notFound()
            return
        }

        try {
            sqtPolizaService.save(sqtPoliza)
        } catch (ValidationException e) {
            respond sqtPoliza.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPoliza.label', default: 'SqtPoliza'), sqtPoliza.id])
                redirect sqtPoliza
            }
            '*'{ respond sqtPoliza, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPolizaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPoliza.label', default: 'SqtPoliza'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPoliza.label', default: 'SqtPoliza'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
