package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtUsuarioController {

    SqtUsuarioService sqtUsuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtUsuarioService.list(params), model:[sqtUsuarioCount: sqtUsuarioService.count()]
    }

    def show(Long id) {
        respond sqtUsuarioService.get(id)
    }

    def create() {
        respond new SqtUsuario(params)
    }

    def save(SqtUsuario sqtUsuario) {
        if (sqtUsuario == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioService.save(sqtUsuario)
        } catch (ValidationException e) {
            respond sqtUsuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtUsuario.label', default: 'SqtUsuario'), sqtUsuario.id])
                redirect sqtUsuario
            }
            '*' { respond sqtUsuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtUsuarioService.get(id)
    }

    def update(SqtUsuario sqtUsuario) {
        if (sqtUsuario == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioService.save(sqtUsuario)
        } catch (ValidationException e) {
            respond sqtUsuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtUsuario.label', default: 'SqtUsuario'), sqtUsuario.id])
                redirect sqtUsuario
            }
            '*'{ respond sqtUsuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtUsuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtUsuario.label', default: 'SqtUsuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtUsuario.label', default: 'SqtUsuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
