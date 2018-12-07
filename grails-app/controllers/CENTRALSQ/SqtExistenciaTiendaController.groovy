package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtExistenciaTiendaController {

    SqtExistenciaTiendaService sqtExistenciaTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtExistenciaTiendaService.list(params), model:[sqtExistenciaTiendaCount: sqtExistenciaTiendaService.count()]
    }

    def show(Long id) {
        respond sqtExistenciaTiendaService.get(id)
    }

    def create() {
        respond new SqtExistenciaTienda(params)
    }

    def save(SqtExistenciaTienda sqtExistenciaTienda) {
        if (sqtExistenciaTienda == null) {
            notFound()
            return
        }

        try {
            sqtExistenciaTiendaService.save(sqtExistenciaTienda)
        } catch (ValidationException e) {
            respond sqtExistenciaTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtExistenciaTienda.label', default: 'SqtExistenciaTienda'), sqtExistenciaTienda.id])
                redirect sqtExistenciaTienda
            }
            '*' { respond sqtExistenciaTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtExistenciaTiendaService.get(id)
    }

    def update(SqtExistenciaTienda sqtExistenciaTienda) {
        if (sqtExistenciaTienda == null) {
            notFound()
            return
        }

        try {
            sqtExistenciaTiendaService.save(sqtExistenciaTienda)
        } catch (ValidationException e) {
            respond sqtExistenciaTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtExistenciaTienda.label', default: 'SqtExistenciaTienda'), sqtExistenciaTienda.id])
                redirect sqtExistenciaTienda
            }
            '*'{ respond sqtExistenciaTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtExistenciaTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtExistenciaTienda.label', default: 'SqtExistenciaTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtExistenciaTienda.label', default: 'SqtExistenciaTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
