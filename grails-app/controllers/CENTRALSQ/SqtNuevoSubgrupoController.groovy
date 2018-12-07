package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtNuevoSubgrupoController {

    SqtNuevoSubgrupoService sqtNuevoSubgrupoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtNuevoSubgrupoService.list(params), model:[sqtNuevoSubgrupoCount: sqtNuevoSubgrupoService.count()]
    }

    def show(Long id) {
        respond sqtNuevoSubgrupoService.get(id)
    }

    def create() {
        respond new SqtNuevoSubgrupo(params)
    }

    def save(SqtNuevoSubgrupo sqtNuevoSubgrupo) {
        if (sqtNuevoSubgrupo == null) {
            notFound()
            return
        }

        try {
            sqtNuevoSubgrupoService.save(sqtNuevoSubgrupo)
        } catch (ValidationException e) {
            respond sqtNuevoSubgrupo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtNuevoSubgrupo.label', default: 'SqtNuevoSubgrupo'), sqtNuevoSubgrupo.id])
                redirect sqtNuevoSubgrupo
            }
            '*' { respond sqtNuevoSubgrupo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtNuevoSubgrupoService.get(id)
    }

    def update(SqtNuevoSubgrupo sqtNuevoSubgrupo) {
        if (sqtNuevoSubgrupo == null) {
            notFound()
            return
        }

        try {
            sqtNuevoSubgrupoService.save(sqtNuevoSubgrupo)
        } catch (ValidationException e) {
            respond sqtNuevoSubgrupo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtNuevoSubgrupo.label', default: 'SqtNuevoSubgrupo'), sqtNuevoSubgrupo.id])
                redirect sqtNuevoSubgrupo
            }
            '*'{ respond sqtNuevoSubgrupo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtNuevoSubgrupoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtNuevoSubgrupo.label', default: 'SqtNuevoSubgrupo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtNuevoSubgrupo.label', default: 'SqtNuevoSubgrupo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
