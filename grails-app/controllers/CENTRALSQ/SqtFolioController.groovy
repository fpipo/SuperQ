package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtFolioController {

    SqtFolioService sqtFolioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtFolioService.list(params), model:[sqtFolioCount: sqtFolioService.count()]
    }

    def show(Long id) {
        respond sqtFolioService.get(id)
    }

    def create() {
        respond new SqtFolio(params)
    }

    def save(SqtFolio sqtFolio) {
        if (sqtFolio == null) {
            notFound()
            return
        }

        try {
            sqtFolioService.save(sqtFolio)
        } catch (ValidationException e) {
            respond sqtFolio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtFolio.label', default: 'SqtFolio'), sqtFolio.id])
                redirect sqtFolio
            }
            '*' { respond sqtFolio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtFolioService.get(id)
    }

    def update(SqtFolio sqtFolio) {
        if (sqtFolio == null) {
            notFound()
            return
        }

        try {
            sqtFolioService.save(sqtFolio)
        } catch (ValidationException e) {
            respond sqtFolio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtFolio.label', default: 'SqtFolio'), sqtFolio.id])
                redirect sqtFolio
            }
            '*'{ respond sqtFolio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtFolioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtFolio.label', default: 'SqtFolio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtFolio.label', default: 'SqtFolio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
