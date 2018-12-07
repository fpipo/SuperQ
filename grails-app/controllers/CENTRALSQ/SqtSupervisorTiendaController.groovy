package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtSupervisorTiendaController {

    SqtSupervisorTiendaService sqtSupervisorTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtSupervisorTiendaService.list(params), model:[sqtSupervisorTiendaCount: sqtSupervisorTiendaService.count()]
    }

    def show(Long id) {
        respond sqtSupervisorTiendaService.get(id)
    }

    def create() {
        respond new SqtSupervisorTienda(params)
    }

    def save(SqtSupervisorTienda sqtSupervisorTienda) {
        if (sqtSupervisorTienda == null) {
            notFound()
            return
        }

        try {
            sqtSupervisorTiendaService.save(sqtSupervisorTienda)
        } catch (ValidationException e) {
            respond sqtSupervisorTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtSupervisorTienda.label', default: 'SqtSupervisorTienda'), sqtSupervisorTienda.id])
                redirect sqtSupervisorTienda
            }
            '*' { respond sqtSupervisorTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtSupervisorTiendaService.get(id)
    }

    def update(SqtSupervisorTienda sqtSupervisorTienda) {
        if (sqtSupervisorTienda == null) {
            notFound()
            return
        }

        try {
            sqtSupervisorTiendaService.save(sqtSupervisorTienda)
        } catch (ValidationException e) {
            respond sqtSupervisorTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtSupervisorTienda.label', default: 'SqtSupervisorTienda'), sqtSupervisorTienda.id])
                redirect sqtSupervisorTienda
            }
            '*'{ respond sqtSupervisorTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtSupervisorTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtSupervisorTienda.label', default: 'SqtSupervisorTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtSupervisorTienda.label', default: 'SqtSupervisorTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
