package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCajaController {

    SqtCajaService sqtCajaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCajaService.list(params), model:[sqtCajaCount: sqtCajaService.count()]
    }

    def show(Long id) {
        respond sqtCajaService.get(id)
    }

    def create() {
        respond new SqtCaja(params)
    }

    def save(SqtCaja sqtCaja) {
        if (sqtCaja == null) {
            notFound()
            return
        }

        try {
            sqtCajaService.save(sqtCaja)
        } catch (ValidationException e) {
            respond sqtCaja.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCaja.label', default: 'SqtCaja'), sqtCaja.id])
                redirect sqtCaja
            }
            '*' { respond sqtCaja, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCajaService.get(id)
    }

    def update(SqtCaja sqtCaja) {
        if (sqtCaja == null) {
            notFound()
            return
        }

        try {
            sqtCajaService.save(sqtCaja)
        } catch (ValidationException e) {
            respond sqtCaja.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCaja.label', default: 'SqtCaja'), sqtCaja.id])
                redirect sqtCaja
            }
            '*'{ respond sqtCaja, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCajaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCaja.label', default: 'SqtCaja'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCaja.label', default: 'SqtCaja'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
