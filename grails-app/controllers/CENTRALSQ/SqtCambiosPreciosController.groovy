package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCambiosPreciosController {

    SqtCambiosPreciosService sqtCambiosPreciosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCambiosPreciosService.list(params), model:[sqtCambiosPreciosCount: sqtCambiosPreciosService.count()]
    }

    def show(Long id) {
        respond sqtCambiosPreciosService.get(id)
    }

    def create() {
        respond new SqtCambiosPrecios(params)
    }

    def save(SqtCambiosPrecios sqtCambiosPrecios) {
        if (sqtCambiosPrecios == null) {
            notFound()
            return
        }

        try {
            sqtCambiosPreciosService.save(sqtCambiosPrecios)
        } catch (ValidationException e) {
            respond sqtCambiosPrecios.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCambiosPrecios.label', default: 'SqtCambiosPrecios'), sqtCambiosPrecios.id])
                redirect sqtCambiosPrecios
            }
            '*' { respond sqtCambiosPrecios, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCambiosPreciosService.get(id)
    }

    def update(SqtCambiosPrecios sqtCambiosPrecios) {
        if (sqtCambiosPrecios == null) {
            notFound()
            return
        }

        try {
            sqtCambiosPreciosService.save(sqtCambiosPrecios)
        } catch (ValidationException e) {
            respond sqtCambiosPrecios.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCambiosPrecios.label', default: 'SqtCambiosPrecios'), sqtCambiosPrecios.id])
                redirect sqtCambiosPrecios
            }
            '*'{ respond sqtCambiosPrecios, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCambiosPreciosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCambiosPrecios.label', default: 'SqtCambiosPrecios'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCambiosPrecios.label', default: 'SqtCambiosPrecios'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
