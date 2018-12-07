package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtMarcaController {

    SqtMarcaService sqtMarcaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtMarcaService.list(params), model:[sqtMarcaCount: sqtMarcaService.count()]
    }

    def show(Long id) {
        respond sqtMarcaService.get(id)
    }

    def create() {
        respond new SqtMarca(params)
    }

    def save(SqtMarca sqtMarca) {
        if (sqtMarca == null) {
            notFound()
            return
        }

        try {
            sqtMarcaService.save(sqtMarca)
        } catch (ValidationException e) {
            respond sqtMarca.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtMarca.label', default: 'SqtMarca'), sqtMarca.id])
                redirect sqtMarca
            }
            '*' { respond sqtMarca, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtMarcaService.get(id)
    }

    def update(SqtMarca sqtMarca) {
        if (sqtMarca == null) {
            notFound()
            return
        }

        try {
            sqtMarcaService.save(sqtMarca)
        } catch (ValidationException e) {
            respond sqtMarca.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtMarca.label', default: 'SqtMarca'), sqtMarca.id])
                redirect sqtMarca
            }
            '*'{ respond sqtMarca, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtMarcaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtMarca.label', default: 'SqtMarca'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtMarca.label', default: 'SqtMarca'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
