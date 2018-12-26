package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTransaccionTelController {

    SqtTransaccionTelService sqtTransaccionTelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTransaccionTelService.list(params), model:[sqtTransaccionTelCount: sqtTransaccionTelService.count()]
    }

    def show(Long id) {
        respond sqtTransaccionTelService.get(id)
    }

    def create() {
        respond new SqtTransaccionTel(params)
    }

    def save(SqtTransaccionTel sqtTransaccionTel) {
        if (sqtTransaccionTel == null) {
            notFound()
            return
        }

        try {
            sqtTransaccionTelService.save(sqtTransaccionTel)
        } catch (ValidationException e) {
            respond sqtTransaccionTel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTransaccionTel.label', default: 'SqtTransaccionTel'), sqtTransaccionTel.id])
                redirect sqtTransaccionTel
            }
            '*' { respond sqtTransaccionTel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTransaccionTelService.get(id)
    }

    def update(SqtTransaccionTel sqtTransaccionTel) {
        if (sqtTransaccionTel == null) {
            notFound()
            return
        }

        try {
            sqtTransaccionTelService.save(sqtTransaccionTel)
        } catch (ValidationException e) {
            respond sqtTransaccionTel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTransaccionTel.label', default: 'SqtTransaccionTel'), sqtTransaccionTel.id])
                redirect sqtTransaccionTel
            }
            '*'{ respond sqtTransaccionTel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTransaccionTelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTransaccionTel.label', default: 'SqtTransaccionTel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTransaccionTel.label', default: 'SqtTransaccionTel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
