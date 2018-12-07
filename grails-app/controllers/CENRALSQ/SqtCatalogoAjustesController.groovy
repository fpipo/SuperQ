package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCatalogoAjustesController {

    SqtCatalogoAjustesService sqtCatalogoAjustesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCatalogoAjustesService.list(params), model:[sqtCatalogoAjustesCount: sqtCatalogoAjustesService.count()]
    }

    def show(Long id) {
        respond sqtCatalogoAjustesService.get(id)
    }

    def create() {
        respond new SqtCatalogoAjustes(params)
    }

    def save(SqtCatalogoAjustes sqtCatalogoAjustes) {
        if (sqtCatalogoAjustes == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoAjustesService.save(sqtCatalogoAjustes)
        } catch (ValidationException e) {
            respond sqtCatalogoAjustes.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCatalogoAjustes.label', default: 'SqtCatalogoAjustes'), sqtCatalogoAjustes.id])
                redirect sqtCatalogoAjustes
            }
            '*' { respond sqtCatalogoAjustes, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCatalogoAjustesService.get(id)
    }

    def update(SqtCatalogoAjustes sqtCatalogoAjustes) {
        if (sqtCatalogoAjustes == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoAjustesService.save(sqtCatalogoAjustes)
        } catch (ValidationException e) {
            respond sqtCatalogoAjustes.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCatalogoAjustes.label', default: 'SqtCatalogoAjustes'), sqtCatalogoAjustes.id])
                redirect sqtCatalogoAjustes
            }
            '*'{ respond sqtCatalogoAjustes, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCatalogoAjustesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCatalogoAjustes.label', default: 'SqtCatalogoAjustes'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCatalogoAjustes.label', default: 'SqtCatalogoAjustes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
