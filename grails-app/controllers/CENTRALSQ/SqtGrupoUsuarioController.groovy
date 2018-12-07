package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtGrupoUsuarioController {

    SqtGrupoUsuarioService sqtGrupoUsuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtGrupoUsuarioService.list(params), model:[sqtGrupoUsuarioCount: sqtGrupoUsuarioService.count()]
    }

    def show(Long id) {
        respond sqtGrupoUsuarioService.get(id)
    }

    def create() {
        respond new SqtGrupoUsuario(params)
    }

    def save(SqtGrupoUsuario sqtGrupoUsuario) {
        if (sqtGrupoUsuario == null) {
            notFound()
            return
        }

        try {
            sqtGrupoUsuarioService.save(sqtGrupoUsuario)
        } catch (ValidationException e) {
            respond sqtGrupoUsuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtGrupoUsuario.label', default: 'SqtGrupoUsuario'), sqtGrupoUsuario.id])
                redirect sqtGrupoUsuario
            }
            '*' { respond sqtGrupoUsuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtGrupoUsuarioService.get(id)
    }

    def update(SqtGrupoUsuario sqtGrupoUsuario) {
        if (sqtGrupoUsuario == null) {
            notFound()
            return
        }

        try {
            sqtGrupoUsuarioService.save(sqtGrupoUsuario)
        } catch (ValidationException e) {
            respond sqtGrupoUsuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtGrupoUsuario.label', default: 'SqtGrupoUsuario'), sqtGrupoUsuario.id])
                redirect sqtGrupoUsuario
            }
            '*'{ respond sqtGrupoUsuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtGrupoUsuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtGrupoUsuario.label', default: 'SqtGrupoUsuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtGrupoUsuario.label', default: 'SqtGrupoUsuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
