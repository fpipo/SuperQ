package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtVisitaSupervisorController {

    SqtVisitaSupervisorService sqtVisitaSupervisorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtVisitaSupervisorService.list(params), model:[sqtVisitaSupervisorCount: sqtVisitaSupervisorService.count()]
    }

    def show(Long id) {
        respond sqtVisitaSupervisorService.get(id)
    }

    def create() {
        respond new SqtVisitaSupervisor(params)
    }

    def save(SqtVisitaSupervisor sqtVisitaSupervisor) {
        if (sqtVisitaSupervisor == null) {
            notFound()
            return
        }

        try {
            sqtVisitaSupervisorService.save(sqtVisitaSupervisor)
        } catch (ValidationException e) {
            respond sqtVisitaSupervisor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtVisitaSupervisor.label', default: 'SqtVisitaSupervisor'), sqtVisitaSupervisor.id])
                redirect sqtVisitaSupervisor
            }
            '*' { respond sqtVisitaSupervisor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtVisitaSupervisorService.get(id)
    }

    def update(SqtVisitaSupervisor sqtVisitaSupervisor) {
        if (sqtVisitaSupervisor == null) {
            notFound()
            return
        }

        try {
            sqtVisitaSupervisorService.save(sqtVisitaSupervisor)
        } catch (ValidationException e) {
            respond sqtVisitaSupervisor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtVisitaSupervisor.label', default: 'SqtVisitaSupervisor'), sqtVisitaSupervisor.id])
                redirect sqtVisitaSupervisor
            }
            '*'{ respond sqtVisitaSupervisor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtVisitaSupervisorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtVisitaSupervisor.label', default: 'SqtVisitaSupervisor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtVisitaSupervisor.label', default: 'SqtVisitaSupervisor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
