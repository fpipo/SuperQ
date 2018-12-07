package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCondicionPagoServiceSpec extends Specification {

    SqtCondicionPagoService sqtCondicionPagoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCondicionPago(...).save(flush: true, failOnError: true)
        //new SqtCondicionPago(...).save(flush: true, failOnError: true)
        //SqtCondicionPago sqtCondicionPago = new SqtCondicionPago(...).save(flush: true, failOnError: true)
        //new SqtCondicionPago(...).save(flush: true, failOnError: true)
        //new SqtCondicionPago(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCondicionPago.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCondicionPagoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCondicionPago> sqtCondicionPagoList = sqtCondicionPagoService.list(max: 2, offset: 2)

        then:
        sqtCondicionPagoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCondicionPagoService.count() == 5
    }

    void "test delete"() {
        Long sqtCondicionPagoId = setupData()

        expect:
        sqtCondicionPagoService.count() == 5

        when:
        sqtCondicionPagoService.delete(sqtCondicionPagoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCondicionPagoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCondicionPago sqtCondicionPago = new SqtCondicionPago()
        sqtCondicionPagoService.save(sqtCondicionPago)

        then:
        sqtCondicionPago.id != null
    }
}
