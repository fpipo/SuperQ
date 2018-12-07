package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtTelefonoController {

    SqtTelefonoService sqtTelefonoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtTelefonoService.list(params), model:[sqtTelefonoCount: sqtTelefonoService.count()]
    }

    def show(Long id) {
        respond sqtTelefonoService.get(id)
    }

    def create() {
        respond new SqtTelefono(params)
    }

    def save(SqtTelefono sqtTelefono) {
        if (sqtTelefono == null) {
            notFound()
            return
        }

        try {
            sqtTelefonoService.save(sqtTelefono)
        } catch (ValidationException e) {
            respond sqtTelefono.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtTelefono.label', default: 'SqtTelefono'), sqtTelefono.id])
                redirect sqtTelefono
            }
            '*' { respond sqtTelefono, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtTelefonoService.get(id)
    }

    def update(SqtTelefono sqtTelefono) {
        if (sqtTelefono == null) {
            notFound()
            return
        }

        try {
            sqtTelefonoService.save(sqtTelefono)
        } catch (ValidationException e) {
            respond sqtTelefono.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtTelefono.label', default: 'SqtTelefono'), sqtTelefono.id])
                redirect sqtTelefono
            }
            '*'{ respond sqtTelefono, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtTelefonoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtTelefono.label', default: 'SqtTelefono'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtTelefono.label', default: 'SqtTelefono'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
