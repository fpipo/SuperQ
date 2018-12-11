package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCatalogoPanHorneadoController {

    SqtCatalogoPanHorneadoService sqtCatalogoPanHorneadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCatalogoPanHorneadoService.list(params), model:[sqtCatalogoPanHorneadoCount: sqtCatalogoPanHorneadoService.count()]
    }

    def show(Long id) {
        respond sqtCatalogoPanHorneadoService.get(id)
    }

    def create() {
        respond new SqtCatalogoPanHorneado(params)
    }

    def save(SqtCatalogoPanHorneado sqtCatalogoPanHorneado) {
        if (sqtCatalogoPanHorneado == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoPanHorneadoService.save(sqtCatalogoPanHorneado)
        } catch (ValidationException e) {
            respond sqtCatalogoPanHorneado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCatalogoPanHorneado.label', default: 'SqtCatalogoPanHorneado'), sqtCatalogoPanHorneado.id])
                redirect sqtCatalogoPanHorneado
            }
            '*' { respond sqtCatalogoPanHorneado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCatalogoPanHorneadoService.get(id)
    }

    def update(SqtCatalogoPanHorneado sqtCatalogoPanHorneado) {
        if (sqtCatalogoPanHorneado == null) {
            notFound()
            return
        }

        try {
            sqtCatalogoPanHorneadoService.save(sqtCatalogoPanHorneado)
        } catch (ValidationException e) {
            respond sqtCatalogoPanHorneado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCatalogoPanHorneado.label', default: 'SqtCatalogoPanHorneado'), sqtCatalogoPanHorneado.id])
                redirect sqtCatalogoPanHorneado
            }
            '*'{ respond sqtCatalogoPanHorneado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCatalogoPanHorneadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCatalogoPanHorneado.label', default: 'SqtCatalogoPanHorneado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCatalogoPanHorneado.label', default: 'SqtCatalogoPanHorneado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
