package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtHistoricoPrecioController {

    SqtHistoricoPrecioService sqtHistoricoPrecioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtHistoricoPrecioService.list(params), model:[sqtHistoricoPrecioCount: sqtHistoricoPrecioService.count()]
    }

    def show(Long id) {
        respond sqtHistoricoPrecioService.get(id)
    }

    def create() {
        respond new SqtHistoricoPrecio(params)
    }

    def save(SqtHistoricoPrecio sqtHistoricoPrecio) {
        if (sqtHistoricoPrecio == null) {
            notFound()
            return
        }

        try {
            sqtHistoricoPrecioService.save(sqtHistoricoPrecio)
        } catch (ValidationException e) {
            respond sqtHistoricoPrecio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtHistoricoPrecio.label', default: 'SqtHistoricoPrecio'), sqtHistoricoPrecio.id])
                redirect sqtHistoricoPrecio
            }
            '*' { respond sqtHistoricoPrecio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtHistoricoPrecioService.get(id)
    }

    def update(SqtHistoricoPrecio sqtHistoricoPrecio) {
        if (sqtHistoricoPrecio == null) {
            notFound()
            return
        }

        try {
            sqtHistoricoPrecioService.save(sqtHistoricoPrecio)
        } catch (ValidationException e) {
            respond sqtHistoricoPrecio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtHistoricoPrecio.label', default: 'SqtHistoricoPrecio'), sqtHistoricoPrecio.id])
                redirect sqtHistoricoPrecio
            }
            '*'{ respond sqtHistoricoPrecio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtHistoricoPrecioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtHistoricoPrecio.label', default: 'SqtHistoricoPrecio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtHistoricoPrecio.label', default: 'SqtHistoricoPrecio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
