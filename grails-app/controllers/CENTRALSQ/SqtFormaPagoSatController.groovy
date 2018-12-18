package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtFormaPagoSatController {

    SqtFormaPagoSatService sqtFormaPagoSatService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtFormaPagoSatService.list(params), model:[sqtFormaPagoSatCount: sqtFormaPagoSatService.count()]
    }

    def show(Long id) {
        respond sqtFormaPagoSatService.get(id)
    }

    def create() {
        respond new SqtFormaPagoSat(params)
    }

    def save(SqtFormaPagoSat sqtFormaPagoSat) {
        if (sqtFormaPagoSat == null) {
            notFound()
            return
        }

        try {
            sqtFormaPagoSatService.save(sqtFormaPagoSat)
        } catch (ValidationException e) {
            respond sqtFormaPagoSat.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtFormaPagoSat.label', default: 'SqtFormaPagoSat'), sqtFormaPagoSat.id])
                redirect sqtFormaPagoSat
            }
            '*' { respond sqtFormaPagoSat, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtFormaPagoSatService.get(id)
    }

    def update(SqtFormaPagoSat sqtFormaPagoSat) {
        if (sqtFormaPagoSat == null) {
            notFound()
            return
        }

        try {
            sqtFormaPagoSatService.save(sqtFormaPagoSat)
        } catch (ValidationException e) {
            respond sqtFormaPagoSat.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtFormaPagoSat.label', default: 'SqtFormaPagoSat'), sqtFormaPagoSat.id])
                redirect sqtFormaPagoSat
            }
            '*'{ respond sqtFormaPagoSat, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtFormaPagoSatService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtFormaPagoSat.label', default: 'SqtFormaPagoSat'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtFormaPagoSat.label', default: 'SqtFormaPagoSat'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
