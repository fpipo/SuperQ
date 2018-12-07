package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtComisionUsuarioController {

    SqtComisionUsuarioService sqtComisionUsuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtComisionUsuarioService.list(params), model:[sqtComisionUsuarioCount: sqtComisionUsuarioService.count()]
    }

    def show(Long id) {
        respond sqtComisionUsuarioService.get(id)
    }

    def create() {
        respond new SqtComisionUsuario(params)
    }

    def save(SqtComisionUsuario sqtComisionUsuario) {
        if (sqtComisionUsuario == null) {
            notFound()
            return
        }

        try {
            sqtComisionUsuarioService.save(sqtComisionUsuario)
        } catch (ValidationException e) {
            respond sqtComisionUsuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtComisionUsuario.label', default: 'SqtComisionUsuario'), sqtComisionUsuario.id])
                redirect sqtComisionUsuario
            }
            '*' { respond sqtComisionUsuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtComisionUsuarioService.get(id)
    }

    def update(SqtComisionUsuario sqtComisionUsuario) {
        if (sqtComisionUsuario == null) {
            notFound()
            return
        }

        try {
            sqtComisionUsuarioService.save(sqtComisionUsuario)
        } catch (ValidationException e) {
            respond sqtComisionUsuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtComisionUsuario.label', default: 'SqtComisionUsuario'), sqtComisionUsuario.id])
                redirect sqtComisionUsuario
            }
            '*'{ respond sqtComisionUsuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtComisionUsuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtComisionUsuario.label', default: 'SqtComisionUsuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtComisionUsuario.label', default: 'SqtComisionUsuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
