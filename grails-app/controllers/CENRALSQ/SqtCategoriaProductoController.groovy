package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCategoriaProductoController {

    SqtCategoriaProductoService sqtCategoriaProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCategoriaProductoService.list(params), model:[sqtCategoriaProductoCount: sqtCategoriaProductoService.count()]
    }

    def show(Long id) {
        respond sqtCategoriaProductoService.get(id)
    }

    def create() {
        respond new SqtCategoriaProducto(params)
    }

    def save(SqtCategoriaProducto sqtCategoriaProducto) {
        if (sqtCategoriaProducto == null) {
            notFound()
            return
        }

        try {
            sqtCategoriaProductoService.save(sqtCategoriaProducto)
        } catch (ValidationException e) {
            respond sqtCategoriaProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCategoriaProducto.label', default: 'SqtCategoriaProducto'), sqtCategoriaProducto.id])
                redirect sqtCategoriaProducto
            }
            '*' { respond sqtCategoriaProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCategoriaProductoService.get(id)
    }

    def update(SqtCategoriaProducto sqtCategoriaProducto) {
        if (sqtCategoriaProducto == null) {
            notFound()
            return
        }

        try {
            sqtCategoriaProductoService.save(sqtCategoriaProducto)
        } catch (ValidationException e) {
            respond sqtCategoriaProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCategoriaProducto.label', default: 'SqtCategoriaProducto'), sqtCategoriaProducto.id])
                redirect sqtCategoriaProducto
            }
            '*'{ respond sqtCategoriaProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCategoriaProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCategoriaProducto.label', default: 'SqtCategoriaProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCategoriaProducto.label', default: 'SqtCategoriaProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
