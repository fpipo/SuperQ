package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtComisionRangoController {

    SqtComisionRangoService sqtComisionRangoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtComisionRangoService.list(params), model:[sqtComisionRangoCount: sqtComisionRangoService.count()]
    }

    def show(Long id) {
        respond sqtComisionRangoService.get(id)
    }

    def create() {
        respond new SqtComisionRango(params)
    }

    def save(SqtComisionRango sqtComisionRango) {
        if (sqtComisionRango == null) {
            notFound()
            return
        }

        try {
            sqtComisionRangoService.save(sqtComisionRango)
        } catch (ValidationException e) {
            respond sqtComisionRango.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtComisionRango.label', default: 'SqtComisionRango'), sqtComisionRango.id])
                redirect sqtComisionRango
            }
            '*' { respond sqtComisionRango, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtComisionRangoService.get(id)
    }

    def update(SqtComisionRango sqtComisionRango) {
        if (sqtComisionRango == null) {
            notFound()
            return
        }

        try {
            sqtComisionRangoService.save(sqtComisionRango)
        } catch (ValidationException e) {
            respond sqtComisionRango.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtComisionRango.label', default: 'SqtComisionRango'), sqtComisionRango.id])
                redirect sqtComisionRango
            }
            '*'{ respond sqtComisionRango, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtComisionRangoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtComisionRango.label', default: 'SqtComisionRango'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtComisionRango.label', default: 'SqtComisionRango'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
