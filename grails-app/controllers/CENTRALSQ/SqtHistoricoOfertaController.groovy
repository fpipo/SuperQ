package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtHistoricoOfertaController {

    SqtHistoricoOfertaService sqtHistoricoOfertaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtHistoricoOfertaService.list(params), model:[sqtHistoricoOfertaCount: sqtHistoricoOfertaService.count()]
    }

    def show(Long id) {
        respond sqtHistoricoOfertaService.get(id)
    }

    def create() {
        respond new SqtHistoricoOferta(params)
    }

    def save(SqtHistoricoOferta sqtHistoricoOferta) {
        if (sqtHistoricoOferta == null) {
            notFound()
            return
        }

        try {
            sqtHistoricoOfertaService.save(sqtHistoricoOferta)
        } catch (ValidationException e) {
            respond sqtHistoricoOferta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtHistoricoOferta.label', default: 'SqtHistoricoOferta'), sqtHistoricoOferta.id])
                redirect sqtHistoricoOferta
            }
            '*' { respond sqtHistoricoOferta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtHistoricoOfertaService.get(id)
    }

    def update(SqtHistoricoOferta sqtHistoricoOferta) {
        if (sqtHistoricoOferta == null) {
            notFound()
            return
        }

        try {
            sqtHistoricoOfertaService.save(sqtHistoricoOferta)
        } catch (ValidationException e) {
            respond sqtHistoricoOferta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtHistoricoOferta.label', default: 'SqtHistoricoOferta'), sqtHistoricoOferta.id])
                redirect sqtHistoricoOferta
            }
            '*'{ respond sqtHistoricoOferta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtHistoricoOfertaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtHistoricoOferta.label', default: 'SqtHistoricoOferta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtHistoricoOferta.label', default: 'SqtHistoricoOferta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
