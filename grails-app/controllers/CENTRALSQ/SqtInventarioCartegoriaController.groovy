package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioCartegoriaController {

    SqtInventarioCartegoriaService sqtInventarioCartegoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioCartegoriaService.list(params), model:[sqtInventarioCartegoriaCount: sqtInventarioCartegoriaService.count()]
    }

    def show(Long id) {
        respond sqtInventarioCartegoriaService.get(id)
    }

    def create() {
        respond new SqtInventarioCartegoria(params)
    }

    def save(SqtInventarioCartegoria sqtInventarioCartegoria) {
        if (sqtInventarioCartegoria == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCartegoriaService.save(sqtInventarioCartegoria)
        } catch (ValidationException e) {
            respond sqtInventarioCartegoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioCartegoria.label', default: 'SqtInventarioCartegoria'), sqtInventarioCartegoria.id])
                redirect sqtInventarioCartegoria
            }
            '*' { respond sqtInventarioCartegoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioCartegoriaService.get(id)
    }

    def update(SqtInventarioCartegoria sqtInventarioCartegoria) {
        if (sqtInventarioCartegoria == null) {
            notFound()
            return
        }

        try {
            sqtInventarioCartegoriaService.save(sqtInventarioCartegoria)
        } catch (ValidationException e) {
            respond sqtInventarioCartegoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioCartegoria.label', default: 'SqtInventarioCartegoria'), sqtInventarioCartegoria.id])
                redirect sqtInventarioCartegoria
            }
            '*'{ respond sqtInventarioCartegoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioCartegoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioCartegoria.label', default: 'SqtInventarioCartegoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioCartegoria.label', default: 'SqtInventarioCartegoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
