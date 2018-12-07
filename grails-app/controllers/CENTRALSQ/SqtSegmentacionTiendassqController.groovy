package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtSegmentacionTiendassqController {

    SqtSegmentacionTiendassqService sqtSegmentacionTiendassqService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtSegmentacionTiendassqService.list(params), model:[sqtSegmentacionTiendassqCount: sqtSegmentacionTiendassqService.count()]
    }

    def show(Long id) {
        respond sqtSegmentacionTiendassqService.get(id)
    }

    def create() {
        respond new SqtSegmentacionTiendassq(params)
    }

    def save(SqtSegmentacionTiendassq sqtSegmentacionTiendassq) {
        if (sqtSegmentacionTiendassq == null) {
            notFound()
            return
        }

        try {
            sqtSegmentacionTiendassqService.save(sqtSegmentacionTiendassq)
        } catch (ValidationException e) {
            respond sqtSegmentacionTiendassq.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtSegmentacionTiendassq.label', default: 'SqtSegmentacionTiendassq'), sqtSegmentacionTiendassq.id])
                redirect sqtSegmentacionTiendassq
            }
            '*' { respond sqtSegmentacionTiendassq, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtSegmentacionTiendassqService.get(id)
    }

    def update(SqtSegmentacionTiendassq sqtSegmentacionTiendassq) {
        if (sqtSegmentacionTiendassq == null) {
            notFound()
            return
        }

        try {
            sqtSegmentacionTiendassqService.save(sqtSegmentacionTiendassq)
        } catch (ValidationException e) {
            respond sqtSegmentacionTiendassq.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtSegmentacionTiendassq.label', default: 'SqtSegmentacionTiendassq'), sqtSegmentacionTiendassq.id])
                redirect sqtSegmentacionTiendassq
            }
            '*'{ respond sqtSegmentacionTiendassq, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtSegmentacionTiendassqService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtSegmentacionTiendassq.label', default: 'SqtSegmentacionTiendassq'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtSegmentacionTiendassq.label', default: 'SqtSegmentacionTiendassq'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
