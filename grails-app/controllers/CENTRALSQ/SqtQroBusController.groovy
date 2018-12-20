package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtQroBusController {

    SqtQroBusService sqtQroBusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtQroBusService.list(params), model:[sqtQroBusCount: sqtQroBusService.count()]
    }

    def show(Long id) {
        respond sqtQroBusService.get(id)
    }

    def create() {
        respond new SqtQroBus(params)
    }

    def save(SqtQroBus sqtQroBus) {
        if (sqtQroBus == null) {
            notFound()
            return
        }

        try {
            sqtQroBusService.save(sqtQroBus)
        } catch (ValidationException e) {
            respond sqtQroBus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtQroBus.label', default: 'SqtQroBus'), sqtQroBus.id])
                redirect sqtQroBus
            }
            '*' { respond sqtQroBus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtQroBusService.get(id)
    }

    def update(SqtQroBus sqtQroBus) {
        if (sqtQroBus == null) {
            notFound()
            return
        }

        try {
            sqtQroBusService.save(sqtQroBus)
        } catch (ValidationException e) {
            respond sqtQroBus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtQroBus.label', default: 'SqtQroBus'), sqtQroBus.id])
                redirect sqtQroBus
            }
            '*'{ respond sqtQroBus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtQroBusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtQroBus.label', default: 'SqtQroBus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtQroBus.label', default: 'SqtQroBus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
