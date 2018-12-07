package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAreaController {

    SqtAreaService sqtAreaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAreaService.list(params), model:[sqtAreaCount: sqtAreaService.count()]
    }

    def show(Long id) {
        respond sqtAreaService.get(id)
    }

    def create() {
        respond new SqtArea(params)
    }

    def save(SqtArea sqtArea) {
        if (sqtArea == null) {
            notFound()
            return
        }

        try {
            sqtAreaService.save(sqtArea)
        } catch (ValidationException e) {
            respond sqtArea.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtArea.label', default: 'SqtArea'), sqtArea.id])
                redirect sqtArea
            }
            '*' { respond sqtArea, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAreaService.get(id)
    }

    def update(SqtArea sqtArea) {
        if (sqtArea == null) {
            notFound()
            return
        }

        try {
            sqtAreaService.save(sqtArea)
        } catch (ValidationException e) {
            respond sqtArea.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtArea.label', default: 'SqtArea'), sqtArea.id])
                redirect sqtArea
            }
            '*'{ respond sqtArea, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAreaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtArea.label', default: 'SqtArea'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtArea.label', default: 'SqtArea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
