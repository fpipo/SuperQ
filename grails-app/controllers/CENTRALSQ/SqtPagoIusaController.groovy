package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPagoIusaController {

    SqtPagoIusaService sqtPagoIusaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPagoIusaService.list(params), model:[sqtPagoIusaCount: sqtPagoIusaService.count()]
    }

    def show(Long id) {
        respond sqtPagoIusaService.get(id)
    }

    def create() {
        respond new SqtPagoIusa(params)
    }

    def save(SqtPagoIusa sqtPagoIusa) {
        if (sqtPagoIusa == null) {
            notFound()
            return
        }

        try {
            sqtPagoIusaService.save(sqtPagoIusa)
        } catch (ValidationException e) {
            respond sqtPagoIusa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPagoIusa.label', default: 'SqtPagoIusa'), sqtPagoIusa.id])
                redirect sqtPagoIusa
            }
            '*' { respond sqtPagoIusa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPagoIusaService.get(id)
    }

    def update(SqtPagoIusa sqtPagoIusa) {
        if (sqtPagoIusa == null) {
            notFound()
            return
        }

        try {
            sqtPagoIusaService.save(sqtPagoIusa)
        } catch (ValidationException e) {
            respond sqtPagoIusa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPagoIusa.label', default: 'SqtPagoIusa'), sqtPagoIusa.id])
                redirect sqtPagoIusa
            }
            '*'{ respond sqtPagoIusa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPagoIusaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPagoIusa.label', default: 'SqtPagoIusa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPagoIusa.label', default: 'SqtPagoIusa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
