package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtInfoAdicionalIusaController {

    SqtInfoAdicionalIusaService sqtInfoAdicionalIusaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtInfoAdicionalIusaService.list(params), model:[sqtInfoAdicionalIusaCount: sqtInfoAdicionalIusaService.count()]
    }

    def show(Long id) {
        respond sqtInfoAdicionalIusaService.get(id)
    }

    def create() {
        respond new SqtInfoAdicionalIusa(params)
    }

    def save(SqtInfoAdicionalIusa sqtInfoAdicionalIusa) {
        if (sqtInfoAdicionalIusa == null) {
            notFound()
            return
        }

        try {
            sqtInfoAdicionalIusaService.save(sqtInfoAdicionalIusa)
        } catch (ValidationException e) {
            respond sqtInfoAdicionalIusa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtInfoAdicionalIusa.label', default: 'SqtInfoAdicionalIusa'), sqtInfoAdicionalIusa.id])
                redirect sqtInfoAdicionalIusa
            }
            '*' { respond sqtInfoAdicionalIusa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtInfoAdicionalIusaService.get(id)
    }

    def update(SqtInfoAdicionalIusa sqtInfoAdicionalIusa) {
        if (sqtInfoAdicionalIusa == null) {
            notFound()
            return
        }

        try {
            sqtInfoAdicionalIusaService.save(sqtInfoAdicionalIusa)
        } catch (ValidationException e) {
            respond sqtInfoAdicionalIusa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtInfoAdicionalIusa.label', default: 'SqtInfoAdicionalIusa'), sqtInfoAdicionalIusa.id])
                redirect sqtInfoAdicionalIusa
            }
            '*'{ respond sqtInfoAdicionalIusa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtInfoAdicionalIusaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtInfoAdicionalIusa.label', default: 'SqtInfoAdicionalIusa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtInfoAdicionalIusa.label', default: 'SqtInfoAdicionalIusa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
