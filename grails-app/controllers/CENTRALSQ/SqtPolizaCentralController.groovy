package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPolizaCentralController {

    SqtPolizaCentralService sqtPolizaCentralService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPolizaCentralService.list(params), model:[sqtPolizaCentralCount: sqtPolizaCentralService.count()]
    }

    def show(Long id) {
        respond sqtPolizaCentralService.get(id)
    }

    def create() {
        respond new SqtPolizaCentral(params)
    }

    def save(SqtPolizaCentral sqtPolizaCentral) {
        if (sqtPolizaCentral == null) {
            notFound()
            return
        }

        try {
            sqtPolizaCentralService.save(sqtPolizaCentral)
        } catch (ValidationException e) {
            respond sqtPolizaCentral.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPolizaCentral.label', default: 'SqtPolizaCentral'), sqtPolizaCentral.id])
                redirect sqtPolizaCentral
            }
            '*' { respond sqtPolizaCentral, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPolizaCentralService.get(id)
    }

    def update(SqtPolizaCentral sqtPolizaCentral) {
        if (sqtPolizaCentral == null) {
            notFound()
            return
        }

        try {
            sqtPolizaCentralService.save(sqtPolizaCentral)
        } catch (ValidationException e) {
            respond sqtPolizaCentral.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPolizaCentral.label', default: 'SqtPolizaCentral'), sqtPolizaCentral.id])
                redirect sqtPolizaCentral
            }
            '*'{ respond sqtPolizaCentral, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPolizaCentralService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPolizaCentral.label', default: 'SqtPolizaCentral'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPolizaCentral.label', default: 'SqtPolizaCentral'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
