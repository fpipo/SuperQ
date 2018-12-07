package CENRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtAjusteProductoController {

    SqtAjusteProductoService sqtAjusteProductoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtAjusteProductoService.list(params), model:[sqtAjusteProductoCount: sqtAjusteProductoService.count()]
    }

    def show(Long id) {
        respond sqtAjusteProductoService.get(id)
    }

    def create() {
        respond new SqtAjusteProducto(params)
    }

    def save(SqtAjusteProducto sqtAjusteProducto) {
        if (sqtAjusteProducto == null) {
            notFound()
            return
        }

        try {
            sqtAjusteProductoService.save(sqtAjusteProducto)
        } catch (ValidationException e) {
            respond sqtAjusteProducto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtAjusteProducto.label', default: 'SqtAjusteProducto'), sqtAjusteProducto.id])
                redirect sqtAjusteProducto
            }
            '*' { respond sqtAjusteProducto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtAjusteProductoService.get(id)
    }

    def update(SqtAjusteProducto sqtAjusteProducto) {
        if (sqtAjusteProducto == null) {
            notFound()
            return
        }

        try {
            sqtAjusteProductoService.save(sqtAjusteProducto)
        } catch (ValidationException e) {
            respond sqtAjusteProducto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtAjusteProducto.label', default: 'SqtAjusteProducto'), sqtAjusteProducto.id])
                redirect sqtAjusteProducto
            }
            '*'{ respond sqtAjusteProducto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtAjusteProductoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtAjusteProducto.label', default: 'SqtAjusteProducto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtAjusteProducto.label', default: 'SqtAjusteProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
