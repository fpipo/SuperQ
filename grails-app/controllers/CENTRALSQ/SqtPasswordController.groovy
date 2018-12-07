package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPasswordController {

    SqtPasswordService sqtPasswordService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPasswordService.list(params), model:[sqtPasswordCount: sqtPasswordService.count()]
    }

    def show(Long id) {
        respond sqtPasswordService.get(id)
    }

    def create() {
        respond new SqtPassword(params)
    }

    def save(SqtPassword sqtPassword) {
        if (sqtPassword == null) {
            notFound()
            return
        }

        try {
            sqtPasswordService.save(sqtPassword)
        } catch (ValidationException e) {
            respond sqtPassword.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPassword.label', default: 'SqtPassword'), sqtPassword.id])
                redirect sqtPassword
            }
            '*' { respond sqtPassword, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPasswordService.get(id)
    }

    def update(SqtPassword sqtPassword) {
        if (sqtPassword == null) {
            notFound()
            return
        }

        try {
            sqtPasswordService.save(sqtPassword)
        } catch (ValidationException e) {
            respond sqtPassword.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPassword.label', default: 'SqtPassword'), sqtPassword.id])
                redirect sqtPassword
            }
            '*'{ respond sqtPassword, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPasswordService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPassword.label', default: 'SqtPassword'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPassword.label', default: 'SqtPassword'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
