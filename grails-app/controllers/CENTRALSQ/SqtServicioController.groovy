package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtServicioController {

    SqtServicioService sqtServicioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtServicioService.list(params), model:[sqtServicioCount: sqtServicioService.count()]
    }

    def show(Long id) {
        respond sqtServicioService.get(id)
    }

    def create() {
        respond new SqtServicio(params)
    }

    def save(SqtServicio sqtServicio) {
        if (sqtServicio == null) {
            notFound()
            return
        }

        try {
            sqtServicioService.save(sqtServicio)
        } catch (ValidationException e) {
            respond sqtServicio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtServicio.label', default: 'SqtServicio'), sqtServicio.id])
                redirect sqtServicio
            }
            '*' { respond sqtServicio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtServicioService.get(id)
    }

    def update(SqtServicio sqtServicio) {
        if (sqtServicio == null) {
            notFound()
            return
        }

        try {
            sqtServicioService.save(sqtServicio)
        } catch (ValidationException e) {
            respond sqtServicio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtServicio.label', default: 'SqtServicio'), sqtServicio.id])
                redirect sqtServicio
            }
            '*'{ respond sqtServicio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtServicioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtServicio.label', default: 'SqtServicio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtServicio.label', default: 'SqtServicio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
