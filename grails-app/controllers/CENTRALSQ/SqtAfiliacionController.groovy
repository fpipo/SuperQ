package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAfiliacionController {

    SqtAfiliacionService sqtAfiliacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAfiliacionService.list(params), model:[sqtAfiliacionCount: sqtAfiliacionService.count()]
    }

    def show(Long id) {
        respond sqtAfiliacionService.get(id)
    }

    def create() {
        respond new SqtAfiliacion(params)
    }

    def save(SqtAfiliacion sqtAfiliacion) {
        if (sqtAfiliacion == null) {
            notFound()
            return
        }

        try {
            sqtAfiliacionService.save(sqtAfiliacion)
        } catch (ValidationException e) {
            respond sqtAfiliacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAfiliacion.label', default: 'SqtAfiliacion'), sqtAfiliacion.id])
                redirect sqtAfiliacion
            }
            '*' { respond sqtAfiliacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAfiliacionService.get(id)
    }

    def update(SqtAfiliacion sqtAfiliacion) {
        if (sqtAfiliacion == null) {
            notFound()
            return
        }

        try {
            sqtAfiliacionService.save(sqtAfiliacion)
        } catch (ValidationException e) {
            respond sqtAfiliacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAfiliacion.label', default: 'SqtAfiliacion'), sqtAfiliacion.id])
                redirect sqtAfiliacion
            }
            '*'{ respond sqtAfiliacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAfiliacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAfiliacion.label', default: 'SqtAfiliacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAfiliacion.label', default: 'SqtAfiliacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
