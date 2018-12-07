package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCatalogoGlasgoController {

    SqtCatalogoGlasgoService sqtCatalogoGlasgoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCatalogoGlasgoService.list(params), model:[sqtCatalogoGlasgoCount: sqtCatalogoGlasgoService.count()]
    }

    def show(Long id) {
        respond sqtCatalogoGlasgoService.get(id)
    }

    def create() {
        respond new SqtCatalogoGlasgo(params)
    }

    def save(SqtCatalogoGlasgo sqtCatalogoGlasgo) {
        if (sqtCatalogoGlasgo == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoGlasgoService.save(sqtCatalogoGlasgo)
        } catch (ValidationException e) {
            respond sqtCatalogoGlasgo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCatalogoGlasgo.label', default: 'SqtCatalogoGlasgo'), sqtCatalogoGlasgo.id])
                redirect sqtCatalogoGlasgo
            }
            '*' { respond sqtCatalogoGlasgo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCatalogoGlasgoService.get(id)
    }

    def update(SqtCatalogoGlasgo sqtCatalogoGlasgo) {
        if (sqtCatalogoGlasgo == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoGlasgoService.save(sqtCatalogoGlasgo)
        } catch (ValidationException e) {
            respond sqtCatalogoGlasgo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCatalogoGlasgo.label', default: 'SqtCatalogoGlasgo'), sqtCatalogoGlasgo.id])
                redirect sqtCatalogoGlasgo
            }
            '*'{ respond sqtCatalogoGlasgo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCatalogoGlasgoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCatalogoGlasgo.label', default: 'SqtCatalogoGlasgo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCatalogoGlasgo.label', default: 'SqtCatalogoGlasgo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
