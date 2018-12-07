package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtSubgrupoController {

    SqtSubgrupoService sqtSubgrupoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtSubgrupoService.list(params), model:[sqtSubgrupoCount: sqtSubgrupoService.count()]
    }

    def show(Long id) {
        respond sqtSubgrupoService.get(id)
    }

    def create() {
        respond new SqtSubgrupo(params)
    }

    def save(SqtSubgrupo sqtSubgrupo) {
        if (sqtSubgrupo == null) {
            notFound()
            return
        }

        try {
            sqtSubgrupoService.save(sqtSubgrupo)
        } catch (ValidationException e) {
            respond sqtSubgrupo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtSubgrupo.label', default: 'SqtSubgrupo'), sqtSubgrupo.id])
                redirect sqtSubgrupo
            }
            '*' { respond sqtSubgrupo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtSubgrupoService.get(id)
    }

    def update(SqtSubgrupo sqtSubgrupo) {
        if (sqtSubgrupo == null) {
            notFound()
            return
        }

        try {
            sqtSubgrupoService.save(sqtSubgrupo)
        } catch (ValidationException e) {
            respond sqtSubgrupo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtSubgrupo.label', default: 'SqtSubgrupo'), sqtSubgrupo.id])
                redirect sqtSubgrupo
            }
            '*'{ respond sqtSubgrupo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtSubgrupoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtSubgrupo.label', default: 'SqtSubgrupo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtSubgrupo.label', default: 'SqtSubgrupo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
