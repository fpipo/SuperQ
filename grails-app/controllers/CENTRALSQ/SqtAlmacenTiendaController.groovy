package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAlmacenTiendaController {

    SqtAlmacenTiendaService sqtAlmacenTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAlmacenTiendaService.list(params), model:[sqtAlmacenTiendaCount: sqtAlmacenTiendaService.count()]
    }

    def show(Long id) {
        respond sqtAlmacenTiendaService.get(id)
    }

    def create() {
        respond new SqtAlmacenTienda(params)
    }

    def save(SqtAlmacenTienda sqtAlmacenTienda) {
        if (sqtAlmacenTienda == null) {
            notFound()
            return
        }

        try {
            sqtAlmacenTiendaService.save(sqtAlmacenTienda)
        } catch (ValidationException e) {
            respond sqtAlmacenTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAlmacenTienda.label', default: 'SqtAlmacenTienda'), sqtAlmacenTienda.id])
                redirect sqtAlmacenTienda
            }
            '*' { respond sqtAlmacenTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAlmacenTiendaService.get(id)
    }

    def update(SqtAlmacenTienda sqtAlmacenTienda) {
        if (sqtAlmacenTienda == null) {
            notFound()
            return
        }

        try {
            sqtAlmacenTiendaService.save(sqtAlmacenTienda)
        } catch (ValidationException e) {
            respond sqtAlmacenTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAlmacenTienda.label', default: 'SqtAlmacenTienda'), sqtAlmacenTienda.id])
                redirect sqtAlmacenTienda
            }
            '*'{ respond sqtAlmacenTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAlmacenTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAlmacenTienda.label', default: 'SqtAlmacenTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAlmacenTienda.label', default: 'SqtAlmacenTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
