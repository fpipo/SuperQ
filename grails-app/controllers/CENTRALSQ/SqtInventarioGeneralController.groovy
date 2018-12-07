package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInventarioGeneralController {

    SqtInventarioGeneralService sqtInventarioGeneralService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInventarioGeneralService.list(params), model:[sqtInventarioGeneralCount: sqtInventarioGeneralService.count()]
    }

    def show(Long id) {
        respond sqtInventarioGeneralService.get(id)
    }

    def create() {
        respond new SqtInventarioGeneral(params)
    }

    def save(SqtInventarioGeneral sqtInventarioGeneral) {
        if (sqtInventarioGeneral == null) {
            notFound()
            return
        }

        try {
            sqtInventarioGeneralService.save(sqtInventarioGeneral)
        } catch (ValidationException e) {
            respond sqtInventarioGeneral.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInventarioGeneral.label', default: 'SqtInventarioGeneral'), sqtInventarioGeneral.id])
                redirect sqtInventarioGeneral
            }
            '*' { respond sqtInventarioGeneral, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInventarioGeneralService.get(id)
    }

    def update(SqtInventarioGeneral sqtInventarioGeneral) {
        if (sqtInventarioGeneral == null) {
            notFound()
            return
        }

        try {
            sqtInventarioGeneralService.save(sqtInventarioGeneral)
        } catch (ValidationException e) {
            respond sqtInventarioGeneral.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInventarioGeneral.label', default: 'SqtInventarioGeneral'), sqtInventarioGeneral.id])
                redirect sqtInventarioGeneral
            }
            '*'{ respond sqtInventarioGeneral, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInventarioGeneralService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInventarioGeneral.label', default: 'SqtInventarioGeneral'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInventarioGeneral.label', default: 'SqtInventarioGeneral'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
