package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleIusaController {

    SqtDetalleIusaService sqtDetalleIusaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleIusaService.list(params), model:[sqtDetalleIusaCount: sqtDetalleIusaService.count()]
    }

    def show(Long id) {
        respond sqtDetalleIusaService.get(id)
    }

    def create() {
        respond new SqtDetalleIusa(params)
    }

    def save(SqtDetalleIusa sqtDetalleIusa) {
        if (sqtDetalleIusa == null) {
            notFound()
            return
        }

        try {
            sqtDetalleIusaService.save(sqtDetalleIusa)
        } catch (ValidationException e) {
            respond sqtDetalleIusa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleIusa.label', default: 'SqtDetalleIusa'), sqtDetalleIusa.id])
                redirect sqtDetalleIusa
            }
            '*' { respond sqtDetalleIusa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleIusaService.get(id)
    }

    def update(SqtDetalleIusa sqtDetalleIusa) {
        if (sqtDetalleIusa == null) {
            notFound()
            return
        }

        try {
            sqtDetalleIusaService.save(sqtDetalleIusa)
        } catch (ValidationException e) {
            respond sqtDetalleIusa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleIusa.label', default: 'SqtDetalleIusa'), sqtDetalleIusa.id])
                redirect sqtDetalleIusa
            }
            '*'{ respond sqtDetalleIusa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleIusaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleIusa.label', default: 'SqtDetalleIusa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleIusa.label', default: 'SqtDetalleIusa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
