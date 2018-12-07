package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDatosTiendaPMController {

    SqtDatosTiendaPMService sqtDatosTiendaPMService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDatosTiendaPMService.list(params), model:[sqtDatosTiendaPMCount: sqtDatosTiendaPMService.count()]
    }

    def show(Long id) {
        respond sqtDatosTiendaPMService.get(id)
    }

    def create() {
        respond new SqtDatosTiendaPM(params)
    }

    def save(SqtDatosTiendaPM sqtDatosTiendaPM) {
        if (sqtDatosTiendaPM == null) {
            notFound()
            return
        }

        try {
            sqtDatosTiendaPMService.save(sqtDatosTiendaPM)
        } catch (ValidationException e) {
            respond sqtDatosTiendaPM.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDatosTiendaPM.label', default: 'SqtDatosTiendaPM'), sqtDatosTiendaPM.id])
                redirect sqtDatosTiendaPM
            }
            '*' { respond sqtDatosTiendaPM, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDatosTiendaPMService.get(id)
    }

    def update(SqtDatosTiendaPM sqtDatosTiendaPM) {
        if (sqtDatosTiendaPM == null) {
            notFound()
            return
        }

        try {
            sqtDatosTiendaPMService.save(sqtDatosTiendaPM)
        } catch (ValidationException e) {
            respond sqtDatosTiendaPM.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDatosTiendaPM.label', default: 'SqtDatosTiendaPM'), sqtDatosTiendaPM.id])
                redirect sqtDatosTiendaPM
            }
            '*'{ respond sqtDatosTiendaPM, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDatosTiendaPMService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDatosTiendaPM.label', default: 'SqtDatosTiendaPM'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDatosTiendaPM.label', default: 'SqtDatosTiendaPM'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
