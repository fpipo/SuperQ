package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtKardexBanamexController {

    SqtKardexBanamexService sqtKardexBanamexService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtKardexBanamexService.list(params), model:[sqtKardexBanamexCount: sqtKardexBanamexService.count()]
    }

    def show(Long id) {
        respond sqtKardexBanamexService.get(id)
    }

    def create() {
        respond new SqtKardexBanamex(params)
    }

    def save(SqtKardexBanamex sqtKardexBanamex) {
        if (sqtKardexBanamex == null) {
            notFound()
            return
        }

        try {
            sqtKardexBanamexService.save(sqtKardexBanamex)
        } catch (ValidationException e) {
            respond sqtKardexBanamex.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtKardexBanamex.label', default: 'SqtKardexBanamex'), sqtKardexBanamex.id])
                redirect sqtKardexBanamex
            }
            '*' { respond sqtKardexBanamex, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtKardexBanamexService.get(id)
    }

    def update(SqtKardexBanamex sqtKardexBanamex) {
        if (sqtKardexBanamex == null) {
            notFound()
            return
        }

        try {
            sqtKardexBanamexService.save(sqtKardexBanamex)
        } catch (ValidationException e) {
            respond sqtKardexBanamex.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtKardexBanamex.label', default: 'SqtKardexBanamex'), sqtKardexBanamex.id])
                redirect sqtKardexBanamex
            }
            '*'{ respond sqtKardexBanamex, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtKardexBanamexService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtKardexBanamex.label', default: 'SqtKardexBanamex'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtKardexBanamex.label', default: 'SqtKardexBanamex'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
