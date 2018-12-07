package CENTRALSQ

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SqtVoucherController {

    SqtVoucherService sqtVoucherService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sqtVoucherService.list(params), model:[sqtVoucherCount: sqtVoucherService.count()]
    }

    def show(Long id) {
        respond sqtVoucherService.get(id)
    }

    def create() {
        respond new SqtVoucher(params)
    }

    def save(SqtVoucher sqtVoucher) {
        if (sqtVoucher == null) {
            notFound()
            return
        }

        try {
            sqtVoucherService.save(sqtVoucher)
        } catch (ValidationException e) {
            respond sqtVoucher.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sqtVoucher.label', default: 'SqtVoucher'), sqtVoucher.id])
                redirect sqtVoucher
            }
            '*' { respond sqtVoucher, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sqtVoucherService.get(id)
    }

    def update(SqtVoucher sqtVoucher) {
        if (sqtVoucher == null) {
            notFound()
            return
        }

        try {
            sqtVoucherService.save(sqtVoucher)
        } catch (ValidationException e) {
            respond sqtVoucher.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sqtVoucher.label', default: 'SqtVoucher'), sqtVoucher.id])
                redirect sqtVoucher
            }
            '*'{ respond sqtVoucher, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sqtVoucherService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sqtVoucher.label', default: 'SqtVoucher'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sqtVoucher.label', default: 'SqtVoucher'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
