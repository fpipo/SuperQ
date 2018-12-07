package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtImpuestoProductoController {

    SqtImpuestoProductoService sqtImpuestoProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtImpuestoProductoService.list(params), model:[sqtImpuestoProductoCount: sqtImpuestoProductoService.count()]
    }

    def show(Long id) {
        respond sqtImpuestoProductoService.get(id)
    }

    def create() {
        respond new SqtImpuestoProducto(params)
    }

    def save(SqtImpuestoProducto sqtImpuestoProducto) {
        if (sqtImpuestoProducto == null) {
            notFound()
            return
        }

        try {
            sqtImpuestoProductoService.save(sqtImpuestoProducto)
        } catch (ValidationException e) {
            respond sqtImpuestoProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtImpuestoProducto.label', default: 'SqtImpuestoProducto'), sqtImpuestoProducto.id])
                redirect sqtImpuestoProducto
            }
            '*' { respond sqtImpuestoProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtImpuestoProductoService.get(id)
    }

    def update(SqtImpuestoProducto sqtImpuestoProducto) {
        if (sqtImpuestoProducto == null) {
            notFound()
            return
        }

        try {
            sqtImpuestoProductoService.save(sqtImpuestoProducto)
        } catch (ValidationException e) {
            respond sqtImpuestoProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtImpuestoProducto.label', default: 'SqtImpuestoProducto'), sqtImpuestoProducto.id])
                redirect sqtImpuestoProducto
            }
            '*'{ respond sqtImpuestoProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtImpuestoProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtImpuestoProducto.label', default: 'SqtImpuestoProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtImpuestoProducto.label', default: 'SqtImpuestoProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
