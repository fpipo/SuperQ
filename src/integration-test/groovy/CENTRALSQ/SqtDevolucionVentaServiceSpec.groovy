package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDevolucionVentaServiceSpec extends Specification {

    SqtDevolucionVentaService sqtDevolucionVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDevolucionVenta(...).save(flush: true, failOnError: true)
        //new SqtDevolucionVenta(...).save(flush: true, failOnError: true)
        //SqtDevolucionVenta sqtDevolucionVenta = new SqtDevolucionVenta(...).save(flush: true, failOnError: true)
        //new SqtDevolucionVenta(...).save(flush: true, failOnError: true)
        //new SqtDevolucionVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDevolucionVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDevolucionVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDevolucionVenta> sqtDevolucionVentaList = sqtDevolucionVentaService.list(max: 2, offset: 2)

        then:
        sqtDevolucionVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDevolucionVentaService.count() == 5
    }

    void "test delete"() {
        Long sqtDevolucionVentaId = setupData()

        expect:
        sqtDevolucionVentaService.count() == 5

        when:
        sqtDevolucionVentaService.delete(sqtDevolucionVentaId)
        sessionFactory.currentSession.flush()

        then:
        sqtDevolucionVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDevolucionVenta sqtDevolucionVenta = new SqtDevolucionVenta()
        sqtDevolucionVentaService.save(sqtDevolucionVenta)

        then:
        sqtDevolucionVenta.id != null
    }
}
