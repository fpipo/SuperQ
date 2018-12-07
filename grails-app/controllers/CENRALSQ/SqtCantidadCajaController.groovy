package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCantidadCajaController {

    SqtCantidadCajaService sqtCantidadCajaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCantidadCajaService.list(params), model:[sqtCantidadCajaCount: sqtCantidadCajaService.count()]
    }

    def show(Long id) {
        respond sqtCantidadCajaService.get(id)
    }

    def create() {
        respond new SqtCantidadCaja(params)
    }

    def save(SqtCantidadCaja sqtCantidadCaja) {
        if (sqtCantidadCaja == null) {
            notFound()
            return
        }

        try {
            sqtCantidadCajaService.save(sqtCantidadCaja)
        } catch (ValidationException e) {
            respond sqtCantidadCaja.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCantidadCaja.label', default: 'SqtCantidadCaja'), sqtCantidadCaja.id])
                redirect sqtCantidadCaja
            }
            '*' { respond sqtCantidadCaja, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCantidadCajaService.get(id)
    }

    def update(SqtCantidadCaja sqtCantidadCaja) {
        if (sqtCantidadCaja == null) {
            notFound()
            return
        }

        try {
            sqtCantidadCajaService.save(sqtCantidadCaja)
        } catch (ValidationException e) {
            respond sqtCantidadCaja.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCantidadCaja.label', default: 'SqtCantidadCaja'), sqtCantidadCaja.id])
                redirect sqtCantidadCaja
            }
            '*'{ respond sqtCantidadCaja, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCantidadCajaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCantidadCaja.label', default: 'SqtCantidadCaja'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCantidadCaja.label', default: 'SqtCantidadCaja'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
