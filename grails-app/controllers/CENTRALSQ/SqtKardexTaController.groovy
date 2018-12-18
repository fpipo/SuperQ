package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtKardexTaController {

    SqtKardexTaService sqtKardexTaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtKardexTaService.list(params), model:[sqtKardexTaCount: sqtKardexTaService.count()]
    }

    def show(Long id) {
        respond sqtKardexTaService.get(id)
    }

    def create() {
        respond new SqtKardexTa(params)
    }

    def save(SqtKardexTa sqtKardexTa) {
        if (sqtKardexTa == null) {
            notFound()
            return
        }

        try {
            sqtKardexTaService.save(sqtKardexTa)
        } catch (ValidationException e) {
            respond sqtKardexTa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtKardexTa.label', default: 'SqtKardexTa'), sqtKardexTa.id])
                redirect sqtKardexTa
            }
            '*' { respond sqtKardexTa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtKardexTaService.get(id)
    }

    def update(SqtKardexTa sqtKardexTa) {
        if (sqtKardexTa == null) {
            notFound()
            return
        }

        try {
            sqtKardexTaService.save(sqtKardexTa)
        } catch (ValidationException e) {
            respond sqtKardexTa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtKardexTa.label', default: 'SqtKardexTa'), sqtKardexTa.id])
                redirect sqtKardexTa
            }
            '*'{ respond sqtKardexTa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtKardexTaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtKardexTa.label', default: 'SqtKardexTa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtKardexTa.label', default: 'SqtKardexTa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
