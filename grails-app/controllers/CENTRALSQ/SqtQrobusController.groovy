package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtQrobusController {

    SqtQrobusService sqtQrobusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtQrobusService.list(params), model:[sqtQrobusCount: sqtQrobusService.count()]
    }

    def show(Long id) {
        respond sqtQrobusService.get(id)
    }

    def create() {
        respond new SqtQrobus(params)
    }

    def save(SqtQrobus sqtQrobus) {
        if (sqtQrobus == null) {
            notFound()
            return
        }

        try {
            sqtQrobusService.save(sqtQrobus)
        } catch (ValidationException e) {
            respond sqtQrobus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtQrobus.label', default: 'SqtQrobus'), sqtQrobus.id])
                redirect sqtQrobus
            }
            '*' { respond sqtQrobus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtQrobusService.get(id)
    }

    def update(SqtQrobus sqtQrobus) {
        if (sqtQrobus == null) {
            notFound()
            return
        }

        try {
            sqtQrobusService.save(sqtQrobus)
        } catch (ValidationException e) {
            respond sqtQrobus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtQrobus.label', default: 'SqtQrobus'), sqtQrobus.id])
                redirect sqtQrobus
            }
            '*'{ respond sqtQrobus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtQrobusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtQrobus.label', default: 'SqtQrobus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtQrobus.label', default: 'SqtQrobus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
