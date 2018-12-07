package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRolesController {

    SqtRolesService sqtRolesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRolesService.list(params), model:[sqtRolesCount: sqtRolesService.count()]
    }

    def show(Long id) {
        respond sqtRolesService.get(id)
    }

    def create() {
        respond new SqtRoles(params)
    }

    def save(SqtRoles sqtRoles) {
        if (sqtRoles == null) {
            notFound()
            return
        }

        try {
            sqtRolesService.save(sqtRoles)
        } catch (ValidationException e) {
            respond sqtRoles.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRoles.label', default: 'SqtRoles'), sqtRoles.id])
                redirect sqtRoles
            }
            '*' { respond sqtRoles, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRolesService.get(id)
    }

    def update(SqtRoles sqtRoles) {
        if (sqtRoles == null) {
            notFound()
            return
        }

        try {
            sqtRolesService.save(sqtRoles)
        } catch (ValidationException e) {
            respond sqtRoles.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRoles.label', default: 'SqtRoles'), sqtRoles.id])
                redirect sqtRoles
            }
            '*'{ respond sqtRoles, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRolesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRoles.label', default: 'SqtRoles'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRoles.label', default: 'SqtRoles'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
