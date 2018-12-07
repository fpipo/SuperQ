package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMapeoProductoController {

    SqtMapeoProductoService sqtMapeoProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMapeoProductoService.list(params), model:[sqtMapeoProductoCount: sqtMapeoProductoService.count()]
    }

    def show(Long id) {
        respond sqtMapeoProductoService.get(id)
    }

    def create() {
        respond new SqtMapeoProducto(params)
    }

    def save(SqtMapeoProducto sqtMapeoProducto) {
        if (sqtMapeoProducto == null) {
            notFound()
            return
        }

        try {
            sqtMapeoProductoService.save(sqtMapeoProducto)
        } catch (ValidationException e) {
            respond sqtMapeoProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMapeoProducto.label', default: 'SqtMapeoProducto'), sqtMapeoProducto.id])
                redirect sqtMapeoProducto
            }
            '*' { respond sqtMapeoProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMapeoProductoService.get(id)
    }

    def update(SqtMapeoProducto sqtMapeoProducto) {
        if (sqtMapeoProducto == null) {
            notFound()
            return
        }

        try {
            sqtMapeoProductoService.save(sqtMapeoProducto)
        } catch (ValidationException e) {
            respond sqtMapeoProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMapeoProducto.label', default: 'SqtMapeoProducto'), sqtMapeoProducto.id])
                redirect sqtMapeoProducto
            }
            '*'{ respond sqtMapeoProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMapeoProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMapeoProducto.label', default: 'SqtMapeoProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMapeoProducto.label', default: 'SqtMapeoProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
