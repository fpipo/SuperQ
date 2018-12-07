package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtVoucherDeclinadoController {

    SqtVoucherDeclinadoService sqtVoucherDeclinadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtVoucherDeclinadoService.list(params), model:[sqtVoucherDeclinadoCount: sqtVoucherDeclinadoService.count()]
    }

    def show(Long id) {
        respond sqtVoucherDeclinadoService.get(id)
    }

    def create() {
        respond new SqtVoucherDeclinado(params)
    }

    def save(SqtVoucherDeclinado sqtVoucherDeclinado) {
        if (sqtVoucherDeclinado == null) {
            notFound()
            return
        }

        try {
            sqtVoucherDeclinadoService.save(sqtVoucherDeclinado)
        } catch (ValidationException e) {
            respond sqtVoucherDeclinado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtVoucherDeclinado.label', default: 'SqtVoucherDeclinado'), sqtVoucherDeclinado.id])
                redirect sqtVoucherDeclinado
            }
            '*' { respond sqtVoucherDeclinado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtVoucherDeclinadoService.get(id)
    }

    def update(SqtVoucherDeclinado sqtVoucherDeclinado) {
        if (sqtVoucherDeclinado == null) {
            notFound()
            return
        }

        try {
            sqtVoucherDeclinadoService.save(sqtVoucherDeclinado)
        } catch (ValidationException e) {
            respond sqtVoucherDeclinado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtVoucherDeclinado.label', default: 'SqtVoucherDeclinado'), sqtVoucherDeclinado.id])
                redirect sqtVoucherDeclinado
            }
            '*'{ respond sqtVoucherDeclinado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtVoucherDeclinadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtVoucherDeclinado.label', default: 'SqtVoucherDeclinado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtVoucherDeclinado.label', default: 'SqtVoucherDeclinado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
