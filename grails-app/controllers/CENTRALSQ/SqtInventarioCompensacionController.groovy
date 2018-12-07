package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioCompensacionController {

    SqtInventarioCompensacionService sqtInventarioCompensacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioCompensacionService.list(params), model:[sqtInventarioCompensacionCount: sqtInventarioCompensacionService.count()]
    }

    def show(Long id) {
        respond sqtInventarioCompensacionService.get(id)
    }

    def create() {
        respond new SqtInventarioCompensacion(params)
    }

    def save(SqtInventarioCompensacion sqtInventarioCompensacion) {
        if (sqtInventarioCompensacion == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCompensacionService.save(sqtInventarioCompensacion)
        } catch (ValidationException e) {
            respond sqtInventarioCompensacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioCompensacion.label', default: 'SqtInventarioCompensacion'), sqtInventarioCompensacion.id])
                redirect sqtInventarioCompensacion
            }
            '*' { respond sqtInventarioCompensacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioCompensacionService.get(id)
    }

    def update(SqtInventarioCompensacion sqtInventarioCompensacion) {
        if (sqtInventarioCompensacion == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCompensacionService.save(sqtInventarioCompensacion)
        } catch (ValidationException e) {
            respond sqtInventarioCompensacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioCompensacion.label', default: 'SqtInventarioCompensacion'), sqtInventarioCompensacion.id])
                redirect sqtInventarioCompensacion
            }
            '*'{ respond sqtInventarioCompensacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioCompensacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioCompensacion.label', default: 'SqtInventarioCompensacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioCompensacion.label', default: 'SqtInventarioCompensacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
