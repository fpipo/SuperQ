package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRemesasController {

    SqtRemesasService sqtRemesasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRemesasService.list(params), model:[sqtRemesasCount: sqtRemesasService.count()]
    }

    def show(Long id) {
        respond sqtRemesasService.get(id)
    }

    def create() {
        respond new SqtRemesas(params)
    }

    def save(SqtRemesas sqtRemesas) {
        if (sqtRemesas == null) {
            notFound()
            return
        }

        try {
            sqtRemesasService.save(sqtRemesas)
        } catch (ValidationException e) {
            respond sqtRemesas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRemesas.label', default: 'SqtRemesas'), sqtRemesas.id])
                redirect sqtRemesas
            }
            '*' { respond sqtRemesas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRemesasService.get(id)
    }

    def update(SqtRemesas sqtRemesas) {
        if (sqtRemesas == null) {
            notFound()
            return
        }

        try {
            sqtRemesasService.save(sqtRemesas)
        } catch (ValidationException e) {
            respond sqtRemesas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRemesas.label', default: 'SqtRemesas'), sqtRemesas.id])
                redirect sqtRemesas
            }
            '*'{ respond sqtRemesas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRemesasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRemesas.label', default: 'SqtRemesas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRemesas.label', default: 'SqtRemesas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
