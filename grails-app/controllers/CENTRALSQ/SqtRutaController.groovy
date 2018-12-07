package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRutaController {

    SqtRutaService sqtRutaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRutaService.list(params), model:[sqtRutaCount: sqtRutaService.count()]
    }

    def show(Long id) {
        respond sqtRutaService.get(id)
    }

    def create() {
        respond new SqtRuta(params)
    }

    def save(SqtRuta sqtRuta) {
        if (sqtRuta == null) {
            notFound()
            return
        }

        try {
            sqtRutaService.save(sqtRuta)
        } catch (ValidationException e) {
            respond sqtRuta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRuta.label', default: 'SqtRuta'), sqtRuta.id])
                redirect sqtRuta
            }
            '*' { respond sqtRuta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRutaService.get(id)
    }

    def update(SqtRuta sqtRuta) {
        if (sqtRuta == null) {
            notFound()
            return
        }

        try {
            sqtRutaService.save(sqtRuta)
        } catch (ValidationException e) {
            respond sqtRuta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRuta.label', default: 'SqtRuta'), sqtRuta.id])
                redirect sqtRuta
            }
            '*'{ respond sqtRuta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRutaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRuta.label', default: 'SqtRuta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRuta.label', default: 'SqtRuta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
