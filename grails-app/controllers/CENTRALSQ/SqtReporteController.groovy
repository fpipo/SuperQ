package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtReporteController {

    SqtReporteService sqtReporteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtReporteService.list(params), model:[sqtReporteCount: sqtReporteService.count()]
    }

    def show(Long id) {
        respond sqtReporteService.get(id)
    }

    def create() {
        respond new SqtReporte(params)
    }

    def save(SqtReporte sqtReporte) {
        if (sqtReporte == null) {
            notFound()
            return
        }

        try {
            sqtReporteService.save(sqtReporte)
        } catch (ValidationException e) {
            respond sqtReporte.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtReporte.label', default: 'SqtReporte'), sqtReporte.id])
                redirect sqtReporte
            }
            '*' { respond sqtReporte, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtReporteService.get(id)
    }

    def update(SqtReporte sqtReporte) {
        if (sqtReporte == null) {
            notFound()
            return
        }

        try {
            sqtReporteService.save(sqtReporte)
        } catch (ValidationException e) {
            respond sqtReporte.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtReporte.label', default: 'SqtReporte'), sqtReporte.id])
                redirect sqtReporte
            }
            '*'{ respond sqtReporte, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtReporteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtReporte.label', default: 'SqtReporte'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtReporte.label', default: 'SqtReporte'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
