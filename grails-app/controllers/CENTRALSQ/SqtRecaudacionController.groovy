package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRecaudacionController {

    SqtRecaudacionService sqtRecaudacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRecaudacionService.list(params), model:[sqtRecaudacionCount: sqtRecaudacionService.count()]
    }

    def show(Long id) {
        respond sqtRecaudacionService.get(id)
    }

    def create() {
        respond new SqtRecaudacion(params)
    }

    def save(SqtRecaudacion sqtRecaudacion) {
        if (sqtRecaudacion == null) {
            notFound()
            return
        }

        try {
            sqtRecaudacionService.save(sqtRecaudacion)
        } catch (ValidationException e) {
            respond sqtRecaudacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRecaudacion.label', default: 'SqtRecaudacion'), sqtRecaudacion.id])
                redirect sqtRecaudacion
            }
            '*' { respond sqtRecaudacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRecaudacionService.get(id)
    }

    def update(SqtRecaudacion sqtRecaudacion) {
        if (sqtRecaudacion == null) {
            notFound()
            return
        }

        try {
            sqtRecaudacionService.save(sqtRecaudacion)
        } catch (ValidationException e) {
            respond sqtRecaudacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRecaudacion.label', default: 'SqtRecaudacion'), sqtRecaudacion.id])
                redirect sqtRecaudacion
            }
            '*'{ respond sqtRecaudacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRecaudacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRecaudacion.label', default: 'SqtRecaudacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRecaudacion.label', default: 'SqtRecaudacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
