package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDetalleReporteController {

    SqtDetalleReporteService sqtDetalleReporteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDetalleReporteService.list(params), model:[sqtDetalleReporteCount: sqtDetalleReporteService.count()]
    }

    def show(Long id) {
        respond sqtDetalleReporteService.get(id)
    }

    def create() {
        respond new SqtDetalleReporte(params)
    }

    def save(SqtDetalleReporte sqtDetalleReporte) {
        if (sqtDetalleReporte == null) {
            notFound()
            return
        }

        try {
            sqtDetalleReporteService.save(sqtDetalleReporte)
        } catch (ValidationException e) {
            respond sqtDetalleReporte.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDetalleReporte.label', default: 'SqtDetalleReporte'), sqtDetalleReporte.id])
                redirect sqtDetalleReporte
            }
            '*' { respond sqtDetalleReporte, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDetalleReporteService.get(id)
    }

    def update(SqtDetalleReporte sqtDetalleReporte) {
        if (sqtDetalleReporte == null) {
            notFound()
            return
        }

        try {
            sqtDetalleReporteService.save(sqtDetalleReporte)
        } catch (ValidationException e) {
            respond sqtDetalleReporte.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDetalleReporte.label', default: 'SqtDetalleReporte'), sqtDetalleReporte.id])
                redirect sqtDetalleReporte
            }
            '*'{ respond sqtDetalleReporte, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDetalleReporteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDetalleReporte.label', default: 'SqtDetalleReporte'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDetalleReporte.label', default: 'SqtDetalleReporte'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
