package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPedidoController {

    SqtPedidoService sqtPedidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPedidoService.list(params), model:[sqtPedidoCount: sqtPedidoService.count()]
    }

    def show(Long id) {
        respond sqtPedidoService.get(id)
    }

    def create() {
        respond new SqtPedido(params)
    }

    def save(SqtPedido sqtPedido) {
        if (sqtPedido == null) {
            notFound()
            return
        }

        try {
            sqtPedidoService.save(sqtPedido)
        } catch (ValidationException e) {
            respond sqtPedido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPedido.label', default: 'SqtPedido'), sqtPedido.id])
                redirect sqtPedido
            }
            '*' { respond sqtPedido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPedidoService.get(id)
    }

    def update(SqtPedido sqtPedido) {
        if (sqtPedido == null) {
            notFound()
            return
        }

        try {
            sqtPedidoService.save(sqtPedido)
        } catch (ValidationException e) {
            respond sqtPedido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPedido.label', default: 'SqtPedido'), sqtPedido.id])
                redirect sqtPedido
            }
            '*'{ respond sqtPedido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPedidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPedido.label', default: 'SqtPedido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPedido.label', default: 'SqtPedido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
