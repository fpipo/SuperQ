package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtFolioeController {

    SqtFolioeService sqtFolioeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtFolioeService.list(params), model:[sqtFolioeCount: sqtFolioeService.count()]
    }

    def show(Long id) {
        respond sqtFolioeService.get(id)
    }

    def create() {
        respond new SqtFolioe(params)
    }

    def save(SqtFolioe sqtFolioe) {
        if (sqtFolioe == null) {
            notFound()
            return
        }

        try {
            sqtFolioeService.save(sqtFolioe)
        } catch (ValidationException e) {
            respond sqtFolioe.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtFolioe.label', default: 'SqtFolioe'), sqtFolioe.id])
                redirect sqtFolioe
            }
            '*' { respond sqtFolioe, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtFolioeService.get(id)
    }

    def update(SqtFolioe sqtFolioe) {
        if (sqtFolioe == null) {
            notFound()
            return
        }

        try {
            sqtFolioeService.save(sqtFolioe)
        } catch (ValidationException e) {
            respond sqtFolioe.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtFolioe.label', default: 'SqtFolioe'), sqtFolioe.id])
                redirect sqtFolioe
            }
            '*'{ respond sqtFolioe, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtFolioeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtFolioe.label', default: 'SqtFolioe'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtFolioe.label', default: 'SqtFolioe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
