package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtLogServicelController {

    SqtLogServicelService sqtLogServicelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtLogServicelService.list(params), model:[sqtLogServicelCount: sqtLogServicelService.count()]
    }

    def show(Long id) {
        respond sqtLogServicelService.get(id)
    }

    def create() {
        respond new SqtLogServicel(params)
    }

    def save(SqtLogServicel sqtLogServicel) {
        if (sqtLogServicel == null) {
            notFound()
            return
        }

        try {
            sqtLogServicelService.save(sqtLogServicel)
        } catch (ValidationException e) {
            respond sqtLogServicel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtLogServicel.label', default: 'SqtLogServicel'), sqtLogServicel.id])
                redirect sqtLogServicel
            }
            '*' { respond sqtLogServicel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtLogServicelService.get(id)
    }

    def update(SqtLogServicel sqtLogServicel) {
        if (sqtLogServicel == null) {
            notFound()
            return
        }

        try {
            sqtLogServicelService.save(sqtLogServicel)
        } catch (ValidationException e) {
            respond sqtLogServicel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtLogServicel.label', default: 'SqtLogServicel'), sqtLogServicel.id])
                redirect sqtLogServicel
            }
            '*'{ respond sqtLogServicel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtLogServicelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtLogServicel.label', default: 'SqtLogServicel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtLogServicel.label', default: 'SqtLogServicel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
