package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDeudorController {

    SqtDeudorService sqtDeudorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDeudorService.list(params), model:[sqtDeudorCount: sqtDeudorService.count()]
    }

    def show(Long id) {
        respond sqtDeudorService.get(id)
    }

    def create() {
        respond new SqtDeudor(params)
    }

    def save(SqtDeudor sqtDeudor) {
        if (sqtDeudor == null) {
            notFound()
            return
        }

        try {
            sqtDeudorService.save(sqtDeudor)
        } catch (ValidationException e) {
            respond sqtDeudor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDeudor.label', default: 'SqtDeudor'), sqtDeudor.id])
                redirect sqtDeudor
            }
            '*' { respond sqtDeudor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDeudorService.get(id)
    }

    def update(SqtDeudor sqtDeudor) {
        if (sqtDeudor == null) {
            notFound()
            return
        }

        try {
            sqtDeudorService.save(sqtDeudor)
        } catch (ValidationException e) {
            respond sqtDeudor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDeudor.label', default: 'SqtDeudor'), sqtDeudor.id])
                redirect sqtDeudor
            }
            '*'{ respond sqtDeudor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDeudorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDeudor.label', default: 'SqtDeudor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDeudor.label', default: 'SqtDeudor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
