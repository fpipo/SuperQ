package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtResposableTiendaController {

    SqtResposableTiendaService sqtResposableTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtResposableTiendaService.list(params), model:[sqtResposableTiendaCount: sqtResposableTiendaService.count()]
    }

    def show(Long id) {
        respond sqtResposableTiendaService.get(id)
    }

    def create() {
        respond new SqtResposableTienda(params)
    }

    def save(SqtResposableTienda sqtResposableTienda) {
        if (sqtResposableTienda == null) {
            notFound()
            return
        }

        try {
            sqtResposableTiendaService.save(sqtResposableTienda)
        } catch (ValidationException e) {
            respond sqtResposableTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtResposableTienda.label', default: 'SqtResposableTienda'), sqtResposableTienda.id])
                redirect sqtResposableTienda
            }
            '*' { respond sqtResposableTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtResposableTiendaService.get(id)
    }

    def update(SqtResposableTienda sqtResposableTienda) {
        if (sqtResposableTienda == null) {
            notFound()
            return
        }

        try {
            sqtResposableTiendaService.save(sqtResposableTienda)
        } catch (ValidationException e) {
            respond sqtResposableTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtResposableTienda.label', default: 'SqtResposableTienda'), sqtResposableTienda.id])
                redirect sqtResposableTienda
            }
            '*'{ respond sqtResposableTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtResposableTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtResposableTienda.label', default: 'SqtResposableTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtResposableTienda.label', default: 'SqtResposableTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
