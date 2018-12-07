package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtNuevaCategorizacionController {

    SqtNuevaCategorizacionService sqtNuevaCategorizacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtNuevaCategorizacionService.list(params), model:[sqtNuevaCategorizacionCount: sqtNuevaCategorizacionService.count()]
    }

    def show(Long id) {
        respond sqtNuevaCategorizacionService.get(id)
    }

    def create() {
        respond new SqtNuevaCategorizacion(params)
    }

    def save(SqtNuevaCategorizacion sqtNuevaCategorizacion) {
        if (sqtNuevaCategorizacion == null) {
            notFound()
            return
        }

        try {
            sqtNuevaCategorizacionService.save(sqtNuevaCategorizacion)
        } catch (ValidationException e) {
            respond sqtNuevaCategorizacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtNuevaCategorizacion.label', default: 'SqtNuevaCategorizacion'), sqtNuevaCategorizacion.id])
                redirect sqtNuevaCategorizacion
            }
            '*' { respond sqtNuevaCategorizacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtNuevaCategorizacionService.get(id)
    }

    def update(SqtNuevaCategorizacion sqtNuevaCategorizacion) {
        if (sqtNuevaCategorizacion == null) {
            notFound()
            return
        }

        try {
            sqtNuevaCategorizacionService.save(sqtNuevaCategorizacion)
        } catch (ValidationException e) {
            respond sqtNuevaCategorizacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtNuevaCategorizacion.label', default: 'SqtNuevaCategorizacion'), sqtNuevaCategorizacion.id])
                redirect sqtNuevaCategorizacion
            }
            '*'{ respond sqtNuevaCategorizacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtNuevaCategorizacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtNuevaCategorizacion.label', default: 'SqtNuevaCategorizacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtNuevaCategorizacion.label', default: 'SqtNuevaCategorizacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
