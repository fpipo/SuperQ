package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCantidadTiendaController {

    SqtCantidadTiendaService sqtCantidadTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCantidadTiendaService.list(params), model:[sqtCantidadTiendaCount: sqtCantidadTiendaService.count()]
    }

    def show(Long id) {
        respond sqtCantidadTiendaService.get(id)
    }

    def create() {
        respond new SqtCantidadTienda(params)
    }

    def save(SqtCantidadTienda sqtCantidadTienda) {
        if (sqtCantidadTienda == null) {
            notFound()
            return
        }

        try {
            sqtCantidadTiendaService.save(sqtCantidadTienda)
        } catch (ValidationException e) {
            respond sqtCantidadTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCantidadTienda.label', default: 'SqtCantidadTienda'), sqtCantidadTienda.id])
                redirect sqtCantidadTienda
            }
            '*' { respond sqtCantidadTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCantidadTiendaService.get(id)
    }

    def update(SqtCantidadTienda sqtCantidadTienda) {
        if (sqtCantidadTienda == null) {
            notFound()
            return
        }

        try {
            sqtCantidadTiendaService.save(sqtCantidadTienda)
        } catch (ValidationException e) {
            respond sqtCantidadTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCantidadTienda.label', default: 'SqtCantidadTienda'), sqtCantidadTienda.id])
                redirect sqtCantidadTienda
            }
            '*'{ respond sqtCantidadTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCantidadTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCantidadTienda.label', default: 'SqtCantidadTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCantidadTienda.label', default: 'SqtCantidadTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
