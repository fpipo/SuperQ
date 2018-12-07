package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtBasculaController {

    SqtBasculaService sqtBasculaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtBasculaService.list(params), model:[sqtBasculaCount: sqtBasculaService.count()]
    }

    def show(Long id) {
        respond sqtBasculaService.get(id)
    }

    def create() {
        respond new SqtBascula(params)
    }

    def save(SqtBascula sqtBascula) {
        if (sqtBascula == null) {
            notFound()
            return
        }

        try {
            sqtBasculaService.save(sqtBascula)
        } catch (ValidationException e) {
            respond sqtBascula.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtBascula.label', default: 'SqtBascula'), sqtBascula.id])
                redirect sqtBascula
            }
            '*' { respond sqtBascula, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtBasculaService.get(id)
    }

    def update(SqtBascula sqtBascula) {
        if (sqtBascula == null) {
            notFound()
            return
        }

        try {
            sqtBasculaService.save(sqtBascula)
        } catch (ValidationException e) {
            respond sqtBascula.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtBascula.label', default: 'SqtBascula'), sqtBascula.id])
                redirect sqtBascula
            }
            '*'{ respond sqtBascula, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtBasculaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtBascula.label', default: 'SqtBascula'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtBascula.label', default: 'SqtBascula'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
