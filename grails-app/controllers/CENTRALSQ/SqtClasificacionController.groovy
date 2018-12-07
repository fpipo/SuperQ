package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtClasificacionController {

    SqtClasificacionService sqtClasificacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtClasificacionService.list(params), model:[sqtClasificacionCount: sqtClasificacionService.count()]
    }

    def show(Long id) {
        respond sqtClasificacionService.get(id)
    }

    def create() {
        respond new SqtClasificacion(params)
    }

    def save(SqtClasificacion sqtClasificacion) {
        if (sqtClasificacion == null) {
            notFound()
            return
        }

        try {
            sqtClasificacionService.save(sqtClasificacion)
        } catch (ValidationException e) {
            respond sqtClasificacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtClasificacion.label', default: 'SqtClasificacion'), sqtClasificacion.id])
                redirect sqtClasificacion
            }
            '*' { respond sqtClasificacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtClasificacionService.get(id)
    }

    def update(SqtClasificacion sqtClasificacion) {
        if (sqtClasificacion == null) {
            notFound()
            return
        }

        try {
            sqtClasificacionService.save(sqtClasificacion)
        } catch (ValidationException e) {
            respond sqtClasificacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtClasificacion.label', default: 'SqtClasificacion'), sqtClasificacion.id])
                redirect sqtClasificacion
            }
            '*'{ respond sqtClasificacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtClasificacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtClasificacion.label', default: 'SqtClasificacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtClasificacion.label', default: 'SqtClasificacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
