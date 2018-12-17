package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtUsuarioGrupoUsuarioController {

    SqtUsuarioGrupoUsuarioService sqtUsuarioGrupoUsuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtUsuarioGrupoUsuarioService.list(params), model:[sqtUsuarioGrupoUsuarioCount: sqtUsuarioGrupoUsuarioService.count()]
    }

    def show(Long id) {
        respond sqtUsuarioGrupoUsuarioService.get(id)
    }

    def create() {
        respond new SqtUsuarioGrupoUsuario(params)
    }

    def save(SqtUsuarioGrupoUsuario sqtUsuarioGrupoUsuario) {
        if (sqtUsuarioGrupoUsuario == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioGrupoUsuarioService.save(sqtUsuarioGrupoUsuario)
        } catch (ValidationException e) {
            respond sqtUsuarioGrupoUsuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtUsuarioGrupoUsuario.label', default: 'SqtUsuarioGrupoUsuario'), sqtUsuarioGrupoUsuario.id])
                redirect sqtUsuarioGrupoUsuario
            }
            '*' { respond sqtUsuarioGrupoUsuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtUsuarioGrupoUsuarioService.get(id)
    }

    def update(SqtUsuarioGrupoUsuario sqtUsuarioGrupoUsuario) {
        if (sqtUsuarioGrupoUsuario == null) {
            notFound()
            return
        }

        try {
            sqtUsuarioGrupoUsuarioService.save(sqtUsuarioGrupoUsuario)
        } catch (ValidationException e) {
            respond sqtUsuarioGrupoUsuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtUsuarioGrupoUsuario.label', default: 'SqtUsuarioGrupoUsuario'), sqtUsuarioGrupoUsuario.id])
                redirect sqtUsuarioGrupoUsuario
            }
            '*'{ respond sqtUsuarioGrupoUsuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtUsuarioGrupoUsuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtUsuarioGrupoUsuario.label', default: 'SqtUsuarioGrupoUsuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtUsuarioGrupoUsuario.label', default: 'SqtUsuarioGrupoUsuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
