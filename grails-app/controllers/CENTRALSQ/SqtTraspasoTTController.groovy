package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTraspasoTTController {

    SqtTraspasoTTService sqtTraspasoTTService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTraspasoTTService.list(params), model:[sqtTraspasoTTCount: sqtTraspasoTTService.count()]
    }

    def show(Long id) {
        respond sqtTraspasoTTService.get(id)
    }

    def create() {
        respond new SqtTraspasoTT(params)
    }

    def save(SqtTraspasoTT sqtTraspasoTT) {
        if (sqtTraspasoTT == null) {
            notFound()
            return
        }

        try {
            sqtTraspasoTTService.save(sqtTraspasoTT)
        } catch (ValidationException e) {
            respond sqtTraspasoTT.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTraspasoTT.label', default: 'SqtTraspasoTT'), sqtTraspasoTT.id])
                redirect sqtTraspasoTT
            }
            '*' { respond sqtTraspasoTT, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTraspasoTTService.get(id)
    }

    def update(SqtTraspasoTT sqtTraspasoTT) {
        if (sqtTraspasoTT == null) {
            notFound()
            return
        }

        try {
            sqtTraspasoTTService.save(sqtTraspasoTT)
        } catch (ValidationException e) {
            respond sqtTraspasoTT.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTraspasoTT.label', default: 'SqtTraspasoTT'), sqtTraspasoTT.id])
                redirect sqtTraspasoTT
            }
            '*'{ respond sqtTraspasoTT, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTraspasoTTService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTraspasoTT.label', default: 'SqtTraspasoTT'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTraspasoTT.label', default: 'SqtTraspasoTT'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
