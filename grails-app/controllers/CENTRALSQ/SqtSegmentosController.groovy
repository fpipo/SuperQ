package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtSegmentosController {

    SqtSegmentosService sqtSegmentosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtSegmentosService.list(params), model:[sqtSegmentosCount: sqtSegmentosService.count()]
    }

    def show(Long id) {
        respond sqtSegmentosService.get(id)
    }

    def create() {
        respond new SqtSegmentos(params)
    }

    def save(SqtSegmentos sqtSegmentos) {
        if (sqtSegmentos == null) {
            notFound()
            return
        }

        try {
            sqtSegmentosService.save(sqtSegmentos)
        } catch (ValidationException e) {
            respond sqtSegmentos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtSegmentos.label', default: 'SqtSegmentos'), sqtSegmentos.id])
                redirect sqtSegmentos
            }
            '*' { respond sqtSegmentos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtSegmentosService.get(id)
    }

    def update(SqtSegmentos sqtSegmentos) {
        if (sqtSegmentos == null) {
            notFound()
            return
        }

        try {
            sqtSegmentosService.save(sqtSegmentos)
        } catch (ValidationException e) {
            respond sqtSegmentos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtSegmentos.label', default: 'SqtSegmentos'), sqtSegmentos.id])
                redirect sqtSegmentos
            }
            '*'{ respond sqtSegmentos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtSegmentosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtSegmentos.label', default: 'SqtSegmentos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtSegmentos.label', default: 'SqtSegmentos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
