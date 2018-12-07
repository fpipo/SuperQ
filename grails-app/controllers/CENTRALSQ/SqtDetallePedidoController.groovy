package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetallePedidoController {

    SqtDetallePedidoService sqtDetallePedidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetallePedidoService.list(params), model:[sqtDetallePedidoCount: sqtDetallePedidoService.count()]
    }

    def show(Long id) {
        respond sqtDetallePedidoService.get(id)
    }

    def create() {
        respond new SqtDetallePedido(params)
    }

    def save(SqtDetallePedido sqtDetallePedido) {
        if (sqtDetallePedido == null) {
            notFound()
            return
        }

        try {
            sqtDetallePedidoService.save(sqtDetallePedido)
        } catch (ValidationException e) {
            respond sqtDetallePedido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetallePedido.label', default: 'SqtDetallePedido'), sqtDetallePedido.id])
                redirect sqtDetallePedido
            }
            '*' { respond sqtDetallePedido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetallePedidoService.get(id)
    }

    def update(SqtDetallePedido sqtDetallePedido) {
        if (sqtDetallePedido == null) {
            notFound()
            return
        }

        try {
            sqtDetallePedidoService.save(sqtDetallePedido)
        } catch (ValidationException e) {
            respond sqtDetallePedido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetallePedido.label', default: 'SqtDetallePedido'), sqtDetallePedido.id])
                redirect sqtDetallePedido
            }
            '*'{ respond sqtDetallePedido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetallePedidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetallePedido.label', default: 'SqtDetallePedido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetallePedido.label', default: 'SqtDetallePedido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
