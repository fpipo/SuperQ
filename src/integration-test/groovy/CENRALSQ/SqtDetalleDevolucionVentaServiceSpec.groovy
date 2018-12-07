package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleDevolucionVentaServiceSpec extends Specification {

    SqtDetalleDevolucionVentaService sqtDetalleDevolucionVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleDevolucionVenta(...).save(flush: true, failOnError: true)
        //new SqtDetalleDevolucionVenta(...).save(flush: true, failOnError: true)
        //SqtDetalleDevolucionVenta sqtDetalleDevolucionVenta = new SqtDetalleDevolucionVenta(...).save(flush: true, failOnError: true)
        //new SqtDetalleDevolucionVenta(...).save(flush: true, failOnError: true)
        //new SqtDetalleDevolucionVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleDevolucionVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleDevolucionVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleDevolucionVenta> sqtDetalleDevolucionVentaList = sqtDetalleDevolucionVentaService.list(max: 2, offset: 2)

        then:
        sqtDetalleDevolucionVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleDevolucionVentaService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleDevolucionVentaId = setupData()

        expect:
        sqtDetalleDevolucionVentaService.count() == 5

        when:
        sqtDetalleDevolucionVentaService.delete(sqtDetalleDevolucionVentaId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleDevolucionVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleDevolucionVenta sqtDetalleDevolucionVenta = new SqtDetalleDevolucionVenta()
        sqtDetalleDevolucionVentaService.save(sqtDetalleDevolucionVenta)

        then:
        sqtDetalleDevolucionVenta.id != null
    }
}
