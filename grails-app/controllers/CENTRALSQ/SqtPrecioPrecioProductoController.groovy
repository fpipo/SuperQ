package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPrecioPrecioProductoController {

    SqtPrecioPrecioProductoService sqtPrecioPrecioProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPrecioPrecioProductoService.list(params), model:[sqtPrecioPrecioProductoCount: sqtPrecioPrecioProductoService.count()]
    }

    def show(Long id) {
        respond sqtPrecioPrecioProductoService.get(id)
    }

    def create() {
        respond new SqtPrecioPrecioProducto(params)
    }

    def save(SqtPrecioPrecioProducto sqtPrecioPrecioProducto) {
        if (sqtPrecioPrecioProducto == null) {
            notFound()
            return
        }

        try {
            sqtPrecioPrecioProductoService.save(sqtPrecioPrecioProducto)
        } catch (ValidationException e) {
            respond sqtPrecioPrecioProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPrecioPrecioProducto.label', default: 'SqtPrecioPrecioProducto'), sqtPrecioPrecioProducto.id])
                redirect sqtPrecioPrecioProducto
            }
            '*' { respond sqtPrecioPrecioProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPrecioPrecioProductoService.get(id)
    }

    def update(SqtPrecioPrecioProducto sqtPrecioPrecioProducto) {
        if (sqtPrecioPrecioProducto == null) {
            notFound()
            return
        }

        try {
            sqtPrecioPrecioProductoService.save(sqtPrecioPrecioProducto)
        } catch (ValidationException e) {
            respond sqtPrecioPrecioProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPrecioPrecioProducto.label', default: 'SqtPrecioPrecioProducto'), sqtPrecioPrecioProducto.id])
                redirect sqtPrecioPrecioProducto
            }
            '*'{ respond sqtPrecioPrecioProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPrecioPrecioProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPrecioPrecioProducto.label', default: 'SqtPrecioPrecioProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPrecioPrecioProducto.label', default: 'SqtPrecioPrecioProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
