package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtReembolsoFormaPagoServiceSpec extends Specification {

    SqtReembolsoFormaPagoService sqtReembolsoFormaPagoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtReembolsoFormaPago(...).save(flush: true, failOnError: true)
        //new SqtReembolsoFormaPago(...).save(flush: true, failOnError: true)
        //SqtReembolsoFormaPago sqtReembolsoFormaPago = new SqtReembolsoFormaPago(...).save(flush: true, failOnError: true)
        //new SqtReembolsoFormaPago(...).save(flush: true, failOnError: true)
        //new SqtReembolsoFormaPago(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtReembolsoFormaPago.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtReembolsoFormaPagoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtReembolsoFormaPago> sqtReembolsoFormaPagoList = sqtReembolsoFormaPagoService.list(max: 2, offset: 2)

        then:
        sqtReembolsoFormaPagoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtReembolsoFormaPagoService.count() == 5
    }

    void "test delete"() {
        Long sqtReembolsoFormaPagoId = setupData()

        expect:
        sqtReembolsoFormaPagoService.count() == 5

        when:
        sqtReembolsoFormaPagoService.delete(sqtReembolsoFormaPagoId)
        sessionFactory.currentSession.flush()

        then:
        sqtReembolsoFormaPagoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtReembolsoFormaPago sqtReembolsoFormaPago = new SqtReembolsoFormaPago()
        sqtReembolsoFormaPagoService.save(sqtReembolsoFormaPago)

        then:
        sqtReembolsoFormaPago.id != null
    }
}
