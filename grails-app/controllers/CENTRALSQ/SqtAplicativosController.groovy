package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAplicativosController {

    SqtAplicativosService sqtAplicativosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAplicativosService.list(params), model:[sqtAplicativosCount: sqtAplicativosService.count()]
    }

    def show(Long id) {
        respond sqtAplicativosService.get(id)
    }

    def create() {
        respond new SqtAplicativos(params)
    }

    def save(SqtAplicativos sqtAplicativos) {
        if (sqtAplicativos == null) {
            notFound()
            return
        }

        try {
            sqtAplicativosService.save(sqtAplicativos)
        } catch (ValidationException e) {
            respond sqtAplicativos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAplicativos.label', default: 'SqtAplicativos'), sqtAplicativos.id])
                redirect sqtAplicativos
            }
            '*' { respond sqtAplicativos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAplicativosService.get(id)
    }

    def update(SqtAplicativos sqtAplicativos) {
        if (sqtAplicativos == null) {
            notFound()
            return
        }

        try {
            sqtAplicativosService.save(sqtAplicativos)
        } catch (ValidationException e) {
            respond sqtAplicativos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAplicativos.label', default: 'SqtAplicativos'), sqtAplicativos.id])
                redirect sqtAplicativos
            }
            '*'{ respond sqtAplicativos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAplicativosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAplicativos.label', default: 'SqtAplicativos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAplicativos.label', default: 'SqtAplicativos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
