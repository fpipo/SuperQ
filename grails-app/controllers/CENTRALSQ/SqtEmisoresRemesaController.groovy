package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtEmisoresRemesaController {

    SqtEmisoresRemesaService sqtEmisoresRemesaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtEmisoresRemesaService.list(params), model:[sqtEmisoresRemesaCount: sqtEmisoresRemesaService.count()]
    }

    def show(Long id) {
        respond sqtEmisoresRemesaService.get(id)
    }

    def create() {
        respond new SqtEmisoresRemesa(params)
    }

    def save(SqtEmisoresRemesa sqtEmisoresRemesa) {
        if (sqtEmisoresRemesa == null) {
            notFound()
            return
        }

        try {
            sqtEmisoresRemesaService.save(sqtEmisoresRemesa)
        } catch (ValidationException e) {
            respond sqtEmisoresRemesa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtEmisoresRemesa.label', default: 'SqtEmisoresRemesa'), sqtEmisoresRemesa.id])
                redirect sqtEmisoresRemesa
            }
            '*' { respond sqtEmisoresRemesa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtEmisoresRemesaService.get(id)
    }

    def update(SqtEmisoresRemesa sqtEmisoresRemesa) {
        if (sqtEmisoresRemesa == null) {
            notFound()
            return
        }

        try {
            sqtEmisoresRemesaService.save(sqtEmisoresRemesa)
        } catch (ValidationException e) {
            respond sqtEmisoresRemesa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtEmisoresRemesa.label', default: 'SqtEmisoresRemesa'), sqtEmisoresRemesa.id])
                redirect sqtEmisoresRemesa
            }
            '*'{ respond sqtEmisoresRemesa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtEmisoresRemesaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtEmisoresRemesa.label', default: 'SqtEmisoresRemesa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtEmisoresRemesa.label', default: 'SqtEmisoresRemesa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
