package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtEtiquetaIdiomaController {

    SqtEtiquetaIdiomaService sqtEtiquetaIdiomaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtEtiquetaIdiomaService.list(params), model:[sqtEtiquetaIdiomaCount: sqtEtiquetaIdiomaService.count()]
    }

    def show(Long id) {
        respond sqtEtiquetaIdiomaService.get(id)
    }

    def create() {
        respond new SqtEtiquetaIdioma(params)
    }

    def save(SqtEtiquetaIdioma sqtEtiquetaIdioma) {
        if (sqtEtiquetaIdioma == null) {
            notFound()
            return
        }

        try {
            sqtEtiquetaIdiomaService.save(sqtEtiquetaIdioma)
        } catch (ValidationException e) {
            respond sqtEtiquetaIdioma.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtEtiquetaIdioma.label', default: 'SqtEtiquetaIdioma'), sqtEtiquetaIdioma.id])
                redirect sqtEtiquetaIdioma
            }
            '*' { respond sqtEtiquetaIdioma, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtEtiquetaIdiomaService.get(id)
    }

    def update(SqtEtiquetaIdioma sqtEtiquetaIdioma) {
        if (sqtEtiquetaIdioma == null) {
            notFound()
            return
        }

        try {
            sqtEtiquetaIdiomaService.save(sqtEtiquetaIdioma)
        } catch (ValidationException e) {
            respond sqtEtiquetaIdioma.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtEtiquetaIdioma.label', default: 'SqtEtiquetaIdioma'), sqtEtiquetaIdioma.id])
                redirect sqtEtiquetaIdioma
            }
            '*'{ respond sqtEtiquetaIdioma, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtEtiquetaIdiomaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtEtiquetaIdioma.label', default: 'SqtEtiquetaIdioma'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtEtiquetaIdioma.label', default: 'SqtEtiquetaIdioma'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
