package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtRetiroCajaController {

    SqtRetiroCajaService sqtRetiroCajaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtRetiroCajaService.list(params), model:[sqtRetiroCajaCount: sqtRetiroCajaService.count()]
    }

    def show(Long id) {
        respond sqtRetiroCajaService.get(id)
    }

    def create() {
        respond new SqtRetiroCaja(params)
    }

    def save(SqtRetiroCaja sqtRetiroCaja) {
        if (sqtRetiroCaja == null) {
            notFound()
            return
        }

        try {
            sqtRetiroCajaService.save(sqtRetiroCaja)
        } catch (ValidationException e) {
            respond sqtRetiroCaja.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtRetiroCaja.label', default: 'SqtRetiroCaja'), sqtRetiroCaja.id])
                redirect sqtRetiroCaja
            }
            '*' { respond sqtRetiroCaja, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtRetiroCajaService.get(id)
    }

    def update(SqtRetiroCaja sqtRetiroCaja) {
        if (sqtRetiroCaja == null) {
            notFound()
            return
        }

        try {
            sqtRetiroCajaService.save(sqtRetiroCaja)
        } catch (ValidationException e) {
            respond sqtRetiroCaja.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtRetiroCaja.label', default: 'SqtRetiroCaja'), sqtRetiroCaja.id])
                redirect sqtRetiroCaja
            }
            '*'{ respond sqtRetiroCaja, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtRetiroCajaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtRetiroCaja.label', default: 'SqtRetiroCaja'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtRetiroCaja.label', default: 'SqtRetiroCaja'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
