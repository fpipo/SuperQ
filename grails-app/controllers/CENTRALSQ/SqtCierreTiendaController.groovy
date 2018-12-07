package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCierreTiendaController {

    SqtCierreTiendaService sqtCierreTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCierreTiendaService.list(params), model:[sqtCierreTiendaCount: sqtCierreTiendaService.count()]
    }

    def show(Long id) {
        respond sqtCierreTiendaService.get(id)
    }

    def create() {
        respond new SqtCierreTienda(params)
    }

    def save(SqtCierreTienda sqtCierreTienda) {
        if (sqtCierreTienda == null) {
            notFound()
            return
        }

        try {
            sqtCierreTiendaService.save(sqtCierreTienda)
        } catch (ValidationException e) {
            respond sqtCierreTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCierreTienda.label', default: 'SqtCierreTienda'), sqtCierreTienda.id])
                redirect sqtCierreTienda
            }
            '*' { respond sqtCierreTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCierreTiendaService.get(id)
    }

    def update(SqtCierreTienda sqtCierreTienda) {
        if (sqtCierreTienda == null) {
            notFound()
            return
        }

        try {
            sqtCierreTiendaService.save(sqtCierreTienda)
        } catch (ValidationException e) {
            respond sqtCierreTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCierreTienda.label', default: 'SqtCierreTienda'), sqtCierreTienda.id])
                redirect sqtCierreTienda
            }
            '*'{ respond sqtCierreTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCierreTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCierreTienda.label', default: 'SqtCierreTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCierreTienda.label', default: 'SqtCierreTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
