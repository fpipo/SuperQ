package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProveedorController {

    SqtProveedorService sqtProveedorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProveedorService.list(params), model:[sqtProveedorCount: sqtProveedorService.count()]
    }

    def show(Long id) {
        respond sqtProveedorService.get(id)
    }

    def create() {
        respond new SqtProveedor(params)
    }

    def save(SqtProveedor sqtProveedor) {
        if (sqtProveedor == null) {
            notFound()
            return
        }

        try {
            sqtProveedorService.save(sqtProveedor)
        } catch (ValidationException e) {
            respond sqtProveedor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProveedor.label', default: 'SqtProveedor'), sqtProveedor.id])
                redirect sqtProveedor
            }
            '*' { respond sqtProveedor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProveedorService.get(id)
    }

    def update(SqtProveedor sqtProveedor) {
        if (sqtProveedor == null) {
            notFound()
            return
        }

        try {
            sqtProveedorService.save(sqtProveedor)
        } catch (ValidationException e) {
            respond sqtProveedor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProveedor.label', default: 'SqtProveedor'), sqtProveedor.id])
                redirect sqtProveedor
            }
            '*'{ respond sqtProveedor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProveedorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProveedor.label', default: 'SqtProveedor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProveedor.label', default: 'SqtProveedor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
