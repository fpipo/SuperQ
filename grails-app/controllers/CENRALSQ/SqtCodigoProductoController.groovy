package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCodigoProductoController {

    SqtCodigoProductoService sqtCodigoProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCodigoProductoService.list(params), model:[sqtCodigoProductoCount: sqtCodigoProductoService.count()]
    }

    def show(Long id) {
        respond sqtCodigoProductoService.get(id)
    }

    def create() {
        respond new SqtCodigoProducto(params)
    }

    def save(SqtCodigoProducto sqtCodigoProducto) {
        if (sqtCodigoProducto == null) {
            notFound()
            return
        }

        try {
            sqtCodigoProductoService.save(sqtCodigoProducto)
        } catch (ValidationException e) {
            respond sqtCodigoProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCodigoProducto.label', default: 'SqtCodigoProducto'), sqtCodigoProducto.id])
                redirect sqtCodigoProducto
            }
            '*' { respond sqtCodigoProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCodigoProductoService.get(id)
    }

    def update(SqtCodigoProducto sqtCodigoProducto) {
        if (sqtCodigoProducto == null) {
            notFound()
            return
        }

        try {
            sqtCodigoProductoService.save(sqtCodigoProducto)
        } catch (ValidationException e) {
            respond sqtCodigoProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCodigoProducto.label', default: 'SqtCodigoProducto'), sqtCodigoProducto.id])
                redirect sqtCodigoProducto
            }
            '*'{ respond sqtCodigoProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCodigoProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCodigoProducto.label', default: 'SqtCodigoProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCodigoProducto.label', default: 'SqtCodigoProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
