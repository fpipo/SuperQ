package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAperturaTiendaController {

    SqtAperturaTiendaService sqtAperturaTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAperturaTiendaService.list(params), model:[sqtAperturaTiendaCount: sqtAperturaTiendaService.count()]
    }

    def show(Long id) {
        respond sqtAperturaTiendaService.get(id)
    }

    def create() {
        respond new SqtAperturaTienda(params)
    }

    def save(SqtAperturaTienda sqtAperturaTienda) {
        if (sqtAperturaTienda == null) {
            notFound()
            return
        }

        try {
            sqtAperturaTiendaService.save(sqtAperturaTienda)
        } catch (ValidationException e) {
            respond sqtAperturaTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAperturaTienda.label', default: 'SqtAperturaTienda'), sqtAperturaTienda.id])
                redirect sqtAperturaTienda
            }
            '*' { respond sqtAperturaTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAperturaTiendaService.get(id)
    }

    def update(SqtAperturaTienda sqtAperturaTienda) {
        if (sqtAperturaTienda == null) {
            notFound()
            return
        }

        try {
            sqtAperturaTiendaService.save(sqtAperturaTienda)
        } catch (ValidationException e) {
            respond sqtAperturaTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAperturaTienda.label', default: 'SqtAperturaTienda'), sqtAperturaTienda.id])
                redirect sqtAperturaTienda
            }
            '*'{ respond sqtAperturaTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAperturaTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAperturaTienda.label', default: 'SqtAperturaTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAperturaTienda.label', default: 'SqtAperturaTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
