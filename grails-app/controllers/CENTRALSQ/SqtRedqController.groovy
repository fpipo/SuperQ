package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRedqController {

    SqtRedqService sqtRedqService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRedqService.list(params), model:[sqtRedqCount: sqtRedqService.count()]
    }

    def show(Long id) {
        respond sqtRedqService.get(id)
    }

    def create() {
        respond new SqtQroBus(params)
    }

    def save(SqtQroBus sqtRedq) {
        if (sqtRedq == null) {
            notFound()
            return
        }

        try {
            sqtRedqService.save(sqtRedq)
        } catch (ValidationException e) {
            respond sqtRedq.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRedq.label', default: 'SqtQroBus'), sqtRedq.id])
                redirect sqtRedq
            }
            '*' { respond sqtRedq, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRedqService.get(id)
    }

    def update(SqtQroBus sqtRedq) {
        if (sqtRedq == null) {
            notFound()
            return
        }

        try {
            sqtRedqService.save(sqtRedq)
        } catch (ValidationException e) {
            respond sqtRedq.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRedq.label', default: 'SqtQroBus'), sqtRedq.id])
                redirect sqtRedq
            }
            '*'{ respond sqtRedq, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRedqService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRedq.label', default: 'SqtQroBus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRedq.label', default: 'SqtQroBus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
