package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtOperacionBanamexController {

    SqtOperacionBanamexService sqtOperacionBanamexService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtOperacionBanamexService.list(params), model:[sqtOperacionBanamexCount: sqtOperacionBanamexService.count()]
    }

    def show(Long id) {
        respond sqtOperacionBanamexService.get(id)
    }

    def create() {
        respond new SqtOperacionBanamex(params)
    }

    def save(SqtOperacionBanamex sqtOperacionBanamex) {
        if (sqtOperacionBanamex == null) {
            notFound()
            return
        }

        try {
            sqtOperacionBanamexService.save(sqtOperacionBanamex)
        } catch (ValidationException e) {
            respond sqtOperacionBanamex.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtOperacionBanamex.label', default: 'SqtOperacionBanamex'), sqtOperacionBanamex.id])
                redirect sqtOperacionBanamex
            }
            '*' { respond sqtOperacionBanamex, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtOperacionBanamexService.get(id)
    }

    def update(SqtOperacionBanamex sqtOperacionBanamex) {
        if (sqtOperacionBanamex == null) {
            notFound()
            return
        }

        try {
            sqtOperacionBanamexService.save(sqtOperacionBanamex)
        } catch (ValidationException e) {
            respond sqtOperacionBanamex.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtOperacionBanamex.label', default: 'SqtOperacionBanamex'), sqtOperacionBanamex.id])
                redirect sqtOperacionBanamex
            }
            '*'{ respond sqtOperacionBanamex, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtOperacionBanamexService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtOperacionBanamex.label', default: 'SqtOperacionBanamex'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtOperacionBanamex.label', default: 'SqtOperacionBanamex'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
