package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SQtNsegmentosController {

    SQtNsegmentosService SQtNsegmentosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SQtNsegmentosService.list(params), model:[SQtNsegmentosCount: SQtNsegmentosService.count()]
    }

    def show(Long id) {
        respond SQtNsegmentosService.get(id)
    }

    def create() {
        respond new SQtNsegmentos(params)
    }

    def save(SQtNsegmentos SQtNsegmentos) {
        if (SQtNsegmentos == null) {
            notFound()
            return
        }

        try {
            SQtNsegmentosService.save(SQtNsegmentos)
        } catch (ValidationException e) {
            respond SQtNsegmentos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'SQtNsegmentos.label', default: 'SQtNsegmentos'), SQtNsegmentos.id])
                redirect SQtNsegmentos
            }
            '*' { respond SQtNsegmentos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond SQtNsegmentosService.get(id)
    }

    def update(SQtNsegmentos SQtNsegmentos) {
        if (SQtNsegmentos == null) {
            notFound()
            return
        }

        try {
            SQtNsegmentosService.save(SQtNsegmentos)
        } catch (ValidationException e) {
            respond SQtNsegmentos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SQtNsegmentos.label', default: 'SQtNsegmentos'), SQtNsegmentos.id])
                redirect SQtNsegmentos
            }
            '*'{ respond SQtNsegmentos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        SQtNsegmentosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SQtNsegmentos.label', default: 'SQtNsegmentos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'SQtNsegmentos.label', default: 'SQtNsegmentos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
