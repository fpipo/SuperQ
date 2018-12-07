package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCodigoCambioController {

    SqtCodigoCambioService sqtCodigoCambioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCodigoCambioService.list(params), model:[sqtCodigoCambioCount: sqtCodigoCambioService.count()]
    }

    def show(Long id) {
        respond sqtCodigoCambioService.get(id)
    }

    def create() {
        respond new SqtCodigoCambio(params)
    }

    def save(SqtCodigoCambio sqtCodigoCambio) {
        if (sqtCodigoCambio == null) {
            notFound()
            return
        }

        try {
            sqtCodigoCambioService.save(sqtCodigoCambio)
        } catch (ValidationException e) {
            respond sqtCodigoCambio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCodigoCambio.label', default: 'SqtCodigoCambio'), sqtCodigoCambio.id])
                redirect sqtCodigoCambio
            }
            '*' { respond sqtCodigoCambio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCodigoCambioService.get(id)
    }

    def update(SqtCodigoCambio sqtCodigoCambio) {
        if (sqtCodigoCambio == null) {
            notFound()
            return
        }

        try {
            sqtCodigoCambioService.save(sqtCodigoCambio)
        } catch (ValidationException e) {
            respond sqtCodigoCambio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCodigoCambio.label', default: 'SqtCodigoCambio'), sqtCodigoCambio.id])
                redirect sqtCodigoCambio
            }
            '*'{ respond sqtCodigoCambio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCodigoCambioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCodigoCambio.label', default: 'SqtCodigoCambio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCodigoCambio.label', default: 'SqtCodigoCambio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
