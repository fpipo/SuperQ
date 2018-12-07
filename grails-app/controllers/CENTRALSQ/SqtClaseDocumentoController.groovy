package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtClaseDocumentoController {

    SqtClaseDocumentoService sqtClaseDocumentoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtClaseDocumentoService.list(params), model:[sqtClaseDocumentoCount: sqtClaseDocumentoService.count()]
    }

    def show(Long id) {
        respond sqtClaseDocumentoService.get(id)
    }

    def create() {
        respond new SqtClaseDocumento(params)
    }

    def save(SqtClaseDocumento sqtClaseDocumento) {
        if (sqtClaseDocumento == null) {
            notFound()
            return
        }

        try {
            sqtClaseDocumentoService.save(sqtClaseDocumento)
        } catch (ValidationException e) {
            respond sqtClaseDocumento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtClaseDocumento.label', default: 'SqtClaseDocumento'), sqtClaseDocumento.id])
                redirect sqtClaseDocumento
            }
            '*' { respond sqtClaseDocumento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtClaseDocumentoService.get(id)
    }

    def update(SqtClaseDocumento sqtClaseDocumento) {
        if (sqtClaseDocumento == null) {
            notFound()
            return
        }

        try {
            sqtClaseDocumentoService.save(sqtClaseDocumento)
        } catch (ValidationException e) {
            respond sqtClaseDocumento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtClaseDocumento.label', default: 'SqtClaseDocumento'), sqtClaseDocumento.id])
                redirect sqtClaseDocumento
            }
            '*'{ respond sqtClaseDocumento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtClaseDocumentoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtClaseDocumento.label', default: 'SqtClaseDocumento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtClaseDocumento.label', default: 'SqtClaseDocumento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
