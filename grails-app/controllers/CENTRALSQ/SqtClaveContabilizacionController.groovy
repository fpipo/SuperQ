package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtClaveContabilizacionController {

    SqtClaveContabilizacionService sqtClaveContabilizacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtClaveContabilizacionService.list(params), model:[sqtClaveContabilizacionCount: sqtClaveContabilizacionService.count()]
    }

    def show(Long id) {
        respond sqtClaveContabilizacionService.get(id)
    }

    def create() {
        respond new SqtClaveContabilizacion(params)
    }

    def save(SqtClaveContabilizacion sqtClaveContabilizacion) {
        if (sqtClaveContabilizacion == null) {
            notFound()
            return
        }

        try {
            sqtClaveContabilizacionService.save(sqtClaveContabilizacion)
        } catch (ValidationException e) {
            respond sqtClaveContabilizacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtClaveContabilizacion.label', default: 'SqtClaveContabilizacion'), sqtClaveContabilizacion.id])
                redirect sqtClaveContabilizacion
            }
            '*' { respond sqtClaveContabilizacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtClaveContabilizacionService.get(id)
    }

    def update(SqtClaveContabilizacion sqtClaveContabilizacion) {
        if (sqtClaveContabilizacion == null) {
            notFound()
            return
        }

        try {
            sqtClaveContabilizacionService.save(sqtClaveContabilizacion)
        } catch (ValidationException e) {
            respond sqtClaveContabilizacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtClaveContabilizacion.label', default: 'SqtClaveContabilizacion'), sqtClaveContabilizacion.id])
                redirect sqtClaveContabilizacion
            }
            '*'{ respond sqtClaveContabilizacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtClaveContabilizacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtClaveContabilizacion.label', default: 'SqtClaveContabilizacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtClaveContabilizacion.label', default: 'SqtClaveContabilizacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
