package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtKardexController {

    SqtKardexService sqtKardexService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtKardexService.list(params), model:[sqtKardexCount: sqtKardexService.count()]
    }

    def show(Long id) {
        respond sqtKardexService.get(id)
    }

    def create() {
        respond new SqtKardex(params)
    }

    def save(SqtKardex sqtKardex) {
        if (sqtKardex == null) {
            notFound()
            return
        }

        try {
            sqtKardexService.save(sqtKardex)
        } catch (ValidationException e) {
            respond sqtKardex.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtKardex.label', default: 'SqtKardex'), sqtKardex.id])
                redirect sqtKardex
            }
            '*' { respond sqtKardex, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtKardexService.get(id)
    }

    def update(SqtKardex sqtKardex) {
        if (sqtKardex == null) {
            notFound()
            return
        }

        try {
            sqtKardexService.save(sqtKardex)
        } catch (ValidationException e) {
            respond sqtKardex.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtKardex.label', default: 'SqtKardex'), sqtKardex.id])
                redirect sqtKardex
            }
            '*'{ respond sqtKardex, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtKardexService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtKardex.label', default: 'SqtKardex'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtKardex.label', default: 'SqtKardex'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
