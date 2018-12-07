package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCuentaBancoController {

    SqtCuentaBancoService sqtCuentaBancoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCuentaBancoService.list(params), model:[sqtCuentaBancoCount: sqtCuentaBancoService.count()]
    }

    def show(Long id) {
        respond sqtCuentaBancoService.get(id)
    }

    def create() {
        respond new SqtCuentaBanco(params)
    }

    def save(SqtCuentaBanco sqtCuentaBanco) {
        if (sqtCuentaBanco == null) {
            notFound()
            return
        }

        try {
            sqtCuentaBancoService.save(sqtCuentaBanco)
        } catch (ValidationException e) {
            respond sqtCuentaBanco.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCuentaBanco.label', default: 'SqtCuentaBanco'), sqtCuentaBanco.id])
                redirect sqtCuentaBanco
            }
            '*' { respond sqtCuentaBanco, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCuentaBancoService.get(id)
    }

    def update(SqtCuentaBanco sqtCuentaBanco) {
        if (sqtCuentaBanco == null) {
            notFound()
            return
        }

        try {
            sqtCuentaBancoService.save(sqtCuentaBanco)
        } catch (ValidationException e) {
            respond sqtCuentaBanco.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCuentaBanco.label', default: 'SqtCuentaBanco'), sqtCuentaBanco.id])
                redirect sqtCuentaBanco
            }
            '*'{ respond sqtCuentaBanco, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCuentaBancoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCuentaBanco.label', default: 'SqtCuentaBanco'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCuentaBanco.label', default: 'SqtCuentaBanco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
