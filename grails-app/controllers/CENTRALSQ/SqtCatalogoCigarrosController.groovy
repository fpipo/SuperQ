package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCatalogoCigarrosController {

    SqtCatalogoCigarrosService sqtCatalogoCigarrosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCatalogoCigarrosService.list(params), model:[sqtCatalogoCigarrosCount: sqtCatalogoCigarrosService.count()]
    }

    def show(Long id) {
        respond sqtCatalogoCigarrosService.get(id)
    }

    def create() {
        respond new SqtCatalogoCigarros(params)
    }

    def save(SqtCatalogoCigarros sqtCatalogoCigarros) {
        if (sqtCatalogoCigarros == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoCigarrosService.save(sqtCatalogoCigarros)
        } catch (ValidationException e) {
            respond sqtCatalogoCigarros.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCatalogoCigarros.label', default: 'SqtCatalogoCigarros'), sqtCatalogoCigarros.id])
                redirect sqtCatalogoCigarros
            }
            '*' { respond sqtCatalogoCigarros, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCatalogoCigarrosService.get(id)
    }

    def update(SqtCatalogoCigarros sqtCatalogoCigarros) {
        if (sqtCatalogoCigarros == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoCigarrosService.save(sqtCatalogoCigarros)
        } catch (ValidationException e) {
            respond sqtCatalogoCigarros.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCatalogoCigarros.label', default: 'SqtCatalogoCigarros'), sqtCatalogoCigarros.id])
                redirect sqtCatalogoCigarros
            }
            '*'{ respond sqtCatalogoCigarros, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCatalogoCigarrosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCatalogoCigarros.label', default: 'SqtCatalogoCigarros'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCatalogoCigarros.label', default: 'SqtCatalogoCigarros'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
