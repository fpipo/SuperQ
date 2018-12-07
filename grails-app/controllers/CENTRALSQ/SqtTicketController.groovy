package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTicketController {

    SqtTicketService sqtTicketService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTicketService.list(params), model:[sqtTicketCount: sqtTicketService.count()]
    }

    def show(Long id) {
        respond sqtTicketService.get(id)
    }

    def create() {
        respond new SqtTicket(params)
    }

    def save(SqtTicket sqtTicket) {
        if (sqtTicket == null) {
            notFound()
            return
        }

        try {
            sqtTicketService.save(sqtTicket)
        } catch (ValidationException e) {
            respond sqtTicket.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTicket.label', default: 'SqtTicket'), sqtTicket.id])
                redirect sqtTicket
            }
            '*' { respond sqtTicket, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTicketService.get(id)
    }

    def update(SqtTicket sqtTicket) {
        if (sqtTicket == null) {
            notFound()
            return
        }

        try {
            sqtTicketService.save(sqtTicket)
        } catch (ValidationException e) {
            respond sqtTicket.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTicket.label', default: 'SqtTicket'), sqtTicket.id])
                redirect sqtTicket
            }
            '*'{ respond sqtTicket, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTicketService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTicket.label', default: 'SqtTicket'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTicket.label', default: 'SqtTicket'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
