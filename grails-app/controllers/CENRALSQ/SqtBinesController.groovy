package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtBinesController {

    SqtBinesService sqtBinesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtBinesService.list(params), model:[sqtBinesCount: sqtBinesService.count()]
    }

    def show(Long id) {
        respond sqtBinesService.get(id)
    }

    def create() {
        respond new SqtBines(params)
    }

    def save(SqtBines sqtBines) {
        if (sqtBines == null) {
            notFound()
            return
        }

        try {
            sqtBinesService.save(sqtBines)
        } catch (ValidationException e) {
            respond sqtBines.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtBines.label', default: 'SqtBines'), sqtBines.id])
                redirect sqtBines
            }
            '*' { respond sqtBines, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtBinesService.get(id)
    }

    def update(SqtBines sqtBines) {
        if (sqtBines == null) {
            notFound()
            return
        }

        try {
            sqtBinesService.save(sqtBines)
        } catch (ValidationException e) {
            respond sqtBines.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtBines.label', default: 'SqtBines'), sqtBines.id])
                redirect sqtBines
            }
            '*'{ respond sqtBines, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtBinesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtBines.label', default: 'SqtBines'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtBines.label', default: 'SqtBines'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
