package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtVentaAcumuladaProductivaController {

    SqtVentaAcumuladaProductivaService sqtVentaAcumuladaProductivaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtVentaAcumuladaProductivaService.list(params), model:[sqtVentaAcumuladaProductivaCount: sqtVentaAcumuladaProductivaService.count()]
    }

    def show(Long id) {
        respond sqtVentaAcumuladaProductivaService.get(id)
    }

    def create() {
        respond new SqtVentaAcumuladaProductiva(params)
    }

    def save(SqtVentaAcumuladaProductiva sqtVentaAcumuladaProductiva) {
        if (sqtVentaAcumuladaProductiva == null) {
            notFound()
            return
        }

        try {
            sqtVentaAcumuladaProductivaService.save(sqtVentaAcumuladaProductiva)
        } catch (ValidationException e) {
            respond sqtVentaAcumuladaProductiva.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtVentaAcumuladaProductiva.label', default: 'SqtVentaAcumuladaProductiva'), sqtVentaAcumuladaProductiva.id])
                redirect sqtVentaAcumuladaProductiva
            }
            '*' { respond sqtVentaAcumuladaProductiva, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtVentaAcumuladaProductivaService.get(id)
    }

    def update(SqtVentaAcumuladaProductiva sqtVentaAcumuladaProductiva) {
        if (sqtVentaAcumuladaProductiva == null) {
            notFound()
            return
        }

        try {
            sqtVentaAcumuladaProductivaService.save(sqtVentaAcumuladaProductiva)
        } catch (ValidationException e) {
            respond sqtVentaAcumuladaProductiva.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtVentaAcumuladaProductiva.label', default: 'SqtVentaAcumuladaProductiva'), sqtVentaAcumuladaProductiva.id])
                redirect sqtVentaAcumuladaProductiva
            }
            '*'{ respond sqtVentaAcumuladaProductiva, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtVentaAcumuladaProductivaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtVentaAcumuladaProductiva.label', default: 'SqtVentaAcumuladaProductiva'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtVentaAcumuladaProductiva.label', default: 'SqtVentaAcumuladaProductiva'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
