package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMensajesTicketController {

    SqtMensajesTicketService sqtMensajesTicketService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMensajesTicketService.list(params), model:[sqtMensajesTicketCount: sqtMensajesTicketService.count()]
    }

    def show(Long id) {
        respond sqtMensajesTicketService.get(id)
    }

    def create() {
        respond new SqtMensajesTicket(params)
    }

    def save(SqtMensajesTicket sqtMensajesTicket) {
        if (sqtMensajesTicket == null) {
            notFound()
            return
        }

        try {
            sqtMensajesTicketService.save(sqtMensajesTicket)
        } catch (ValidationException e) {
            respond sqtMensajesTicket.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMensajesTicket.label', default: 'SqtMensajesTicket'), sqtMensajesTicket.id])
                redirect sqtMensajesTicket
            }
            '*' { respond sqtMensajesTicket, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMensajesTicketService.get(id)
    }

    def update(SqtMensajesTicket sqtMensajesTicket) {
        if (sqtMensajesTicket == null) {
            notFound()
            return
        }

        try {
            sqtMensajesTicketService.save(sqtMensajesTicket)
        } catch (ValidationException e) {
            respond sqtMensajesTicket.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMensajesTicket.label', default: 'SqtMensajesTicket'), sqtMensajesTicket.id])
                redirect sqtMensajesTicket
            }
            '*'{ respond sqtMensajesTicket, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMensajesTicketService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMensajesTicket.label', default: 'SqtMensajesTicket'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMensajesTicket.label', default: 'SqtMensajesTicket'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
