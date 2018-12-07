package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCajaTiendaController {

    SqtCajaTiendaService sqtCajaTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCajaTiendaService.list(params), model:[sqtCajaTiendaCount: sqtCajaTiendaService.count()]
    }

    def show(Long id) {
        respond sqtCajaTiendaService.get(id)
    }

    def create() {
        respond new SqtCajaTienda(params)
    }

    def save(SqtCajaTienda sqtCajaTienda) {
        if (sqtCajaTienda == null) {
            notFound()
            return
        }

        try {
            sqtCajaTiendaService.save(sqtCajaTienda)
        } catch (ValidationException e) {
            respond sqtCajaTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCajaTienda.label', default: 'SqtCajaTienda'), sqtCajaTienda.id])
                redirect sqtCajaTienda
            }
            '*' { respond sqtCajaTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCajaTiendaService.get(id)
    }

    def update(SqtCajaTienda sqtCajaTienda) {
        if (sqtCajaTienda == null) {
            notFound()
            return
        }

        try {
            sqtCajaTiendaService.save(sqtCajaTienda)
        } catch (ValidationException e) {
            respond sqtCajaTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCajaTienda.label', default: 'SqtCajaTienda'), sqtCajaTienda.id])
                redirect sqtCajaTienda
            }
            '*'{ respond sqtCajaTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCajaTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCajaTienda.label', default: 'SqtCajaTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCajaTienda.label', default: 'SqtCajaTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
