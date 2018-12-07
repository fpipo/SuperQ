package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtUsuarioTiendaController {

    SqtUsuarioTiendaService sqtUsuarioTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtUsuarioTiendaService.list(params), model:[sqtUsuarioTiendaCount: sqtUsuarioTiendaService.count()]
    }

    def show(Long id) {
        respond sqtUsuarioTiendaService.get(id)
    }

    def create() {
        respond new SqtUsuarioTienda(params)
    }

    def save(SqtUsuarioTienda sqtUsuarioTienda) {
        if (sqtUsuarioTienda == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioTiendaService.save(sqtUsuarioTienda)
        } catch (ValidationException e) {
            respond sqtUsuarioTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtUsuarioTienda.label', default: 'SqtUsuarioTienda'), sqtUsuarioTienda.id])
                redirect sqtUsuarioTienda
            }
            '*' { respond sqtUsuarioTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtUsuarioTiendaService.get(id)
    }

    def update(SqtUsuarioTienda sqtUsuarioTienda) {
        if (sqtUsuarioTienda == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioTiendaService.save(sqtUsuarioTienda)
        } catch (ValidationException e) {
            respond sqtUsuarioTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtUsuarioTienda.label', default: 'SqtUsuarioTienda'), sqtUsuarioTienda.id])
                redirect sqtUsuarioTienda
            }
            '*'{ respond sqtUsuarioTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtUsuarioTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtUsuarioTienda.label', default: 'SqtUsuarioTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtUsuarioTienda.label', default: 'SqtUsuarioTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
