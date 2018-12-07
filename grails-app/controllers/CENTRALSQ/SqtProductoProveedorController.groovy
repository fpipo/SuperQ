package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProductoProveedorController {

    SqtProductoProveedorService sqtProductoProveedorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProductoProveedorService.list(params), model:[sqtProductoProveedorCount: sqtProductoProveedorService.count()]
    }

    def show(Long id) {
        respond sqtProductoProveedorService.get(id)
    }

    def create() {
        respond new SqtProductoProveedor(params)
    }

    def save(SqtProductoProveedor sqtProductoProveedor) {
        if (sqtProductoProveedor == null) {
            notFound()
            return
        }

        try {
            sqtProductoProveedorService.save(sqtProductoProveedor)
        } catch (ValidationException e) {
            respond sqtProductoProveedor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProductoProveedor.label', default: 'SqtProductoProveedor'), sqtProductoProveedor.id])
                redirect sqtProductoProveedor
            }
            '*' { respond sqtProductoProveedor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProductoProveedorService.get(id)
    }

    def update(SqtProductoProveedor sqtProductoProveedor) {
        if (sqtProductoProveedor == null) {
            notFound()
            return
        }

        try {
            sqtProductoProveedorService.save(sqtProductoProveedor)
        } catch (ValidationException e) {
            respond sqtProductoProveedor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProductoProveedor.label', default: 'SqtProductoProveedor'), sqtProductoProveedor.id])
                redirect sqtProductoProveedor
            }
            '*'{ respond sqtProductoProveedor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProductoProveedorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProductoProveedor.label', default: 'SqtProductoProveedor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProductoProveedor.label', default: 'SqtProductoProveedor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
