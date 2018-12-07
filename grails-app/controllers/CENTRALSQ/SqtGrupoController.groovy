package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtGrupoController {

    SqtGrupoService sqtGrupoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtGrupoService.list(params), model:[sqtGrupoCount: sqtGrupoService.count()]
    }

    def show(Long id) {
        respond sqtGrupoService.get(id)
    }

    def create() {
        respond new SqtGrupo(params)
    }

    def save(SqtGrupo sqtGrupo) {
        if (sqtGrupo == null) {
            notFound()
            return
        }

        try {
            sqtGrupoService.save(sqtGrupo)
        } catch (ValidationException e) {
            respond sqtGrupo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtGrupo.label', default: 'SqtGrupo'), sqtGrupo.id])
                redirect sqtGrupo
            }
            '*' { respond sqtGrupo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtGrupoService.get(id)
    }

    def update(SqtGrupo sqtGrupo) {
        if (sqtGrupo == null) {
            notFound()
            return
        }

        try {
            sqtGrupoService.save(sqtGrupo)
        } catch (ValidationException e) {
            respond sqtGrupo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtGrupo.label', default: 'SqtGrupo'), sqtGrupo.id])
                redirect sqtGrupo
            }
            '*'{ respond sqtGrupo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtGrupoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtGrupo.label', default: 'SqtGrupo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtGrupo.label', default: 'SqtGrupo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
