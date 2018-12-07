package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPaisController {

    SqtPaisService sqtPaisService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPaisService.list(params), model:[sqtPaisCount: sqtPaisService.count()]
    }

    def show(Long id) {
        respond sqtPaisService.get(id)
    }

    def create() {
        respond new SqtPais(params)
    }

    def save(SqtPais sqtPais) {
        if (sqtPais == null) {
            notFound()
            return
        }

        try {
            sqtPaisService.save(sqtPais)
        } catch (ValidationException e) {
            respond sqtPais.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPais.label', default: 'SqtPais'), sqtPais.id])
                redirect sqtPais
            }
            '*' { respond sqtPais, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPaisService.get(id)
    }

    def update(SqtPais sqtPais) {
        if (sqtPais == null) {
            notFound()
            return
        }

        try {
            sqtPaisService.save(sqtPais)
        } catch (ValidationException e) {
            respond sqtPais.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPais.label', default: 'SqtPais'), sqtPais.id])
                redirect sqtPais
            }
            '*'{ respond sqtPais, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPaisService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPais.label', default: 'SqtPais'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPais.label', default: 'SqtPais'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
