package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPreciosOfertaController {

    SqtPreciosOfertaService sqtPreciosOfertaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPreciosOfertaService.list(params), model:[sqtPreciosOfertaCount: sqtPreciosOfertaService.count()]
    }

    def show(Long id) {
        respond sqtPreciosOfertaService.get(id)
    }

    def create() {
        respond new SqtPreciosOferta(params)
    }

    def save(SqtPreciosOferta sqtPreciosOferta) {
        if (sqtPreciosOferta == null) {
            notFound()
            return
        }

        try {
            sqtPreciosOfertaService.save(sqtPreciosOferta)
        } catch (ValidationException e) {
            respond sqtPreciosOferta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPreciosOferta.label', default: 'SqtPreciosOferta'), sqtPreciosOferta.id])
                redirect sqtPreciosOferta
            }
            '*' { respond sqtPreciosOferta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPreciosOfertaService.get(id)
    }

    def update(SqtPreciosOferta sqtPreciosOferta) {
        if (sqtPreciosOferta == null) {
            notFound()
            return
        }

        try {
            sqtPreciosOfertaService.save(sqtPreciosOferta)
        } catch (ValidationException e) {
            respond sqtPreciosOferta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPreciosOferta.label', default: 'SqtPreciosOferta'), sqtPreciosOferta.id])
                redirect sqtPreciosOferta
            }
            '*'{ respond sqtPreciosOferta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPreciosOfertaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPreciosOferta.label', default: 'SqtPreciosOferta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPreciosOferta.label', default: 'SqtPreciosOferta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
