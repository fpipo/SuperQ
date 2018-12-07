package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtVentaServiceSpec extends Specification {

    SqtVentaService sqtVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtVenta(...).save(flush: true, failOnError: true)
        //new SqtVenta(...).save(flush: true, failOnError: true)
        //SqtVenta sqtVenta = new SqtVenta(...).save(flush: true, failOnError: true)
        //new SqtVenta(...).save(flush: true, failOnError: true)
        //new SqtVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtVenta> sqtVentaList = sqtVentaService.list(max: 2, offset: 2)

        then:
        sqtVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtVentaService.count() == 5
    }

    void "test delete"() {
        Long sqtVentaId = setupData()

        expect:
        sqtVentaService.count() == 5

        when:
        sqtVentaService.delete(sqtVentaId)
        sessionFactory.currentSession.flush()

        then:
        sqtVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtVenta sqtVenta = new SqtVenta()
        sqtVentaService.save(sqtVenta)

        then:
        sqtVenta.id != null
    }
}
