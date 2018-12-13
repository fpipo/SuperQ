package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPrecioProductoController {

    SqtPrecioProductoService sqtPrecioProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPrecioProductoService.list(params), model:[sqtPrecioProductoCount: sqtPrecioProductoService.count()]
    }

    def show(Long id) {
        respond sqtPrecioProductoService.get(id)
    }

    def create() {
        respond new SqtPrecioProducto(params)
    }

    def save(SqtPrecioProducto sqtPrecioProducto) {
        if (sqtPrecioProducto == null) {
            notFound()
            return
        }

        try {
            sqtPrecioProductoService.save(sqtPrecioProducto)
        } catch (ValidationException e) {
            respond sqtPrecioProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPrecioProducto.label', default: 'SqtPrecioProducto'), sqtPrecioProducto.id])
                redirect sqtPrecioProducto
            }
            '*' { respond sqtPrecioProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPrecioProductoService.get(id)
    }

    def update(SqtPrecioProducto sqtPrecioProducto) {
        if (sqtPrecioProducto == null) {
            notFound()
            return
        }

        try {
            sqtPrecioProductoService.save(sqtPrecioProducto)
        } catch (ValidationException e) {
            respond sqtPrecioProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPrecioProducto.label', default: 'SqtPrecioProducto'), sqtPrecioProducto.id])
                redirect sqtPrecioProducto
            }
            '*'{ respond sqtPrecioProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPrecioProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPrecioProducto.label', default: 'SqtPrecioProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPrecioProducto.label', default: 'SqtPrecioProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
