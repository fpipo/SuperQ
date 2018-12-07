package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMoviemientoContableController {

    SqtMoviemientoContableService sqtMoviemientoContableService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMoviemientoContableService.list(params), model:[sqtMoviemientoContableCount: sqtMoviemientoContableService.count()]
    }

    def show(Long id) {
        respond sqtMoviemientoContableService.get(id)
    }

    def create() {
        respond new SqtMoviemientoContable(params)
    }

    def save(SqtMoviemientoContable sqtMoviemientoContable) {
        if (sqtMoviemientoContable == null) {
            notFound()
            return
        }

        try {
            sqtMoviemientoContableService.save(sqtMoviemientoContable)
        } catch (ValidationException e) {
            respond sqtMoviemientoContable.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMoviemientoContable.label', default: 'SqtMoviemientoContable'), sqtMoviemientoContable.id])
                redirect sqtMoviemientoContable
            }
            '*' { respond sqtMoviemientoContable, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMoviemientoContableService.get(id)
    }

    def update(SqtMoviemientoContable sqtMoviemientoContable) {
        if (sqtMoviemientoContable == null) {
            notFound()
            return
        }

        try {
            sqtMoviemientoContableService.save(sqtMoviemientoContable)
        } catch (ValidationException e) {
            respond sqtMoviemientoContable.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMoviemientoContable.label', default: 'SqtMoviemientoContable'), sqtMoviemientoContable.id])
                redirect sqtMoviemientoContable
            }
            '*'{ respond sqtMoviemientoContable, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMoviemientoContableService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMoviemientoContable.label', default: 'SqtMoviemientoContable'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMoviemientoContable.label', default: 'SqtMoviemientoContable'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
