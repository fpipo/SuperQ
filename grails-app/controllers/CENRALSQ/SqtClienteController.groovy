package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtClienteController {

    SqtClienteService sqtClienteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtClienteService.list(params), model:[sqtClienteCount: sqtClienteService.count()]
    }

    def show(Long id) {
        respond sqtClienteService.get(id)
    }

    def create() {
        respond new SqtCliente(params)
    }

    def save(SqtCliente sqtCliente) {
        if (sqtCliente == null) {
            notFound()
            return
        }

        try {
            sqtClienteService.save(sqtCliente)
        } catch (ValidationException e) {
            respond sqtCliente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCliente.label', default: 'SqtCliente'), sqtCliente.id])
                redirect sqtCliente
            }
            '*' { respond sqtCliente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtClienteService.get(id)
    }

    def update(SqtCliente sqtCliente) {
        if (sqtCliente == null) {
            notFound()
            return
        }

        try {
            sqtClienteService.save(sqtCliente)
        } catch (ValidationException e) {
            respond sqtCliente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCliente.label', default: 'SqtCliente'), sqtCliente.id])
                redirect sqtCliente
            }
            '*'{ respond sqtCliente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtClienteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCliente.label', default: 'SqtCliente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCliente.label', default: 'SqtCliente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
