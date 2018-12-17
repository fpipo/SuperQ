package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProveedorLibreCompraController {

    SqtProveedorLibreCompraService sqtProveedorLibreCompraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProveedorLibreCompraService.list(params), model:[sqtProveedorLibreCompraCount: sqtProveedorLibreCompraService.count()]
    }

    def show(Long id) {
        respond sqtProveedorLibreCompraService.get(id)
    }

    def create() {
        respond new SqtProveedorLibreCompra(params)
    }

    def save(SqtProveedorLibreCompra sqtProveedorLibreCompra) {
        if (sqtProveedorLibreCompra == null) {
            notFound()
            return
        }

        try {
            sqtProveedorLibreCompraService.save(sqtProveedorLibreCompra)
        } catch (ValidationException e) {
            respond sqtProveedorLibreCompra.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProveedorLibreCompra.label', default: 'SqtProveedorLibreCompra'), sqtProveedorLibreCompra.id])
                redirect sqtProveedorLibreCompra
            }
            '*' { respond sqtProveedorLibreCompra, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProveedorLibreCompraService.get(id)
    }

    def update(SqtProveedorLibreCompra sqtProveedorLibreCompra) {
        if (sqtProveedorLibreCompra == null) {
            notFound()
            return
        }

        try {
            sqtProveedorLibreCompraService.save(sqtProveedorLibreCompra)
        } catch (ValidationException e) {
            respond sqtProveedorLibreCompra.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProveedorLibreCompra.label', default: 'SqtProveedorLibreCompra'), sqtProveedorLibreCompra.id])
                redirect sqtProveedorLibreCompra
            }
            '*'{ respond sqtProveedorLibreCompra, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProveedorLibreCompraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProveedorLibreCompra.label', default: 'SqtProveedorLibreCompra'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProveedorLibreCompra.label', default: 'SqtProveedorLibreCompra'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
