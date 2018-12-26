package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtIdiomaController {

    SqtIdiomaService sqtIdiomaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtIdiomaService.list(params), model:[sqtIdiomaCount: sqtIdiomaService.count()]
    }

    def show(Long id) {
        respond sqtIdiomaService.get(id)
    }

    def create() {
        respond new SqtIdioma(params)
    }

    def save(SqtIdioma sqtIdioma) {
        if (sqtIdioma == null) {
            notFound()
            return
        }

        try {
            sqtIdiomaService.save(sqtIdioma)
        } catch (ValidationException e) {
            respond sqtIdioma.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtIdioma.label', default: 'SqtIdioma'), sqtIdioma.id])
                redirect sqtIdioma
            }
            '*' { respond sqtIdioma, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtIdiomaService.get(id)
    }

    def update(SqtIdioma sqtIdioma) {
        if (sqtIdioma == null) {
            notFound()
            return
        }

        try {
            sqtIdiomaService.save(sqtIdioma)
        } catch (ValidationException e) {
            respond sqtIdioma.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtIdioma.label', default: 'SqtIdioma'), sqtIdioma.id])
                redirect sqtIdioma
            }
            '*'{ respond sqtIdioma, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtIdiomaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtIdioma.label', default: 'SqtIdioma'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtIdioma.label', default: 'SqtIdioma'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
