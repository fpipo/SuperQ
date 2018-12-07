package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtBancoController {

    SqtBancoService sqtBancoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtBancoService.list(params), model:[sqtBancoCount: sqtBancoService.count()]
    }

    def show(Long id) {
        respond sqtBancoService.get(id)
    }

    def create() {
        respond new SqtBanco(params)
    }

    def save(SqtBanco sqtBanco) {
        if (sqtBanco == null) {
            notFound()
            return
        }

        try {
            sqtBancoService.save(sqtBanco)
        } catch (ValidationException e) {
            respond sqtBanco.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtBanco.label', default: 'SqtBanco'), sqtBanco.id])
                redirect sqtBanco
            }
            '*' { respond sqtBanco, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtBancoService.get(id)
    }

    def update(SqtBanco sqtBanco) {
        if (sqtBanco == null) {
            notFound()
            return
        }

        try {
            sqtBancoService.save(sqtBanco)
        } catch (ValidationException e) {
            respond sqtBanco.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtBanco.label', default: 'SqtBanco'), sqtBanco.id])
                redirect sqtBanco
            }
            '*'{ respond sqtBanco, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtBancoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtBanco.label', default: 'SqtBanco'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtBanco.label', default: 'SqtBanco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
