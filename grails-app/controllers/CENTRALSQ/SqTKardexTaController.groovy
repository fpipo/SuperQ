package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqTKardexTaController {

    SqTKardexTaService sqTKardexTaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqTKardexTaService.list(params), model:[sqTKardexTaCount: sqTKardexTaService.count()]
    }

    def show(Long id) {
        respond sqTKardexTaService.get(id)
    }

    def create() {
        respond new SqTKardexTa(params)
    }

    def save(SqTKardexTa sqTKardexTa) {
        if (sqTKardexTa == null) {
            notFound()
            return
        }

        try {
            sqTKardexTaService.save(sqTKardexTa)
        } catch (ValidationException e) {
            respond sqTKardexTa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqTKardexTa.label', default: 'SqTKardexTa'), sqTKardexTa.id])
                redirect sqTKardexTa
            }
            '*' { respond sqTKardexTa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqTKardexTaService.get(id)
    }

    def update(SqTKardexTa sqTKardexTa) {
        if (sqTKardexTa == null) {
            notFound()
            return
        }

        try {
            sqTKardexTaService.save(sqTKardexTa)
        } catch (ValidationException e) {
            respond sqTKardexTa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqTKardexTa.label', default: 'SqTKardexTa'), sqTKardexTa.id])
                redirect sqTKardexTa
            }
            '*'{ respond sqTKardexTa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqTKardexTaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqTKardexTa.label', default: 'SqTKardexTa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqTKardexTa.label', default: 'SqTKardexTa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
