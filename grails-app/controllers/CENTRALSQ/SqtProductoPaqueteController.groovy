package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProductoPaqueteController {

    SqtProductoPaqueteService sqtProductoPaqueteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProductoPaqueteService.list(params), model:[sqtProductoPaqueteCount: sqtProductoPaqueteService.count()]
    }

    def show(Long id) {
        respond sqtProductoPaqueteService.get(id)
    }

    def create() {
        respond new SqtProductoPaquete(params)
    }

    def save(SqtProductoPaquete sqtProductoPaquete) {
        if (sqtProductoPaquete == null) {
            notFound()
            return
        }

        try {
            sqtProductoPaqueteService.save(sqtProductoPaquete)
        } catch (ValidationException e) {
            respond sqtProductoPaquete.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProductoPaquete.label', default: 'SqtProductoPaquete'), sqtProductoPaquete.id])
                redirect sqtProductoPaquete
            }
            '*' { respond sqtProductoPaquete, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProductoPaqueteService.get(id)
    }

    def update(SqtProductoPaquete sqtProductoPaquete) {
        if (sqtProductoPaquete == null) {
            notFound()
            return
        }

        try {
            sqtProductoPaqueteService.save(sqtProductoPaquete)
        } catch (ValidationException e) {
            respond sqtProductoPaquete.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProductoPaquete.label', default: 'SqtProductoPaquete'), sqtProductoPaquete.id])
                redirect sqtProductoPaquete
            }
            '*'{ respond sqtProductoPaquete, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProductoPaqueteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProductoPaquete.label', default: 'SqtProductoPaquete'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProductoPaquete.label', default: 'SqtProductoPaquete'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
