package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMotivoAjusteController {

    SqtMotivoAjusteService sqtMotivoAjusteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMotivoAjusteService.list(params), model:[sqtMotivoAjusteCount: sqtMotivoAjusteService.count()]
    }

    def show(Long id) {
        respond sqtMotivoAjusteService.get(id)
    }

    def create() {
        respond new SqtMotivoAjuste(params)
    }

    def save(SqtMotivoAjuste sqtMotivoAjuste) {
        if (sqtMotivoAjuste == null) {
            notFound()
            return
        }

        try {
            sqtMotivoAjusteService.save(sqtMotivoAjuste)
        } catch (ValidationException e) {
            respond sqtMotivoAjuste.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMotivoAjuste.label', default: 'SqtMotivoAjuste'), sqtMotivoAjuste.id])
                redirect sqtMotivoAjuste
            }
            '*' { respond sqtMotivoAjuste, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMotivoAjusteService.get(id)
    }

    def update(SqtMotivoAjuste sqtMotivoAjuste) {
        if (sqtMotivoAjuste == null) {
            notFound()
            return
        }

        try {
            sqtMotivoAjusteService.save(sqtMotivoAjuste)
        } catch (ValidationException e) {
            respond sqtMotivoAjuste.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMotivoAjuste.label', default: 'SqtMotivoAjuste'), sqtMotivoAjuste.id])
                redirect sqtMotivoAjuste
            }
            '*'{ respond sqtMotivoAjuste, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMotivoAjusteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMotivoAjuste.label', default: 'SqtMotivoAjuste'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMotivoAjuste.label', default: 'SqtMotivoAjuste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
