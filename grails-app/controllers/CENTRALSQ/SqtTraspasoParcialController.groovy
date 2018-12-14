package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTraspasoParcialController {

    SqtTraspasoParcialService sqtTraspasoParcialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTraspasoParcialService.list(params), model:[sqtTraspasoParcialCount: sqtTraspasoParcialService.count()]
    }

    def show(Long id) {
        respond sqtTraspasoParcialService.get(id)
    }

    def create() {
        respond new SqtTraspasoParcial(params)
    }

    def save(SqtTraspasoParcial sqtTraspasoParcial) {
        if (sqtTraspasoParcial == null) {
            notFound()
            return
        }

        try {
            sqtTraspasoParcialService.save(sqtTraspasoParcial)
        } catch (ValidationException e) {
            respond sqtTraspasoParcial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTraspasoParcial.label', default: 'SqtTraspasoParcial'), sqtTraspasoParcial.id])
                redirect sqtTraspasoParcial
            }
            '*' { respond sqtTraspasoParcial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTraspasoParcialService.get(id)
    }

    def update(SqtTraspasoParcial sqtTraspasoParcial) {
        if (sqtTraspasoParcial == null) {
            notFound()
            return
        }

        try {
            sqtTraspasoParcialService.save(sqtTraspasoParcial)
        } catch (ValidationException e) {
            respond sqtTraspasoParcial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTraspasoParcial.label', default: 'SqtTraspasoParcial'), sqtTraspasoParcial.id])
                redirect sqtTraspasoParcial
            }
            '*'{ respond sqtTraspasoParcial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTraspasoParcialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTraspasoParcial.label', default: 'SqtTraspasoParcial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTraspasoParcial.label', default: 'SqtTraspasoParcial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
