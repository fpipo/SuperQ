package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTicketDiverzaController {

    SqtTicketDiverzaService sqtTicketDiverzaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTicketDiverzaService.list(params), model:[sqtTicketDiverzaCount: sqtTicketDiverzaService.count()]
    }

    def show(Long id) {
        respond sqtTicketDiverzaService.get(id)
    }

    def create() {
        respond new SqtTicketDiverza(params)
    }

    def save(SqtTicketDiverza sqtTicketDiverza) {
        if (sqtTicketDiverza == null) {
            notFound()
            return
        }

        try {
            sqtTicketDiverzaService.save(sqtTicketDiverza)
        } catch (ValidationException e) {
            respond sqtTicketDiverza.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTicketDiverza.label', default: 'SqtTicketDiverza'), sqtTicketDiverza.id])
                redirect sqtTicketDiverza
            }
            '*' { respond sqtTicketDiverza, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTicketDiverzaService.get(id)
    }

    def update(SqtTicketDiverza sqtTicketDiverza) {
        if (sqtTicketDiverza == null) {
            notFound()
            return
        }

        try {
            sqtTicketDiverzaService.save(sqtTicketDiverza)
        } catch (ValidationException e) {
            respond sqtTicketDiverza.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTicketDiverza.label', default: 'SqtTicketDiverza'), sqtTicketDiverza.id])
                redirect sqtTicketDiverza
            }
            '*'{ respond sqtTicketDiverza, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTicketDiverzaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTicketDiverza.label', default: 'SqtTicketDiverza'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTicketDiverza.label', default: 'SqtTicketDiverza'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
