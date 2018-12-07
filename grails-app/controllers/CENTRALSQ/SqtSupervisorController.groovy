package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtSupervisorController {

    SqtSupervisorService sqtSupervisorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtSupervisorService.list(params), model:[sqtSupervisorCount: sqtSupervisorService.count()]
    }

    def show(Long id) {
        respond sqtSupervisorService.get(id)
    }

    def create() {
        respond new SqtSupervisor(params)
    }

    def save(SqtSupervisor sqtSupervisor) {
        if (sqtSupervisor == null) {
            notFound()
            return
        }

        try {
            sqtSupervisorService.save(sqtSupervisor)
        } catch (ValidationException e) {
            respond sqtSupervisor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtSupervisor.label', default: 'SqtSupervisor'), sqtSupervisor.id])
                redirect sqtSupervisor
            }
            '*' { respond sqtSupervisor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtSupervisorService.get(id)
    }

    def update(SqtSupervisor sqtSupervisor) {
        if (sqtSupervisor == null) {
            notFound()
            return
        }

        try {
            sqtSupervisorService.save(sqtSupervisor)
        } catch (ValidationException e) {
            respond sqtSupervisor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtSupervisor.label', default: 'SqtSupervisor'), sqtSupervisor.id])
                redirect sqtSupervisor
            }
            '*'{ respond sqtSupervisor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtSupervisorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtSupervisor.label', default: 'SqtSupervisor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtSupervisor.label', default: 'SqtSupervisor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
