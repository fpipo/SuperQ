package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCuotaServicioController {

    SqtCuotaServicioService sqtCuotaServicioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCuotaServicioService.list(params), model:[sqtCuotaServicioCount: sqtCuotaServicioService.count()]
    }

    def show(Long id) {
        respond sqtCuotaServicioService.get(id)
    }

    def create() {
        respond new SqtCuotaServicio(params)
    }

    def save(SqtCuotaServicio sqtCuotaServicio) {
        if (sqtCuotaServicio == null) {
            notFound()
            return
        }

        try {
            sqtCuotaServicioService.save(sqtCuotaServicio)
        } catch (ValidationException e) {
            respond sqtCuotaServicio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCuotaServicio.label', default: 'SqtCuotaServicio'), sqtCuotaServicio.id])
                redirect sqtCuotaServicio
            }
            '*' { respond sqtCuotaServicio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCuotaServicioService.get(id)
    }

    def update(SqtCuotaServicio sqtCuotaServicio) {
        if (sqtCuotaServicio == null) {
            notFound()
            return
        }

        try {
            sqtCuotaServicioService.save(sqtCuotaServicio)
        } catch (ValidationException e) {
            respond sqtCuotaServicio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCuotaServicio.label', default: 'SqtCuotaServicio'), sqtCuotaServicio.id])
                redirect sqtCuotaServicio
            }
            '*'{ respond sqtCuotaServicio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCuotaServicioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCuotaServicio.label', default: 'SqtCuotaServicio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCuotaServicio.label', default: 'SqtCuotaServicio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
