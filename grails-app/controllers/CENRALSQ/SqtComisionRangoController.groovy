package CENRALSQ

import static org.springframework.http.HttpStatus.*
import org.springframework.transaction.TransactionStatus

class SqtComisionRangoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        SqtComisionRango.async.task {
            [sqtComisionRangoList: list(params), count: count() ]
        }.then { result ->
            respond result.sqtComisionRangoList, model:[sqtComisionRangoCount: result.count]
        }
    }

    def show(Long id) {
        SqtComisionRango.async.get(id).then { sqtComisionRango ->
            respond sqtComisionRango
        }
    }

    def create() {
        respond new SqtComisionRango(params)
    }

    def save(SqtComisionRango sqtComisionRango) {
        SqtComisionRango.async.withTransaction { TransactionStatus status ->
            if (sqtComisionRango == null) {
                status.setRollbackOnly()
                notFound()
                return
            }

            if(sqtComisionRango.hasErrors()) {
                status.setRollbackOnly()
                respond sqtComisionRango.errors, view:'create' // STATUS CODE 422
                return
            }

            sqtComisionRango.save flush:true
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'sqtComisionRango.label', default: 'SqtComisionRango'), sqtComisionRango.id])
                    redirect sqtComisionRango
                }
                '*' { respond sqtComisionRango, [status: CREATED] }
            }
        }
    }

    def edit(Long id) {
        SqtComisionRango.async.get(id).then { sqtComisionRango ->
            respond sqtComisionRango
        }
    }

    def update(Long id) {
        SqtComisionRango.async.withTransaction { TransactionStatus status ->
            def sqtComisionRango = SqtComisionRango.get(id)
            if (sqtComisionRango == null) {
                status.setRollbackOnly()
                notFound()
                return
            }

            sqtComisionRango.properties = params
            if( !sqtComisionRango.save(flush:true) ) {
                status.setRollbackOnly()
                respond sqtComisionRango.errors, view:'edit' // STATUS CODE 422
                return
            }

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: 'SqtComisionRango.label', default: 'SqtComisionRango'), sqtComisionRango.id])
                    redirect sqtComisionRango
                }
                '*'{ respond sqtComisionRango, [status: OK] }
            }
        }
    }

    def delete(Long id) {
        SqtComisionRango.async.withTransaction { TransactionStatus status ->
            def sqtComisionRango = SqtComisionRango.get(id)
            if (sqtComisionRango == null) {
                status.setRollbackOnly()
                notFound()
                return
            }

            sqtComisionRango.delete flush:true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'SqtComisionRango.label', default: 'SqtComisionRango'), sqtComisionRango.id])
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtComisionRango.label', default: 'SqtComisionRango'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}