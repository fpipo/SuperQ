package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCategoriaSqController {

    SqtCategoriaSqService sqtCategoriaSqService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCategoriaSqService.list(params), model:[sqtCategoriaSqCount: sqtCategoriaSqService.count()]
    }

    def show(Long id) {
        respond sqtCategoriaSqService.get(id)
    }

    def create() {
        respond new SqtCategoriaSq(params)
    }

    def save(SqtCategoriaSq sqtCategoriaSq) {
        if (sqtCategoriaSq == null) {
            notFound()
            return
        }

        try {
            sqtCategoriaSqService.save(sqtCategoriaSq)
        } catch (ValidationException e) {
            respond sqtCategoriaSq.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCategoriaSq.label', default: 'SqtCategoriaSq'), sqtCategoriaSq.id])
                redirect sqtCategoriaSq
            }
            '*' { respond sqtCategoriaSq, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCategoriaSqService.get(id)
    }

    def update(SqtCategoriaSq sqtCategoriaSq) {
        if (sqtCategoriaSq == null) {
            notFound()
            return
        }

        try {
            sqtCategoriaSqService.save(sqtCategoriaSq)
        } catch (ValidationException e) {
            respond sqtCategoriaSq.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCategoriaSq.label', default: 'SqtCategoriaSq'), sqtCategoriaSq.id])
                redirect sqtCategoriaSq
            }
            '*'{ respond sqtCategoriaSq, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCategoriaSqService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCategoriaSq.label', default: 'SqtCategoriaSq'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCategoriaSq.label', default: 'SqtCategoriaSq'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
