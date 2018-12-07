package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtEstatusController {

    SqtEstatusService sqtEstatusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtEstatusService.list(params), model:[sqtEstatusCount: sqtEstatusService.count()]
    }

    def show(Long id) {
        respond sqtEstatusService.get(id)
    }

    def create() {
        respond new SqtEstatus(params)
    }

    def save(SqtEstatus sqtEstatus) {
        if (sqtEstatus == null) {
            notFound()
            return
        }

        try {
            sqtEstatusService.save(sqtEstatus)
        } catch (ValidationException e) {
            respond sqtEstatus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtEstatus.label', default: 'SqtEstatus'), sqtEstatus.id])
                redirect sqtEstatus
            }
            '*' { respond sqtEstatus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtEstatusService.get(id)
    }

    def update(SqtEstatus sqtEstatus) {
        if (sqtEstatus == null) {
            notFound()
            return
        }

        try {
            sqtEstatusService.save(sqtEstatus)
        } catch (ValidationException e) {
            respond sqtEstatus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtEstatus.label', default: 'SqtEstatus'), sqtEstatus.id])
                redirect sqtEstatus
            }
            '*'{ respond sqtEstatus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtEstatusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtEstatus.label', default: 'SqtEstatus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtEstatus.label', default: 'SqtEstatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
