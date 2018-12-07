package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtVoucherServiceSpec extends Specification {

    SqtVoucherService sqtVoucherService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtVoucher(...).save(flush: true, failOnError: true)
        //new SqtVoucher(...).save(flush: true, failOnError: true)
        //SqtVoucher sqtVoucher = new SqtVoucher(...).save(flush: true, failOnError: true)
        //new SqtVoucher(...).save(flush: true, failOnError: true)
        //new SqtVoucher(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtVoucher.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtVoucherService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtVoucher> sqtVoucherList = sqtVoucherService.list(max: 2, offset: 2)

        then:
        sqtVoucherList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtVoucherService.count() == 5
    }

    void "test delete"() {
        Long sqtVoucherId = setupData()

        expect:
        sqtVoucherService.count() == 5

        when:
        sqtVoucherService.delete(sqtVoucherId)
        sessionFactory.currentSession.flush()

        then:
        sqtVoucherService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtVoucher sqtVoucher = new SqtVoucher()
        sqtVoucherService.save(sqtVoucher)

        then:
        sqtVoucher.id != null
    }
}
