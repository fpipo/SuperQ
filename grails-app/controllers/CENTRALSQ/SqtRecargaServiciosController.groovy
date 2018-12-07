package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRecargaServiciosController {

    SqtRecargaServiciosService sqtRecargaServiciosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRecargaServiciosService.list(params), model:[sqtRecargaServiciosCount: sqtRecargaServiciosService.count()]
    }

    def show(Long id) {
        respond sqtRecargaServiciosService.get(id)
    }

    def create() {
        respond new SqtRecargaServicios(params)
    }

    def save(SqtRecargaServicios sqtRecargaServicios) {
        if (sqtRecargaServicios == null) {
            notFound()
            return
        }

        try {
            sqtRecargaServiciosService.save(sqtRecargaServicios)
        } catch (ValidationException e) {
            respond sqtRecargaServicios.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRecargaServicios.label', default: 'SqtRecargaServicios'), sqtRecargaServicios.id])
                redirect sqtRecargaServicios
            }
            '*' { respond sqtRecargaServicios, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRecargaServiciosService.get(id)
    }

    def update(SqtRecargaServicios sqtRecargaServicios) {
        if (sqtRecargaServicios == null) {
            notFound()
            return
        }

        try {
            sqtRecargaServiciosService.save(sqtRecargaServicios)
        } catch (ValidationException e) {
            respond sqtRecargaServicios.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRecargaServicios.label', default: 'SqtRecargaServicios'), sqtRecargaServicios.id])
                redirect sqtRecargaServicios
            }
            '*'{ respond sqtRecargaServicios, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRecargaServiciosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRecargaServicios.label', default: 'SqtRecargaServicios'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRecargaServicios.label', default: 'SqtRecargaServicios'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
