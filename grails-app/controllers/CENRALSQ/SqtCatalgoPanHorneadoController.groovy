package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCatalgoPanHorneadoController {

    SqtCatalgoPanHorneadoService sqtCatalgoPanHorneadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCatalgoPanHorneadoService.list(params), model:[sqtCatalgoPanHorneadoCount: sqtCatalgoPanHorneadoService.count()]
    }

    def show(Long id) {
        respond sqtCatalgoPanHorneadoService.get(id)
    }

    def create() {
        respond new SqtCatalgoPanHorneado(params)
    }

    def save(SqtCatalgoPanHorneado sqtCatalgoPanHorneado) {
        if (sqtCatalgoPanHorneado == null) {
            notFound()
            return
        }

        try {
            sqtCatalgoPanHorneadoService.save(sqtCatalgoPanHorneado)
        } catch (ValidationException e) {
            respond sqtCatalgoPanHorneado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCatalgoPanHorneado.label', default: 'SqtCatalgoPanHorneado'), sqtCatalgoPanHorneado.id])
                redirect sqtCatalgoPanHorneado
            }
            '*' { respond sqtCatalgoPanHorneado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCatalgoPanHorneadoService.get(id)
    }

    def update(SqtCatalgoPanHorneado sqtCatalgoPanHorneado) {
        if (sqtCatalgoPanHorneado == null) {
            notFound()
            return
        }

        try {
            sqtCatalgoPanHorneadoService.save(sqtCatalgoPanHorneado)
        } catch (ValidationException e) {
            respond sqtCatalgoPanHorneado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCatalgoPanHorneado.label', default: 'SqtCatalgoPanHorneado'), sqtCatalgoPanHorneado.id])
                redirect sqtCatalgoPanHorneado
            }
            '*'{ respond sqtCatalgoPanHorneado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCatalgoPanHorneadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCatalgoPanHorneado.label', default: 'SqtCatalgoPanHorneado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCatalgoPanHorneado.label', default: 'SqtCatalgoPanHorneado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
