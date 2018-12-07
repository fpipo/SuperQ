package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCotizacionPedidoController {

    SqtCotizacionPedidoService sqtCotizacionPedidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCotizacionPedidoService.list(params), model:[sqtCotizacionPedidoCount: sqtCotizacionPedidoService.count()]
    }

    def show(Long id) {
        respond sqtCotizacionPedidoService.get(id)
    }

    def create() {
        respond new SqtCotizacionPedido(params)
    }

    def save(SqtCotizacionPedido sqtCotizacionPedido) {
        if (sqtCotizacionPedido == null) {
            notFound()
            return
        }

        try {
            sqtCotizacionPedidoService.save(sqtCotizacionPedido)
        } catch (ValidationException e) {
            respond sqtCotizacionPedido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCotizacionPedido.label', default: 'SqtCotizacionPedido'), sqtCotizacionPedido.id])
                redirect sqtCotizacionPedido
            }
            '*' { respond sqtCotizacionPedido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCotizacionPedidoService.get(id)
    }

    def update(SqtCotizacionPedido sqtCotizacionPedido) {
        if (sqtCotizacionPedido == null) {
            notFound()
            return
        }

        try {
            sqtCotizacionPedidoService.save(sqtCotizacionPedido)
        } catch (ValidationException e) {
            respond sqtCotizacionPedido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCotizacionPedido.label', default: 'SqtCotizacionPedido'), sqtCotizacionPedido.id])
                redirect sqtCotizacionPedido
            }
            '*'{ respond sqtCotizacionPedido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCotizacionPedidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCotizacionPedido.label', default: 'SqtCotizacionPedido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCotizacionPedido.label', default: 'SqtCotizacionPedido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
