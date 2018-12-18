package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtFormaPagoSatServiceSpec extends Specification {

    SqtFormaPagoSatService sqtFormaPagoSatService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtFormaPagoSat(...).save(flush: true, failOnError: true)
        //new SqtFormaPagoSat(...).save(flush: true, failOnError: true)
        //SqtFormaPagoSat sqtFormaPagoSat = new SqtFormaPagoSat(...).save(flush: true, failOnError: true)
        //new SqtFormaPagoSat(...).save(flush: true, failOnError: true)
        //new SqtFormaPagoSat(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtFormaPagoSat.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtFormaPagoSatService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtFormaPagoSat> sqtFormaPagoSatList = sqtFormaPagoSatService.list(max: 2, offset: 2)

        then:
        sqtFormaPagoSatList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtFormaPagoSatService.count() == 5
    }

    void "test delete"() {
        Long sqtFormaPagoSatId = setupData()

        expect:
        sqtFormaPagoSatService.count() == 5

        when:
        sqtFormaPagoSatService.delete(sqtFormaPagoSatId)
        sessionFactory.currentSession.flush()

        then:
        sqtFormaPagoSatService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtFormaPagoSat sqtFormaPagoSat = new SqtFormaPagoSat()
        sqtFormaPagoSatService.save(sqtFormaPagoSat)

        then:
        sqtFormaPagoSat.id != null
    }
}
