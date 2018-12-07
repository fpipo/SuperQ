package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDireccionController {

    SqtDireccionService sqtDireccionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDireccionService.list(params), model:[sqtDireccionCount: sqtDireccionService.count()]
    }

    def show(Long id) {
        respond sqtDireccionService.get(id)
    }

    def create() {
        respond new SqtDireccion(params)
    }

    def save(SqtDireccion sqtDireccion) {
        if (sqtDireccion == null) {
            notFound()
            return
        }

        try {
            sqtDireccionService.save(sqtDireccion)
        } catch (ValidationException e) {
            respond sqtDireccion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDireccion.label', default: 'SqtDireccion'), sqtDireccion.id])
                redirect sqtDireccion
            }
            '*' { respond sqtDireccion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDireccionService.get(id)
    }

    def update(SqtDireccion sqtDireccion) {
        if (sqtDireccion == null) {
            notFound()
            return
        }

        try {
            sqtDireccionService.save(sqtDireccion)
        } catch (ValidationException e) {
            respond sqtDireccion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDireccion.label', default: 'SqtDireccion'), sqtDireccion.id])
                redirect sqtDireccion
            }
            '*'{ respond sqtDireccion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDireccionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDireccion.label', default: 'SqtDireccion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDireccion.label', default: 'SqtDireccion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
