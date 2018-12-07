package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtSupervisorSqController {

    SqtSupervisorSqService sqtSupervisorSqService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtSupervisorSqService.list(params), model:[sqtSupervisorSqCount: sqtSupervisorSqService.count()]
    }

    def show(Long id) {
        respond sqtSupervisorSqService.get(id)
    }

    def create() {
        respond new SqtSupervisorSq(params)
    }

    def save(SqtSupervisorSq sqtSupervisorSq) {
        if (sqtSupervisorSq == null) {
            notFound()
            return
        }

        try {
            sqtSupervisorSqService.save(sqtSupervisorSq)
        } catch (ValidationException e) {
            respond sqtSupervisorSq.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtSupervisorSq.label', default: 'SqtSupervisorSq'), sqtSupervisorSq.id])
                redirect sqtSupervisorSq
            }
            '*' { respond sqtSupervisorSq, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtSupervisorSqService.get(id)
    }

    def update(SqtSupervisorSq sqtSupervisorSq) {
        if (sqtSupervisorSq == null) {
            notFound()
            return
        }

        try {
            sqtSupervisorSqService.save(sqtSupervisorSq)
        } catch (ValidationException e) {
            respond sqtSupervisorSq.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtSupervisorSq.label', default: 'SqtSupervisorSq'), sqtSupervisorSq.id])
                redirect sqtSupervisorSq
            }
            '*'{ respond sqtSupervisorSq, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtSupervisorSqService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtSupervisorSq.label', default: 'SqtSupervisorSq'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtSupervisorSq.label', default: 'SqtSupervisorSq'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
