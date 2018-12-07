package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAcreedorController {

    SqtAcreedorService sqtAcreedorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAcreedorService.list(params), model:[sqtAcreedorCount: sqtAcreedorService.count()]
    }

    def show(Long id) {
        respond sqtAcreedorService.get(id)
    }

    def create() {
        respond new SqtAcreedor(params)
    }

    def save(SqtAcreedor sqtAcreedor) {
        if (sqtAcreedor == null) {
            notFound()
            return
        }

        try {
            sqtAcreedorService.save(sqtAcreedor)
        } catch (ValidationException e) {
            respond sqtAcreedor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAcreedor.label', default: 'SqtAcreedor'), sqtAcreedor.id])
                redirect sqtAcreedor
            }
            '*' { respond sqtAcreedor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAcreedorService.get(id)
    }

    def update(SqtAcreedor sqtAcreedor) {
        if (sqtAcreedor == null) {
            notFound()
            return
        }

        try {
            sqtAcreedorService.save(sqtAcreedor)
        } catch (ValidationException e) {
            respond sqtAcreedor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAcreedor.label', default: 'SqtAcreedor'), sqtAcreedor.id])
                redirect sqtAcreedor
            }
            '*'{ respond sqtAcreedor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAcreedorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAcreedor.label', default: 'SqtAcreedor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAcreedor.label', default: 'SqtAcreedor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
