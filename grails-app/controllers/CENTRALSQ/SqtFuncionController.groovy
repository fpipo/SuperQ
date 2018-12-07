package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtFuncionController {

    SqtFuncionService sqtFuncionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtFuncionService.list(params), model:[sqtFuncionCount: sqtFuncionService.count()]
    }

    def show(Long id) {
        respond sqtFuncionService.get(id)
    }

    def create() {
        respond new SqtFuncion(params)
    }

    def save(SqtFuncion sqtFuncion) {
        if (sqtFuncion == null) {
            notFound()
            return
        }

        try {
            sqtFuncionService.save(sqtFuncion)
        } catch (ValidationException e) {
            respond sqtFuncion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtFuncion.label', default: 'SqtFuncion'), sqtFuncion.id])
                redirect sqtFuncion
            }
            '*' { respond sqtFuncion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtFuncionService.get(id)
    }

    def update(SqtFuncion sqtFuncion) {
        if (sqtFuncion == null) {
            notFound()
            return
        }

        try {
            sqtFuncionService.save(sqtFuncion)
        } catch (ValidationException e) {
            respond sqtFuncion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtFuncion.label', default: 'SqtFuncion'), sqtFuncion.id])
                redirect sqtFuncion
            }
            '*'{ respond sqtFuncion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtFuncionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtFuncion.label', default: 'SqtFuncion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtFuncion.label', default: 'SqtFuncion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
