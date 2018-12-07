package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleVentaProductoController {

    SqtDetalleVentaProductoService sqtDetalleVentaProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleVentaProductoService.list(params), model:[sqtDetalleVentaProductoCount: sqtDetalleVentaProductoService.count()]
    }

    def show(Long id) {
        respond sqtDetalleVentaProductoService.get(id)
    }

    def create() {
        respond new SqtDetalleVentaProducto(params)
    }

    def save(SqtDetalleVentaProducto sqtDetalleVentaProducto) {
        if (sqtDetalleVentaProducto == null) {
            notFound()
            return
        }

        try {
            sqtDetalleVentaProductoService.save(sqtDetalleVentaProducto)
        } catch (ValidationException e) {
            respond sqtDetalleVentaProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleVentaProducto.label', default: 'SqtDetalleVentaProducto'), sqtDetalleVentaProducto.id])
                redirect sqtDetalleVentaProducto
            }
            '*' { respond sqtDetalleVentaProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleVentaProductoService.get(id)
    }

    def update(SqtDetalleVentaProducto sqtDetalleVentaProducto) {
        if (sqtDetalleVentaProducto == null) {
            notFound()
            return
        }

        try {
            sqtDetalleVentaProductoService.save(sqtDetalleVentaProducto)
        } catch (ValidationException e) {
            respond sqtDetalleVentaProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleVentaProducto.label', default: 'SqtDetalleVentaProducto'), sqtDetalleVentaProducto.id])
                redirect sqtDetalleVentaProducto
            }
            '*'{ respond sqtDetalleVentaProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleVentaProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleVentaProducto.label', default: 'SqtDetalleVentaProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleVentaProducto.label', default: 'SqtDetalleVentaProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
