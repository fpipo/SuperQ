package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtConfiguracionController {

    SqtConfiguracionService sqtConfiguracionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtConfiguracionService.list(params), model:[sqtConfiguracionCount: sqtConfiguracionService.count()]
    }

    def show(Long id) {
        respond sqtConfiguracionService.get(id)
    }

    def create() {
        respond new SqtConfiguracion(params)
    }

    def save(SqtConfiguracion sqtConfiguracion) {
        if (sqtConfiguracion == null) {
            notFound()
            return
        }

        try {
            sqtConfiguracionService.save(sqtConfiguracion)
        } catch (ValidationException e) {
            respond sqtConfiguracion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtConfiguracion.label', default: 'SqtConfiguracion'), sqtConfiguracion.id])
                redirect sqtConfiguracion
            }
            '*' { respond sqtConfiguracion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtConfiguracionService.get(id)
    }

    def update(SqtConfiguracion sqtConfiguracion) {
        if (sqtConfiguracion == null) {
            notFound()
            return
        }

        try {
            sqtConfiguracionService.save(sqtConfiguracion)
        } catch (ValidationException e) {
            respond sqtConfiguracion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtConfiguracion.label', default: 'SqtConfiguracion'), sqtConfiguracion.id])
                redirect sqtConfiguracion
            }
            '*'{ respond sqtConfiguracion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtConfiguracionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtConfiguracion.label', default: 'SqtConfiguracion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtConfiguracion.label', default: 'SqtConfiguracion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
