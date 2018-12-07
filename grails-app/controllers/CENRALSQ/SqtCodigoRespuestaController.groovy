package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCodigoRespuestaController {

    SqtCodigoRespuestaService sqtCodigoRespuestaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCodigoRespuestaService.list(params), model:[sqtCodigoRespuestaCount: sqtCodigoRespuestaService.count()]
    }

    def show(Long id) {
        respond sqtCodigoRespuestaService.get(id)
    }

    def create() {
        respond new SqtCodigoRespuesta(params)
    }

    def save(SqtCodigoRespuesta sqtCodigoRespuesta) {
        if (sqtCodigoRespuesta == null) {
            notFound()
            return
        }

        try {
            sqtCodigoRespuestaService.save(sqtCodigoRespuesta)
        } catch (ValidationException e) {
            respond sqtCodigoRespuesta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCodigoRespuesta.label', default: 'SqtCodigoRespuesta'), sqtCodigoRespuesta.id])
                redirect sqtCodigoRespuesta
            }
            '*' { respond sqtCodigoRespuesta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCodigoRespuestaService.get(id)
    }

    def update(SqtCodigoRespuesta sqtCodigoRespuesta) {
        if (sqtCodigoRespuesta == null) {
            notFound()
            return
        }

        try {
            sqtCodigoRespuestaService.save(sqtCodigoRespuesta)
        } catch (ValidationException e) {
            respond sqtCodigoRespuesta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCodigoRespuesta.label', default: 'SqtCodigoRespuesta'), sqtCodigoRespuesta.id])
                redirect sqtCodigoRespuesta
            }
            '*'{ respond sqtCodigoRespuesta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCodigoRespuestaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCodigoRespuesta.label', default: 'SqtCodigoRespuesta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCodigoRespuesta.label', default: 'SqtCodigoRespuesta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
