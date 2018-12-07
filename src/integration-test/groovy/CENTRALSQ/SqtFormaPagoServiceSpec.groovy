package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtFormaPagoServiceSpec extends Specification {

    SqtFormaPagoService sqtFormaPagoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtFormaPago(...).save(flush: true, failOnError: true)
        //new SqtFormaPago(...).save(flush: true, failOnError: true)
        //SqtFormaPago sqtFormaPago = new SqtFormaPago(...).save(flush: true, failOnError: true)
        //new SqtFormaPago(...).save(flush: true, failOnError: true)
        //new SqtFormaPago(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtFormaPago.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtFormaPagoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtFormaPago> sqtFormaPagoList = sqtFormaPagoService.list(max: 2, offset: 2)

        then:
        sqtFormaPagoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtFormaPagoService.count() == 5
    }

    void "test delete"() {
        Long sqtFormaPagoId = setupData()

        expect:
        sqtFormaPagoService.count() == 5

        when:
        sqtFormaPagoService.delete(sqtFormaPagoId)
        sessionFactory.currentSession.flush()

        then:
        sqtFormaPagoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtFormaPago sqtFormaPago = new SqtFormaPago()
        sqtFormaPagoService.save(sqtFormaPago)

        then:
        sqtFormaPago.id != null
    }
}
