package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtNuevoGrupoController {

    SqtNuevoGrupoService sqtNuevoGrupoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtNuevoGrupoService.list(params), model:[sqtNuevoGrupoCount: sqtNuevoGrupoService.count()]
    }

    def show(Long id) {
        respond sqtNuevoGrupoService.get(id)
    }

    def create() {
        respond new SqtNuevoGrupo(params)
    }

    def save(SqtNuevoGrupo sqtNuevoGrupo) {
        if (sqtNuevoGrupo == null) {
            notFound()
            return
        }

        try {
            sqtNuevoGrupoService.save(sqtNuevoGrupo)
        } catch (ValidationException e) {
            respond sqtNuevoGrupo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtNuevoGrupo.label', default: 'SqtNuevoGrupo'), sqtNuevoGrupo.id])
                redirect sqtNuevoGrupo
            }
            '*' { respond sqtNuevoGrupo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtNuevoGrupoService.get(id)
    }

    def update(SqtNuevoGrupo sqtNuevoGrupo) {
        if (sqtNuevoGrupo == null) {
            notFound()
            return
        }

        try {
            sqtNuevoGrupoService.save(sqtNuevoGrupo)
        } catch (ValidationException e) {
            respond sqtNuevoGrupo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtNuevoGrupo.label', default: 'SqtNuevoGrupo'), sqtNuevoGrupo.id])
                redirect sqtNuevoGrupo
            }
            '*'{ respond sqtNuevoGrupo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtNuevoGrupoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtNuevoGrupo.label', default: 'SqtNuevoGrupo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtNuevoGrupo.label', default: 'SqtNuevoGrupo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
