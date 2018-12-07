package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtUsuarioIusaController {

    SqtUsuarioIusaService sqtUsuarioIusaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtUsuarioIusaService.list(params), model:[sqtUsuarioIusaCount: sqtUsuarioIusaService.count()]
    }

    def show(Long id) {
        respond sqtUsuarioIusaService.get(id)
    }

    def create() {
        respond new SqtUsuarioIusa(params)
    }

    def save(SqtUsuarioIusa sqtUsuarioIusa) {
        if (sqtUsuarioIusa == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioIusaService.save(sqtUsuarioIusa)
        } catch (ValidationException e) {
            respond sqtUsuarioIusa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtUsuarioIusa.label', default: 'SqtUsuarioIusa'), sqtUsuarioIusa.id])
                redirect sqtUsuarioIusa
            }
            '*' { respond sqtUsuarioIusa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtUsuarioIusaService.get(id)
    }

    def update(SqtUsuarioIusa sqtUsuarioIusa) {
        if (sqtUsuarioIusa == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioIusaService.save(sqtUsuarioIusa)
        } catch (ValidationException e) {
            respond sqtUsuarioIusa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtUsuarioIusa.label', default: 'SqtUsuarioIusa'), sqtUsuarioIusa.id])
                redirect sqtUsuarioIusa
            }
            '*'{ respond sqtUsuarioIusa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtUsuarioIusaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtUsuarioIusa.label', default: 'SqtUsuarioIusa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtUsuarioIusa.label', default: 'SqtUsuarioIusa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
