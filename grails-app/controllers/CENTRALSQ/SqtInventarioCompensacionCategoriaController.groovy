package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioCompensacionCategoriaController {

    SqtInventarioCompensacionCategoriaService sqtInventarioCompensacionCategoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioCompensacionCategoriaService.list(params), model:[sqtInventarioCompensacionCategoriaCount: sqtInventarioCompensacionCategoriaService.count()]
    }

    def show(Long id) {
        respond sqtInventarioCompensacionCategoriaService.get(id)
    }

    def create() {
        respond new SqtInventarioCompensacionCategoria(params)
    }

    def save(SqtInventarioCompensacionCategoria sqtInventarioCompensacionCategoria) {
        if (sqtInventarioCompensacionCategoria == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCompensacionCategoriaService.save(sqtInventarioCompensacionCategoria)
        } catch (ValidationException e) {
            respond sqtInventarioCompensacionCategoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioCompensacionCategoria.label', default: 'SqtInventarioCompensacionCategoria'), sqtInventarioCompensacionCategoria.id])
                redirect sqtInventarioCompensacionCategoria
            }
            '*' { respond sqtInventarioCompensacionCategoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioCompensacionCategoriaService.get(id)
    }

    def update(SqtInventarioCompensacionCategoria sqtInventarioCompensacionCategoria) {
        if (sqtInventarioCompensacionCategoria == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCompensacionCategoriaService.save(sqtInventarioCompensacionCategoria)
        } catch (ValidationException e) {
            respond sqtInventarioCompensacionCategoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioCompensacionCategoria.label', default: 'SqtInventarioCompensacionCategoria'), sqtInventarioCompensacionCategoria.id])
                redirect sqtInventarioCompensacionCategoria
            }
            '*'{ respond sqtInventarioCompensacionCategoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioCompensacionCategoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioCompensacionCategoria.label', default: 'SqtInventarioCompensacionCategoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioCompensacionCategoria.label', default: 'SqtInventarioCompensacionCategoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
