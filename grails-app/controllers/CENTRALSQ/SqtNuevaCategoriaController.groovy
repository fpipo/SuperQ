package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtNuevaCategoriaController {

    SqtNuevaCategoriaService sqtNuevaCategoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtNuevaCategoriaService.list(params), model:[sqtNuevaCategoriaCount: sqtNuevaCategoriaService.count()]
    }

    def show(Long id) {
        respond sqtNuevaCategoriaService.get(id)
    }

    def create() {
        respond new SqtNuevaCategoria(params)
    }

    def save(SqtNuevaCategoria sqtNuevaCategoria) {
        if (sqtNuevaCategoria == null) {
            notFound()
            return
        }

        try {
            sqtNuevaCategoriaService.save(sqtNuevaCategoria)
        } catch (ValidationException e) {
            respond sqtNuevaCategoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtNuevaCategoria.label', default: 'SqtNuevaCategoria'), sqtNuevaCategoria.id])
                redirect sqtNuevaCategoria
            }
            '*' { respond sqtNuevaCategoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtNuevaCategoriaService.get(id)
    }

    def update(SqtNuevaCategoria sqtNuevaCategoria) {
        if (sqtNuevaCategoria == null) {
            notFound()
            return
        }

        try {
            sqtNuevaCategoriaService.save(sqtNuevaCategoria)
        } catch (ValidationException e) {
            respond sqtNuevaCategoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtNuevaCategoria.label', default: 'SqtNuevaCategoria'), sqtNuevaCategoria.id])
                redirect sqtNuevaCategoria
            }
            '*'{ respond sqtNuevaCategoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtNuevaCategoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtNuevaCategoria.label', default: 'SqtNuevaCategoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtNuevaCategoria.label', default: 'SqtNuevaCategoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
