package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtProveedorGrupoTiendaController {

    SqtProveedorGrupoTiendaService sqtProveedorGrupoTiendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtProveedorGrupoTiendaService.list(params), model:[sqtProveedorGrupoTiendaCount: sqtProveedorGrupoTiendaService.count()]
    }

    def show(Long id) {
        respond sqtProveedorGrupoTiendaService.get(id)
    }

    def create() {
        respond new SqtProveedorGrupoTienda(params)
    }

    def save(SqtProveedorGrupoTienda sqtProveedorGrupoTienda) {
        if (sqtProveedorGrupoTienda == null) {
            notFound()
            return
        }

        try {
            sqtProveedorGrupoTiendaService.save(sqtProveedorGrupoTienda)
        } catch (ValidationException e) {
            respond sqtProveedorGrupoTienda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtProveedorGrupoTienda.label', default: 'SqtProveedorGrupoTienda'), sqtProveedorGrupoTienda.id])
                redirect sqtProveedorGrupoTienda
            }
            '*' { respond sqtProveedorGrupoTienda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtProveedorGrupoTiendaService.get(id)
    }

    def update(SqtProveedorGrupoTienda sqtProveedorGrupoTienda) {
        if (sqtProveedorGrupoTienda == null) {
            notFound()
            return
        }

        try {
            sqtProveedorGrupoTiendaService.save(sqtProveedorGrupoTienda)
        } catch (ValidationException e) {
            respond sqtProveedorGrupoTienda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtProveedorGrupoTienda.label', default: 'SqtProveedorGrupoTienda'), sqtProveedorGrupoTienda.id])
                redirect sqtProveedorGrupoTienda
            }
            '*'{ respond sqtProveedorGrupoTienda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtProveedorGrupoTiendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtProveedorGrupoTienda.label', default: 'SqtProveedorGrupoTienda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtProveedorGrupoTienda.label', default: 'SqtProveedorGrupoTienda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
