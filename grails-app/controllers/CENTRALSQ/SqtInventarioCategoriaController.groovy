package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioCategoriaController {

    SqtInventarioCategoriaService sqtInventarioCategoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioCategoriaService.list(params), model:[sqtInventarioCategoriaCount: sqtInventarioCategoriaService.count()]
    }

    def show(Long id) {
        respond sqtInventarioCategoriaService.get(id)
    }

    def create() {
        respond new SqtInventarioCategoria(params)
    }

    def save(SqtInventarioCategoria sqtInventarioCategoria) {
        if (sqtInventarioCategoria == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCategoriaService.save(sqtInventarioCategoria)
        } catch (ValidationException e) {
            respond sqtInventarioCategoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioCategoria.label', default: 'SqtInventarioCategoria'), sqtInventarioCategoria.id])
                redirect sqtInventarioCategoria
            }
            '*' { respond sqtInventarioCategoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioCategoriaService.get(id)
    }

    def update(SqtInventarioCategoria sqtInventarioCategoria) {
        if (sqtInventarioCategoria == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCategoriaService.save(sqtInventarioCategoria)
        } catch (ValidationException e) {
            respond sqtInventarioCategoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioCategoria.label', default: 'SqtInventarioCategoria'), sqtInventarioCategoria.id])
                redirect sqtInventarioCategoria
            }
            '*'{ respond sqtInventarioCategoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioCategoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioCategoria.label', default: 'SqtInventarioCategoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioCategoria.label', default: 'SqtInventarioCategoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
