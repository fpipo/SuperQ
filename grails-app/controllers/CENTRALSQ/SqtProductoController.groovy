package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProductoController {

    SqtProductoService sqtProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProductoService.list(params), model:[sqtProductoCount: sqtProductoService.count()]
    }

    def show(Long id) {
        respond sqtProductoService.get(id)
    }

    def create() {
        respond new SqtProducto(params)
    }

    def save(SqtProducto sqtProducto) {
        if (sqtProducto == null) {
            notFound()
            return
        }

        try {
            sqtProductoService.save(sqtProducto)
        } catch (ValidationException e) {
            respond sqtProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProducto.label', default: 'SqtProducto'), sqtProducto.id])
                redirect sqtProducto
            }
            '*' { respond sqtProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProductoService.get(id)
    }

    def update(SqtProducto sqtProducto) {
        if (sqtProducto == null) {
            notFound()
            return
        }

        try {
            sqtProductoService.save(sqtProducto)
        } catch (ValidationException e) {
            respond sqtProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProducto.label', default: 'SqtProducto'), sqtProducto.id])
                redirect sqtProducto
            }
            '*'{ respond sqtProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProducto.label', default: 'SqtProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProducto.label', default: 'SqtProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
