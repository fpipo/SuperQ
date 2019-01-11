package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAsignacionController {

    SqtAsignacionService sqtAsignacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAsignacionService.list(params), model:[sqtAsignacionCount: sqtAsignacionService.count()]
    }

    def show(Long id) {
        respond sqtAsignacionService.get(id)
    }

    def create() {
        respond new SqtCajeroTienda(params)
    }

    def save(SqtCajeroTienda sqtAsignacion) {
        if (sqtAsignacion == null) {
            notFound()
            return
        }

        try {
            sqtAsignacionService.save(sqtAsignacion)
        } catch (ValidationException e) {
            respond sqtAsignacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAsignacion.label', default: 'SqtCajeroTienda'), sqtAsignacion.id])
                redirect sqtAsignacion
            }
            '*' { respond sqtAsignacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAsignacionService.get(id)
    }

    def update(SqtCajeroTienda sqtAsignacion) {
        if (sqtAsignacion == null) {
            notFound()
            return
        }

        try {
            sqtAsignacionService.save(sqtAsignacion)
        } catch (ValidationException e) {
            respond sqtAsignacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAsignacion.label', default: 'SqtCajeroTienda'), sqtAsignacion.id])
                redirect sqtAsignacion
            }
            '*'{ respond sqtAsignacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAsignacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAsignacion.label', default: 'SqtCajeroTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAsignacion.label', default: 'SqtCajeroTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
