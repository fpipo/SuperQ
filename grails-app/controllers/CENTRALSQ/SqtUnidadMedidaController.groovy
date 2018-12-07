package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtUnidadMedidaController {

    SqtUnidadMedidaService sqtUnidadMedidaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtUnidadMedidaService.list(params), model:[sqtUnidadMedidaCount: sqtUnidadMedidaService.count()]
    }

    def show(Long id) {
        respond sqtUnidadMedidaService.get(id)
    }

    def create() {
        respond new SqtUnidadMedida(params)
    }

    def save(SqtUnidadMedida sqtUnidadMedida) {
        if (sqtUnidadMedida == null) {
            notFound()
            return
        }

        try {
            sqtUnidadMedidaService.save(sqtUnidadMedida)
        } catch (ValidationException e) {
            respond sqtUnidadMedida.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtUnidadMedida.label', default: 'SqtUnidadMedida'), sqtUnidadMedida.id])
                redirect sqtUnidadMedida
            }
            '*' { respond sqtUnidadMedida, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtUnidadMedidaService.get(id)
    }

    def update(SqtUnidadMedida sqtUnidadMedida) {
        if (sqtUnidadMedida == null) {
            notFound()
            return
        }

        try {
            sqtUnidadMedidaService.save(sqtUnidadMedida)
        } catch (ValidationException e) {
            respond sqtUnidadMedida.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtUnidadMedida.label', default: 'SqtUnidadMedida'), sqtUnidadMedida.id])
                redirect sqtUnidadMedida
            }
            '*'{ respond sqtUnidadMedida, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtUnidadMedidaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtUnidadMedida.label', default: 'SqtUnidadMedida'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtUnidadMedida.label', default: 'SqtUnidadMedida'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
