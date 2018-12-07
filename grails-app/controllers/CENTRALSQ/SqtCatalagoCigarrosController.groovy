package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtCatalagoCigarrosController {

    SqtCatalagoCigarrosService sqtCatalagoCigarrosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtCatalagoCigarrosService.list(params), model:[sqtCatalagoCigarrosCount: sqtCatalagoCigarrosService.count()]
    }

    def show(Long id) {
        respond sqtCatalagoCigarrosService.get(id)
    }

    def create() {
        respond new SqtCatalagoCigarros(params)
    }

    def save(SqtCatalagoCigarros sqtCatalagoCigarros) {
        if (sqtCatalagoCigarros == null) {
            notFound()
            return
        }

        try {
            sqtCatalagoCigarrosService.save(sqtCatalagoCigarros)
        } catch (ValidationException e) {
            respond sqtCatalagoCigarros.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtCatalagoCigarros.label', default: 'SqtCatalagoCigarros'), sqtCatalagoCigarros.id])
                redirect sqtCatalagoCigarros
            }
            '*' { respond sqtCatalagoCigarros, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtCatalagoCigarrosService.get(id)
    }

    def update(SqtCatalagoCigarros sqtCatalagoCigarros) {
        if (sqtCatalagoCigarros == null) {
            notFound()
            return
        }

        try {
            sqtCatalagoCigarrosService.save(sqtCatalagoCigarros)
        } catch (ValidationException e) {
            respond sqtCatalagoCigarros.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtCatalagoCigarros.label', default: 'SqtCatalagoCigarros'), sqtCatalagoCigarros.id])
                redirect sqtCatalagoCigarros
            }
            '*'{ respond sqtCatalagoCigarros, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtCatalagoCigarrosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtCatalagoCigarros.label', default: 'SqtCatalagoCigarros'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtCatalagoCigarros.label', default: 'SqtCatalagoCigarros'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
