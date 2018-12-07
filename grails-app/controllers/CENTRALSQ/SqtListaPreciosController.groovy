package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtListaPreciosController {

    SqtListaPreciosService sqtListaPreciosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtListaPreciosService.list(params), model:[sqtListaPreciosCount: sqtListaPreciosService.count()]
    }

    def show(Long id) {
        respond sqtListaPreciosService.get(id)
    }

    def create() {
        respond new SqtListaPrecios(params)
    }

    def save(SqtListaPrecios sqtListaPrecios) {
        if (sqtListaPrecios == null) {
            notFound()
            return
        }

        try {
            sqtListaPreciosService.save(sqtListaPrecios)
        } catch (ValidationException e) {
            respond sqtListaPrecios.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtListaPrecios.label', default: 'SqtListaPrecios'), sqtListaPrecios.id])
                redirect sqtListaPrecios
            }
            '*' { respond sqtListaPrecios, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtListaPreciosService.get(id)
    }

    def update(SqtListaPrecios sqtListaPrecios) {
        if (sqtListaPrecios == null) {
            notFound()
            return
        }

        try {
            sqtListaPreciosService.save(sqtListaPrecios)
        } catch (ValidationException e) {
            respond sqtListaPrecios.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtListaPrecios.label', default: 'SqtListaPrecios'), sqtListaPrecios.id])
                redirect sqtListaPrecios
            }
            '*'{ respond sqtListaPrecios, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtListaPreciosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtListaPrecios.label', default: 'SqtListaPrecios'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtListaPrecios.label', default: 'SqtListaPrecios'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
