package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtPolizaExpLogController {

    SqtPolizaExpLogService sqtPolizaExpLogService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtPolizaExpLogService.list(params), model:[sqtPolizaExpLogCount: sqtPolizaExpLogService.count()]
    }

    def show(Long id) {
        respond sqtPolizaExpLogService.get(id)
    }

    def create() {
        respond new SqtPolizaExpLog(params)
    }

    def save(SqtPolizaExpLog sqtPolizaExpLog) {
        if (sqtPolizaExpLog == null) {
            notFound()
            return
        }

        try {
            sqtPolizaExpLogService.save(sqtPolizaExpLog)
        } catch (ValidationException e) {
            respond sqtPolizaExpLog.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtPolizaExpLog.label', default: 'SqtPolizaExpLog'), sqtPolizaExpLog.id])
                redirect sqtPolizaExpLog
            }
            '*' { respond sqtPolizaExpLog, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtPolizaExpLogService.get(id)
    }

    def update(SqtPolizaExpLog sqtPolizaExpLog) {
        if (sqtPolizaExpLog == null) {
            notFound()
            return
        }

        try {
            sqtPolizaExpLogService.save(sqtPolizaExpLog)
        } catch (ValidationException e) {
            respond sqtPolizaExpLog.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtPolizaExpLog.label', default: 'SqtPolizaExpLog'), sqtPolizaExpLog.id])
                redirect sqtPolizaExpLog
            }
            '*'{ respond sqtPolizaExpLog, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtPolizaExpLogService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtPolizaExpLog.label', default: 'SqtPolizaExpLog'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtPolizaExpLog.label', default: 'SqtPolizaExpLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
