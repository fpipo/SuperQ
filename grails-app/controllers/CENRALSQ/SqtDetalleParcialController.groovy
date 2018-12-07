package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleParcialController {

    SqtDetalleParcialService sqtDetalleParcialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleParcialService.list(params), model:[sqtDetalleParcialCount: sqtDetalleParcialService.count()]
    }

    def show(Long id) {
        respond sqtDetalleParcialService.get(id)
    }

    def create() {
        respond new SqtDetalleParcial(params)
    }

    def save(SqtDetalleParcial sqtDetalleParcial) {
        if (sqtDetalleParcial == null) {
            notFound()
            return
        }

        try {
            sqtDetalleParcialService.save(sqtDetalleParcial)
        } catch (ValidationException e) {
            respond sqtDetalleParcial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleParcial.label', default: 'SqtDetalleParcial'), sqtDetalleParcial.id])
                redirect sqtDetalleParcial
            }
            '*' { respond sqtDetalleParcial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleParcialService.get(id)
    }

    def update(SqtDetalleParcial sqtDetalleParcial) {
        if (sqtDetalleParcial == null) {
            notFound()
            return
        }

        try {
            sqtDetalleParcialService.save(sqtDetalleParcial)
        } catch (ValidationException e) {
            respond sqtDetalleParcial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleParcial.label', default: 'SqtDetalleParcial'), sqtDetalleParcial.id])
                redirect sqtDetalleParcial
            }
            '*'{ respond sqtDetalleParcial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleParcialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleParcial.label', default: 'SqtDetalleParcial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleParcial.label', default: 'SqtDetalleParcial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
