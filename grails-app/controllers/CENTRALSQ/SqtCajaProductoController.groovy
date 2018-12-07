package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCajaProductoController {

    SqtCajaProductoService sqtCajaProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCajaProductoService.list(params), model:[sqtCajaProductoCount: sqtCajaProductoService.count()]
    }

    def show(Long id) {
        respond sqtCajaProductoService.get(id)
    }

    def create() {
        respond new SqtCajaProducto(params)
    }

    def save(SqtCajaProducto sqtCajaProducto) {
        if (sqtCajaProducto == null) {
            notFound()
            return
        }

        try {
            sqtCajaProductoService.save(sqtCajaProducto)
        } catch (ValidationException e) {
            respond sqtCajaProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCajaProducto.label', default: 'SqtCajaProducto'), sqtCajaProducto.id])
                redirect sqtCajaProducto
            }
            '*' { respond sqtCajaProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCajaProductoService.get(id)
    }

    def update(SqtCajaProducto sqtCajaProducto) {
        if (sqtCajaProducto == null) {
            notFound()
            return
        }

        try {
            sqtCajaProductoService.save(sqtCajaProducto)
        } catch (ValidationException e) {
            respond sqtCajaProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCajaProducto.label', default: 'SqtCajaProducto'), sqtCajaProducto.id])
                redirect sqtCajaProducto
            }
            '*'{ respond sqtCajaProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCajaProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCajaProducto.label', default: 'SqtCajaProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCajaProducto.label', default: 'SqtCajaProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
