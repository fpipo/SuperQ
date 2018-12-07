package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioTiendaController {

    SqtInventarioTiendaService sqtInventarioTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioTiendaService.list(params), model:[sqtInventarioTiendaCount: sqtInventarioTiendaService.count()]
    }

    def show(Long id) {
        respond sqtInventarioTiendaService.get(id)
    }

    def create() {
        respond new SqtInventarioTienda(params)
    }

    def save(SqtInventarioTienda sqtInventarioTienda) {
        if (sqtInventarioTienda == null) {
            notFound()
            return
        }

        try {
            sqtInventarioTiendaService.save(sqtInventarioTienda)
        } catch (ValidationException e) {
            respond sqtInventarioTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioTienda.label', default: 'SqtInventarioTienda'), sqtInventarioTienda.id])
                redirect sqtInventarioTienda
            }
            '*' { respond sqtInventarioTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioTiendaService.get(id)
    }

    def update(SqtInventarioTienda sqtInventarioTienda) {
        if (sqtInventarioTienda == null) {
            notFound()
            return
        }

        try {
            sqtInventarioTiendaService.save(sqtInventarioTienda)
        } catch (ValidationException e) {
            respond sqtInventarioTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioTienda.label', default: 'SqtInventarioTienda'), sqtInventarioTienda.id])
                redirect sqtInventarioTienda
            }
            '*'{ respond sqtInventarioTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioTienda.label', default: 'SqtInventarioTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioTienda.label', default: 'SqtInventarioTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
