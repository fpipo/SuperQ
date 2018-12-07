package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCompaniaTaController {

    SqtCompaniaTaService sqtCompaniaTaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCompaniaTaService.list(params), model:[sqtCompaniaTaCount: sqtCompaniaTaService.count()]
    }

    def show(Long id) {
        respond sqtCompaniaTaService.get(id)
    }

    def create() {
        respond new SqtCompaniaTa(params)
    }

    def save(SqtCompaniaTa sqtCompaniaTa) {
        if (sqtCompaniaTa == null) {
            notFound()
            return
        }

        try {
            sqtCompaniaTaService.save(sqtCompaniaTa)
        } catch (ValidationException e) {
            respond sqtCompaniaTa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCompaniaTa.label', default: 'SqtCompaniaTa'), sqtCompaniaTa.id])
                redirect sqtCompaniaTa
            }
            '*' { respond sqtCompaniaTa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCompaniaTaService.get(id)
    }

    def update(SqtCompaniaTa sqtCompaniaTa) {
        if (sqtCompaniaTa == null) {
            notFound()
            return
        }

        try {
            sqtCompaniaTaService.save(sqtCompaniaTa)
        } catch (ValidationException e) {
            respond sqtCompaniaTa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCompaniaTa.label', default: 'SqtCompaniaTa'), sqtCompaniaTa.id])
                redirect sqtCompaniaTa
            }
            '*'{ respond sqtCompaniaTa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCompaniaTaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCompaniaTa.label', default: 'SqtCompaniaTa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCompaniaTa.label', default: 'SqtCompaniaTa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
