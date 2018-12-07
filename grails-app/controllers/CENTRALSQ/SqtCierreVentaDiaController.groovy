package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCierreVentaDiaController {

    SqtCierreVentaDiaService sqtCierreVentaDiaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCierreVentaDiaService.list(params), model:[sqtCierreVentaDiaCount: sqtCierreVentaDiaService.count()]
    }

    def show(Long id) {
        respond sqtCierreVentaDiaService.get(id)
    }

    def create() {
        respond new SqtCierreVentaDia(params)
    }

    def save(SqtCierreVentaDia sqtCierreVentaDia) {
        if (sqtCierreVentaDia == null) {
            notFound()
            return
        }

        try {
            sqtCierreVentaDiaService.save(sqtCierreVentaDia)
        } catch (ValidationException e) {
            respond sqtCierreVentaDia.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCierreVentaDia.label', default: 'SqtCierreVentaDia'), sqtCierreVentaDia.id])
                redirect sqtCierreVentaDia
            }
            '*' { respond sqtCierreVentaDia, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCierreVentaDiaService.get(id)
    }

    def update(SqtCierreVentaDia sqtCierreVentaDia) {
        if (sqtCierreVentaDia == null) {
            notFound()
            return
        }

        try {
            sqtCierreVentaDiaService.save(sqtCierreVentaDia)
        } catch (ValidationException e) {
            respond sqtCierreVentaDia.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCierreVentaDia.label', default: 'SqtCierreVentaDia'), sqtCierreVentaDia.id])
                redirect sqtCierreVentaDia
            }
            '*'{ respond sqtCierreVentaDia, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCierreVentaDiaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCierreVentaDia.label', default: 'SqtCierreVentaDia'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCierreVentaDia.label', default: 'SqtCierreVentaDia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
