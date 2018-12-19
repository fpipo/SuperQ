package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtHistorialPagoIusaController {

    SqtHistorialPagoIusaService sqtHistorialPagoIusaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtHistorialPagoIusaService.list(params), model:[sqtHistorialPagoIusaCount: sqtHistorialPagoIusaService.count()]
    }

    def show(Long id) {
        respond sqtHistorialPagoIusaService.get(id)
    }

    def create() {
        respond new SqtHistorialPagoIusa(params)
    }

    def save(SqtHistorialPagoIusa sqtHistorialPagoIusa) {
        if (sqtHistorialPagoIusa == null) {
            notFound()
            return
        }

        try {
            sqtHistorialPagoIusaService.save(sqtHistorialPagoIusa)
        } catch (ValidationException e) {
            respond sqtHistorialPagoIusa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtHistorialPagoIusa.label', default: 'SqtHistorialPagoIusa'), sqtHistorialPagoIusa.id])
                redirect sqtHistorialPagoIusa
            }
            '*' { respond sqtHistorialPagoIusa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtHistorialPagoIusaService.get(id)
    }

    def update(SqtHistorialPagoIusa sqtHistorialPagoIusa) {
        if (sqtHistorialPagoIusa == null) {
            notFound()
            return
        }

        try {
            sqtHistorialPagoIusaService.save(sqtHistorialPagoIusa)
        } catch (ValidationException e) {
            respond sqtHistorialPagoIusa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtHistorialPagoIusa.label', default: 'SqtHistorialPagoIusa'), sqtHistorialPagoIusa.id])
                redirect sqtHistorialPagoIusa
            }
            '*'{ respond sqtHistorialPagoIusa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtHistorialPagoIusaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtHistorialPagoIusa.label', default: 'SqtHistorialPagoIusa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtHistorialPagoIusa.label', default: 'SqtHistorialPagoIusa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
