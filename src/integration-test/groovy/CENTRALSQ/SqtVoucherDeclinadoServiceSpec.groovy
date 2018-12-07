package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtVoucherDeclinadoServiceSpec extends Specification {

    SqtVoucherDeclinadoService sqtVoucherDeclinadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtVoucherDeclinado(...).save(flush: true, failOnError: true)
        //new SqtVoucherDeclinado(...).save(flush: true, failOnError: true)
        //SqtVoucherDeclinado sqtVoucherDeclinado = new SqtVoucherDeclinado(...).save(flush: true, failOnError: true)
        //new SqtVoucherDeclinado(...).save(flush: true, failOnError: true)
        //new SqtVoucherDeclinado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtVoucherDeclinado.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtVoucherDeclinadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtVoucherDeclinado> sqtVoucherDeclinadoList = sqtVoucherDeclinadoService.list(max: 2, offset: 2)

        then:
        sqtVoucherDeclinadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtVoucherDeclinadoService.count() == 5
    }

    void "test delete"() {
        Long sqtVoucherDeclinadoId = setupData()

        expect:
        sqtVoucherDeclinadoService.count() == 5

        when:
        sqtVoucherDeclinadoService.delete(sqtVoucherDeclinadoId)
        sessionFactory.currentSession.flush()

        then:
        sqtVoucherDeclinadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtVoucherDeclinado sqtVoucherDeclinado = new SqtVoucherDeclinado()
        sqtVoucherDeclinadoService.save(sqtVoucherDeclinado)

        then:
        sqtVoucherDeclinado.id != null
    }
}
