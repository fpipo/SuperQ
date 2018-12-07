package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPagoVentaServiceSpec extends Specification {

    SqtPagoVentaService sqtPagoVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPagoVenta(...).save(flush: true, failOnError: true)
        //new SqtPagoVenta(...).save(flush: true, failOnError: true)
        //SqtPagoVenta sqtPagoVenta = new SqtPagoVenta(...).save(flush: true, failOnError: true)
        //new SqtPagoVenta(...).save(flush: true, failOnError: true)
        //new SqtPagoVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPagoVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPagoVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPagoVenta> sqtPagoVentaList = sqtPagoVentaService.list(max: 2, offset: 2)

        then:
        sqtPagoVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPagoVentaService.count() == 5
    }

    void "test delete"() {
        Long sqtPagoVentaId = setupData()

        expect:
        sqtPagoVentaService.count() == 5

        when:
        sqtPagoVentaService.delete(sqtPagoVentaId)
        sessionFactory.currentSession.flush()

        then:
        sqtPagoVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPagoVenta sqtPagoVenta = new SqtPagoVenta()
        sqtPagoVentaService.save(sqtPagoVenta)

        then:
        sqtPagoVenta.id != null
    }
}
