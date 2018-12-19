package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtArchivoController {

    SqtArchivoService sqtArchivoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtArchivoService.list(params), model:[sqtArchivoCount: sqtArchivoService.count()]
    }

    def show(Long id) {
        respond sqtArchivoService.get(id)
    }

    def create() {
        respond new SqtArchivo(params)
    }

    def save(SqtArchivo sqtArchivo) {
        if (sqtArchivo == null) {
            notFound()
            return
        }

        try {
            sqtArchivoService.save(sqtArchivo)
        } catch (ValidationException e) {
            respond sqtArchivo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtArchivo.label', default: 'SqtArchivo'), sqtArchivo.id])
                redirect sqtArchivo
            }
            '*' { respond sqtArchivo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtArchivoService.get(id)
    }

    def update(SqtArchivo sqtArchivo) {
        if (sqtArchivo == null) {
            notFound()
            return
        }

        try {
            sqtArchivoService.save(sqtArchivo)
        } catch (ValidationException e) {
            respond sqtArchivo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtArchivo.label', default: 'SqtArchivo'), sqtArchivo.id])
                redirect sqtArchivo
            }
            '*'{ respond sqtArchivo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtArchivoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtArchivo.label', default: 'SqtArchivo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtArchivo.label', default: 'SqtArchivo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
