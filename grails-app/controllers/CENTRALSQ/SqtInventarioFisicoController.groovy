package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioFisicoController {

    SqtInventarioFisicoService sqtInventarioFisicoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioFisicoService.list(params), model:[sqtInventarioFisicoCount: sqtInventarioFisicoService.count()]
    }

    def show(Long id) {
        respond sqtInventarioFisicoService.get(id)
    }

    def create() {
        respond new SqtInventarioFisico(params)
    }

    def save(SqtInventarioFisico sqtInventarioFisico) {
        if (sqtInventarioFisico == null) {
            notFound()
            return
        }

        try {
            sqtInventarioFisicoService.save(sqtInventarioFisico)
        } catch (ValidationException e) {
            respond sqtInventarioFisico.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioFisico.label', default: 'SqtInventarioFisico'), sqtInventarioFisico.id])
                redirect sqtInventarioFisico
            }
            '*' { respond sqtInventarioFisico, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioFisicoService.get(id)
    }

    def update(SqtInventarioFisico sqtInventarioFisico) {
        if (sqtInventarioFisico == null) {
            notFound()
            return
        }

        try {
            sqtInventarioFisicoService.save(sqtInventarioFisico)
        } catch (ValidationException e) {
            respond sqtInventarioFisico.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioFisico.label', default: 'SqtInventarioFisico'), sqtInventarioFisico.id])
                redirect sqtInventarioFisico
            }
            '*'{ respond sqtInventarioFisico, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioFisicoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioFisico.label', default: 'SqtInventarioFisico'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioFisico.label', default: 'SqtInventarioFisico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
