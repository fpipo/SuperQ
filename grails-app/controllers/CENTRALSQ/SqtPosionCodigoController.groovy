package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPosionCodigoController {

    SqtPosionCodigoService sqtPosionCodigoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPosionCodigoService.list(params), model:[sqtPosionCodigoCount: sqtPosionCodigoService.count()]
    }

    def show(Long id) {
        respond sqtPosionCodigoService.get(id)
    }

    def create() {
        respond new SqtPosicionCodigo(params)
    }

    def save(SqtPosicionCodigo sqtPosionCodigo) {
        if (sqtPosionCodigo == null) {
            notFound()
            return
        }

        try {
            sqtPosionCodigoService.save(sqtPosionCodigo)
        } catch (ValidationException e) {
            respond sqtPosionCodigo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPosionCodigo.label', default: 'SqtPosicionCodigo'), sqtPosionCodigo.id])
                redirect sqtPosionCodigo
            }
            '*' { respond sqtPosionCodigo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPosionCodigoService.get(id)
    }

    def update(SqtPosicionCodigo sqtPosionCodigo) {
        if (sqtPosionCodigo == null) {
            notFound()
            return
        }

        try {
            sqtPosionCodigoService.save(sqtPosionCodigo)
        } catch (ValidationException e) {
            respond sqtPosionCodigo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPosionCodigo.label', default: 'SqtPosicionCodigo'), sqtPosionCodigo.id])
                redirect sqtPosionCodigo
            }
            '*'{ respond sqtPosionCodigo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPosionCodigoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPosionCodigo.label', default: 'SqtPosicionCodigo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPosionCodigo.label', default: 'SqtPosicionCodigo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
