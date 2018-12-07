package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtDatosTiendaCierrePmController {

    SqtDatosTiendaCierrePmService sqtDatosTiendaCierrePmService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtDatosTiendaCierrePmService.list(params), model:[sqtDatosTiendaCierrePmCount: sqtDatosTiendaCierrePmService.count()]
    }

    def show(Long id) {
        respond sqtDatosTiendaCierrePmService.get(id)
    }

    def create() {
        respond new SqtDatosTiendaCierrePm(params)
    }

    def save(SqtDatosTiendaCierrePm sqtDatosTiendaCierrePm) {
        if (sqtDatosTiendaCierrePm == null) {
            notFound()
            return
        }

        try {
            sqtDatosTiendaCierrePmService.save(sqtDatosTiendaCierrePm)
        } catch (ValidationException e) {
            respond sqtDatosTiendaCierrePm.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtDatosTiendaCierrePm.label', default: 'SqtDatosTiendaCierrePm'), sqtDatosTiendaCierrePm.id])
                redirect sqtDatosTiendaCierrePm
            }
            '*' { respond sqtDatosTiendaCierrePm, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtDatosTiendaCierrePmService.get(id)
    }

    def update(SqtDatosTiendaCierrePm sqtDatosTiendaCierrePm) {
        if (sqtDatosTiendaCierrePm == null) {
            notFound()
            return
        }

        try {
            sqtDatosTiendaCierrePmService.save(sqtDatosTiendaCierrePm)
        } catch (ValidationException e) {
            respond sqtDatosTiendaCierrePm.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtDatosTiendaCierrePm.label', default: 'SqtDatosTiendaCierrePm'), sqtDatosTiendaCierrePm.id])
                redirect sqtDatosTiendaCierrePm
            }
            '*'{ respond sqtDatosTiendaCierrePm, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtDatosTiendaCierrePmService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtDatosTiendaCierrePm.label', default: 'SqtDatosTiendaCierrePm'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtDatosTiendaCierrePm.label', default: 'SqtDatosTiendaCierrePm'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
