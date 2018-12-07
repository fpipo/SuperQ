package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPreciosCompraController {

    SqtPreciosCompraService sqtPreciosCompraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPreciosCompraService.list(params), model:[sqtPreciosCompraCount: sqtPreciosCompraService.count()]
    }

    def show(Long id) {
        respond sqtPreciosCompraService.get(id)
    }

    def create() {
        respond new SqtPreciosCompra(params)
    }

    def save(SqtPreciosCompra sqtPreciosCompra) {
        if (sqtPreciosCompra == null) {
            notFound()
            return
        }

        try {
            sqtPreciosCompraService.save(sqtPreciosCompra)
        } catch (ValidationException e) {
            respond sqtPreciosCompra.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPreciosCompra.label', default: 'SqtPreciosCompra'), sqtPreciosCompra.id])
                redirect sqtPreciosCompra
            }
            '*' { respond sqtPreciosCompra, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPreciosCompraService.get(id)
    }

    def update(SqtPreciosCompra sqtPreciosCompra) {
        if (sqtPreciosCompra == null) {
            notFound()
            return
        }

        try {
            sqtPreciosCompraService.save(sqtPreciosCompra)
        } catch (ValidationException e) {
            respond sqtPreciosCompra.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPreciosCompra.label', default: 'SqtPreciosCompra'), sqtPreciosCompra.id])
                redirect sqtPreciosCompra
            }
            '*'{ respond sqtPreciosCompra, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPreciosCompraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPreciosCompra.label', default: 'SqtPreciosCompra'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPreciosCompra.label', default: 'SqtPreciosCompra'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
