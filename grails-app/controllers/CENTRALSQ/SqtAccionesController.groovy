package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAccionesController {

    SqtAccionesService sqtAccionesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAccionesService.list(params), model:[sqtAccionesCount: sqtAccionesService.count()]
    }

    def show(Long id) {
        respond sqtAccionesService.get(id)
    }

    def create() {
        respond new SqtAcciones(params)
    }

    def save(SqtAcciones sqtAcciones) {
        if (sqtAcciones == null) {
            notFound()
            return
        }

        try {
            sqtAccionesService.save(sqtAcciones)
        } catch (ValidationException e) {
            respond sqtAcciones.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAcciones.label', default: 'SqtAcciones'), sqtAcciones.id])
                redirect sqtAcciones
            }
            '*' { respond sqtAcciones, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAccionesService.get(id)
    }

    def update(SqtAcciones sqtAcciones) {
        if (sqtAcciones == null) {
            notFound()
            return
        }

        try {
            sqtAccionesService.save(sqtAcciones)
        } catch (ValidationException e) {
            respond sqtAcciones.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAcciones.label', default: 'SqtAcciones'), sqtAcciones.id])
                redirect sqtAcciones
            }
            '*'{ respond sqtAcciones, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAccionesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAcciones.label', default: 'SqtAcciones'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAcciones.label', default: 'SqtAcciones'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
