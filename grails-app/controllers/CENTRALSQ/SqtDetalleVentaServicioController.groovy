package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleVentaServicioController {

    SqtDetalleVentaServicioService sqtDetalleVentaServicioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleVentaServicioService.list(params), model:[sqtDetalleVentaServicioCount: sqtDetalleVentaServicioService.count()]
    }

    def show(Long id) {
        respond sqtDetalleVentaServicioService.get(id)
    }

    def create() {
        respond new SqtDetalleVentaServicio(params)
    }

    def save(SqtDetalleVentaServicio sqtDetalleVentaServicio) {
        if (sqtDetalleVentaServicio == null) {
            notFound()
            return
        }

        try {
            sqtDetalleVentaServicioService.save(sqtDetalleVentaServicio)
        } catch (ValidationException e) {
            respond sqtDetalleVentaServicio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleVentaServicio.label', default: 'SqtDetalleVentaServicio'), sqtDetalleVentaServicio.id])
                redirect sqtDetalleVentaServicio
            }
            '*' { respond sqtDetalleVentaServicio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleVentaServicioService.get(id)
    }

    def update(SqtDetalleVentaServicio sqtDetalleVentaServicio) {
        if (sqtDetalleVentaServicio == null) {
            notFound()
            return
        }

        try {
            sqtDetalleVentaServicioService.save(sqtDetalleVentaServicio)
        } catch (ValidationException e) {
            respond sqtDetalleVentaServicio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleVentaServicio.label', default: 'SqtDetalleVentaServicio'), sqtDetalleVentaServicio.id])
                redirect sqtDetalleVentaServicio
            }
            '*'{ respond sqtDetalleVentaServicio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleVentaServicioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleVentaServicio.label', default: 'SqtDetalleVentaServicio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleVentaServicio.label', default: 'SqtDetalleVentaServicio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
