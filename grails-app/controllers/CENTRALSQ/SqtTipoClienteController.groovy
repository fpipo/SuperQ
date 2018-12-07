package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTipoClienteController {

    SqtTipoClienteService sqtTipoClienteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTipoClienteService.list(params), model:[sqtTipoClienteCount: sqtTipoClienteService.count()]
    }

    def show(Long id) {
        respond sqtTipoClienteService.get(id)
    }

    def create() {
        respond new SqtTipoCliente(params)
    }

    def save(SqtTipoCliente sqtTipoCliente) {
        if (sqtTipoCliente == null) {
            notFound()
            return
        }

        try {
            sqtTipoClienteService.save(sqtTipoCliente)
        } catch (ValidationException e) {
            respond sqtTipoCliente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTipoCliente.label', default: 'SqtTipoCliente'), sqtTipoCliente.id])
                redirect sqtTipoCliente
            }
            '*' { respond sqtTipoCliente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTipoClienteService.get(id)
    }

    def update(SqtTipoCliente sqtTipoCliente) {
        if (sqtTipoCliente == null) {
            notFound()
            return
        }

        try {
            sqtTipoClienteService.save(sqtTipoCliente)
        } catch (ValidationException e) {
            respond sqtTipoCliente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTipoCliente.label', default: 'SqtTipoCliente'), sqtTipoCliente.id])
                redirect sqtTipoCliente
            }
            '*'{ respond sqtTipoCliente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTipoClienteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTipoCliente.label', default: 'SqtTipoCliente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTipoCliente.label', default: 'SqtTipoCliente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
