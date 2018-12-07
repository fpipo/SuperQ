package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtBolsaPreventaController {

    SqtBolsaPreventaService sqtBolsaPreventaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtBolsaPreventaService.list(params), model:[sqtBolsaPreventaCount: sqtBolsaPreventaService.count()]
    }

    def show(Long id) {
        respond sqtBolsaPreventaService.get(id)
    }

    def create() {
        respond new SqtBolsaPreventa(params)
    }

    def save(SqtBolsaPreventa sqtBolsaPreventa) {
        if (sqtBolsaPreventa == null) {
            notFound()
            return
        }

        try {
            sqtBolsaPreventaService.save(sqtBolsaPreventa)
        } catch (ValidationException e) {
            respond sqtBolsaPreventa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtBolsaPreventa.label', default: 'SqtBolsaPreventa'), sqtBolsaPreventa.id])
                redirect sqtBolsaPreventa
            }
            '*' { respond sqtBolsaPreventa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtBolsaPreventaService.get(id)
    }

    def update(SqtBolsaPreventa sqtBolsaPreventa) {
        if (sqtBolsaPreventa == null) {
            notFound()
            return
        }

        try {
            sqtBolsaPreventaService.save(sqtBolsaPreventa)
        } catch (ValidationException e) {
            respond sqtBolsaPreventa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtBolsaPreventa.label', default: 'SqtBolsaPreventa'), sqtBolsaPreventa.id])
                redirect sqtBolsaPreventa
            }
            '*'{ respond sqtBolsaPreventa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtBolsaPreventaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtBolsaPreventa.label', default: 'SqtBolsaPreventa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtBolsaPreventa.label', default: 'SqtBolsaPreventa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
