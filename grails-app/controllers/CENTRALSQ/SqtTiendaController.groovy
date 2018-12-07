package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTiendaController {

    SqtTiendaService sqtTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTiendaService.list(params), model:[sqtTiendaCount: sqtTiendaService.count()]
    }

    def show(Long id) {
        respond sqtTiendaService.get(id)
    }

    def create() {
        respond new SqtTienda(params)
    }

    def save(SqtTienda sqtTienda) {
        if (sqtTienda == null) {
            notFound()
            return
        }

        try {
            sqtTiendaService.save(sqtTienda)
        } catch (ValidationException e) {
            respond sqtTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTienda.label', default: 'SqtTienda'), sqtTienda.id])
                redirect sqtTienda
            }
            '*' { respond sqtTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTiendaService.get(id)
    }

    def update(SqtTienda sqtTienda) {
        if (sqtTienda == null) {
            notFound()
            return
        }

        try {
            sqtTiendaService.save(sqtTienda)
        } catch (ValidationException e) {
            respond sqtTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTienda.label', default: 'SqtTienda'), sqtTienda.id])
                redirect sqtTienda
            }
            '*'{ respond sqtTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTienda.label', default: 'SqtTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTienda.label', default: 'SqtTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
