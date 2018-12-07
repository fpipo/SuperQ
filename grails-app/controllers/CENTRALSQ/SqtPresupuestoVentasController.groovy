package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPresupuestoVentasController {

    SqtPresupuestoVentasService sqtPresupuestoVentasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPresupuestoVentasService.list(params), model:[sqtPresupuestoVentasCount: sqtPresupuestoVentasService.count()]
    }

    def show(Long id) {
        respond sqtPresupuestoVentasService.get(id)
    }

    def create() {
        respond new SqtPresupuestoVentas(params)
    }

    def save(SqtPresupuestoVentas sqtPresupuestoVentas) {
        if (sqtPresupuestoVentas == null) {
            notFound()
            return
        }

        try {
            sqtPresupuestoVentasService.save(sqtPresupuestoVentas)
        } catch (ValidationException e) {
            respond sqtPresupuestoVentas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPresupuestoVentas.label', default: 'SqtPresupuestoVentas'), sqtPresupuestoVentas.id])
                redirect sqtPresupuestoVentas
            }
            '*' { respond sqtPresupuestoVentas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPresupuestoVentasService.get(id)
    }

    def update(SqtPresupuestoVentas sqtPresupuestoVentas) {
        if (sqtPresupuestoVentas == null) {
            notFound()
            return
        }

        try {
            sqtPresupuestoVentasService.save(sqtPresupuestoVentas)
        } catch (ValidationException e) {
            respond sqtPresupuestoVentas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPresupuestoVentas.label', default: 'SqtPresupuestoVentas'), sqtPresupuestoVentas.id])
                redirect sqtPresupuestoVentas
            }
            '*'{ respond sqtPresupuestoVentas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPresupuestoVentasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPresupuestoVentas.label', default: 'SqtPresupuestoVentas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPresupuestoVentas.label', default: 'SqtPresupuestoVentas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
