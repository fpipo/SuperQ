package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtImpuestoListaPreciosController {

    SqtImpuestoListaPreciosService sqtImpuestoListaPreciosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtImpuestoListaPreciosService.list(params), model:[sqtImpuestoListaPreciosCount: sqtImpuestoListaPreciosService.count()]
    }

    def show(Long id) {
        respond sqtImpuestoListaPreciosService.get(id)
    }

    def create() {
        respond new SqtImpuestoListaPrecios(params)
    }

    def save(SqtImpuestoListaPrecios sqtImpuestoListaPrecios) {
        if (sqtImpuestoListaPrecios == null) {
            notFound()
            return
        }

        try {
            sqtImpuestoListaPreciosService.save(sqtImpuestoListaPrecios)
        } catch (ValidationException e) {
            respond sqtImpuestoListaPrecios.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtImpuestoListaPrecios.label', default: 'SqtImpuestoListaPrecios'), sqtImpuestoListaPrecios.id])
                redirect sqtImpuestoListaPrecios
            }
            '*' { respond sqtImpuestoListaPrecios, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtImpuestoListaPreciosService.get(id)
    }

    def update(SqtImpuestoListaPrecios sqtImpuestoListaPrecios) {
        if (sqtImpuestoListaPrecios == null) {
            notFound()
            return
        }

        try {
            sqtImpuestoListaPreciosService.save(sqtImpuestoListaPrecios)
        } catch (ValidationException e) {
            respond sqtImpuestoListaPrecios.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtImpuestoListaPrecios.label', default: 'SqtImpuestoListaPrecios'), sqtImpuestoListaPrecios.id])
                redirect sqtImpuestoListaPrecios
            }
            '*'{ respond sqtImpuestoListaPrecios, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtImpuestoListaPreciosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtImpuestoListaPrecios.label', default: 'SqtImpuestoListaPrecios'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtImpuestoListaPrecios.label', default: 'SqtImpuestoListaPrecios'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
