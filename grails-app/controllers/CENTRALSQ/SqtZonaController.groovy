package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtZonaController {

    SqtZonaService sqtZonaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtZonaService.list(params), model:[sqtZonaCount: sqtZonaService.count()]
    }

    def show(Long id) {
        respond sqtZonaService.get(id)
    }

    def create() {
        respond new SqtZona(params)
    }

    def save(SqtZona sqtZona) {
        if (sqtZona == null) {
            notFound()
            return
        }

        try {
            sqtZonaService.save(sqtZona)
        } catch (ValidationException e) {
            respond sqtZona.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtZona.label', default: 'SqtZona'), sqtZona.id])
                redirect sqtZona
            }
            '*' { respond sqtZona, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtZonaService.get(id)
    }

    def update(SqtZona sqtZona) {
        if (sqtZona == null) {
            notFound()
            return
        }

        try {
            sqtZonaService.save(sqtZona)
        } catch (ValidationException e) {
            respond sqtZona.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtZona.label', default: 'SqtZona'), sqtZona.id])
                redirect sqtZona
            }
            '*'{ respond sqtZona, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtZonaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtZona.label', default: 'SqtZona'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtZona.label', default: 'SqtZona'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
