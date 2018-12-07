package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioController {

    SqtInventarioService sqtInventarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioService.list(params), model:[sqtInventarioCount: sqtInventarioService.count()]
    }

    def show(Long id) {
        respond sqtInventarioService.get(id)
    }

    def create() {
        respond new SqtInventario(params)
    }

    def save(SqtInventario sqtInventario) {
        if (sqtInventario == null) {
            notFound()
            return
        }

        try {
            sqtInventarioService.save(sqtInventario)
        } catch (ValidationException e) {
            respond sqtInventario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventario.label', default: 'SqtInventario'), sqtInventario.id])
                redirect sqtInventario
            }
            '*' { respond sqtInventario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioService.get(id)
    }

    def update(SqtInventario sqtInventario) {
        if (sqtInventario == null) {
            notFound()
            return
        }

        try {
            sqtInventarioService.save(sqtInventario)
        } catch (ValidationException e) {
            respond sqtInventario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventario.label', default: 'SqtInventario'), sqtInventario.id])
                redirect sqtInventario
            }
            '*'{ respond sqtInventario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventario.label', default: 'SqtInventario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventario.label', default: 'SqtInventario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
