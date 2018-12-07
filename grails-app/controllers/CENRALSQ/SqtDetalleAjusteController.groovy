package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleAjusteController {

    SqtDetalleAjusteService sqtDetalleAjusteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleAjusteService.list(params), model:[sqtDetalleAjusteCount: sqtDetalleAjusteService.count()]
    }

    def show(Long id) {
        respond sqtDetalleAjusteService.get(id)
    }

    def create() {
        respond new SqtDetalleAjuste(params)
    }

    def save(SqtDetalleAjuste sqtDetalleAjuste) {
        if (sqtDetalleAjuste == null) {
            notFound()
            return
        }

        try {
            sqtDetalleAjusteService.save(sqtDetalleAjuste)
        } catch (ValidationException e) {
            respond sqtDetalleAjuste.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleAjuste.label', default: 'SqtDetalleAjuste'), sqtDetalleAjuste.id])
                redirect sqtDetalleAjuste
            }
            '*' { respond sqtDetalleAjuste, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleAjusteService.get(id)
    }

    def update(SqtDetalleAjuste sqtDetalleAjuste) {
        if (sqtDetalleAjuste == null) {
            notFound()
            return
        }

        try {
            sqtDetalleAjusteService.save(sqtDetalleAjuste)
        } catch (ValidationException e) {
            respond sqtDetalleAjuste.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleAjuste.label', default: 'SqtDetalleAjuste'), sqtDetalleAjuste.id])
                redirect sqtDetalleAjuste
            }
            '*'{ respond sqtDetalleAjuste, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleAjusteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleAjuste.label', default: 'SqtDetalleAjuste'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleAjuste.label', default: 'SqtDetalleAjuste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
