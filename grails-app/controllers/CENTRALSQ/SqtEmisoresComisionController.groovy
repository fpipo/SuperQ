package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtEmisoresComisionController {

    SqtEmisoresComisionService sqtEmisoresComisionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtEmisoresComisionService.list(params), model:[sqtEmisoresComisionCount: sqtEmisoresComisionService.count()]
    }

    def show(Long id) {
        respond sqtEmisoresComisionService.get(id)
    }

    def create() {
        respond new SqtEmisoresComision(params)
    }

    def save(SqtEmisoresComision sqtEmisoresComision) {
        if (sqtEmisoresComision == null) {
            notFound()
            return
        }

        try {
            sqtEmisoresComisionService.save(sqtEmisoresComision)
        } catch (ValidationException e) {
            respond sqtEmisoresComision.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtEmisoresComision.label', default: 'SqtEmisoresComision'), sqtEmisoresComision.id])
                redirect sqtEmisoresComision
            }
            '*' { respond sqtEmisoresComision, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtEmisoresComisionService.get(id)
    }

    def update(SqtEmisoresComision sqtEmisoresComision) {
        if (sqtEmisoresComision == null) {
            notFound()
            return
        }

        try {
            sqtEmisoresComisionService.save(sqtEmisoresComision)
        } catch (ValidationException e) {
            respond sqtEmisoresComision.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtEmisoresComision.label', default: 'SqtEmisoresComision'), sqtEmisoresComision.id])
                redirect sqtEmisoresComision
            }
            '*'{ respond sqtEmisoresComision, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtEmisoresComisionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtEmisoresComision.label', default: 'SqtEmisoresComision'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtEmisoresComision.label', default: 'SqtEmisoresComision'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
