package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtGrupoTiendaController {

    SqtGrupoTiendaService sqtGrupoTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtGrupoTiendaService.list(params), model:[sqtGrupoTiendaCount: sqtGrupoTiendaService.count()]
    }

    def show(Long id) {
        respond sqtGrupoTiendaService.get(id)
    }

    def create() {
        respond new SqtGrupoTienda(params)
    }

    def save(SqtGrupoTienda sqtGrupoTienda) {
        if (sqtGrupoTienda == null) {
            notFound()
            return
        }

        try {
            sqtGrupoTiendaService.save(sqtGrupoTienda)
        } catch (ValidationException e) {
            respond sqtGrupoTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtGrupoTienda.label', default: 'SqtGrupoTienda'), sqtGrupoTienda.id])
                redirect sqtGrupoTienda
            }
            '*' { respond sqtGrupoTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtGrupoTiendaService.get(id)
    }

    def update(SqtGrupoTienda sqtGrupoTienda) {
        if (sqtGrupoTienda == null) {
            notFound()
            return
        }

        try {
            sqtGrupoTiendaService.save(sqtGrupoTienda)
        } catch (ValidationException e) {
            respond sqtGrupoTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtGrupoTienda.label', default: 'SqtGrupoTienda'), sqtGrupoTienda.id])
                redirect sqtGrupoTienda
            }
            '*'{ respond sqtGrupoTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtGrupoTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtGrupoTienda.label', default: 'SqtGrupoTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtGrupoTienda.label', default: 'SqtGrupoTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
