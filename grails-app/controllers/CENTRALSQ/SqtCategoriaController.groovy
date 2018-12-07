package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCategoriaController {

    SqtCategoriaService sqtCategoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCategoriaService.list(params), model:[sqtCategoriaCount: sqtCategoriaService.count()]
    }

    def show(Long id) {
        respond sqtCategoriaService.get(id)
    }

    def create() {
        respond new SqtCategoria(params)
    }

    def save(SqtCategoria sqtCategoria) {
        if (sqtCategoria == null) {
            notFound()
            return
        }

        try {
            sqtCategoriaService.save(sqtCategoria)
        } catch (ValidationException e) {
            respond sqtCategoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCategoria.label', default: 'SqtCategoria'), sqtCategoria.id])
                redirect sqtCategoria
            }
            '*' { respond sqtCategoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCategoriaService.get(id)
    }

    def update(SqtCategoria sqtCategoria) {
        if (sqtCategoria == null) {
            notFound()
            return
        }

        try {
            sqtCategoriaService.save(sqtCategoria)
        } catch (ValidationException e) {
            respond sqtCategoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCategoria.label', default: 'SqtCategoria'), sqtCategoria.id])
                redirect sqtCategoria
            }
            '*'{ respond sqtCategoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCategoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCategoria.label', default: 'SqtCategoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCategoria.label', default: 'SqtCategoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
