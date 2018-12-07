package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleFacturaServiceSpec extends Specification {

    SqtDetalleFacturaService sqtDetalleFacturaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleFactura(...).save(flush: true, failOnError: true)
        //new SqtDetalleFactura(...).save(flush: true, failOnError: true)
        //SqtDetalleFactura sqtDetalleFactura = new SqtDetalleFactura(...).save(flush: true, failOnError: true)
        //new SqtDetalleFactura(...).save(flush: true, failOnError: true)
        //new SqtDetalleFactura(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleFactura.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleFacturaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleFactura> sqtDetalleFacturaList = sqtDetalleFacturaService.list(max: 2, offset: 2)

        then:
        sqtDetalleFacturaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleFacturaService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleFacturaId = setupData()

        expect:
        sqtDetalleFacturaService.count() == 5

        when:
        sqtDetalleFacturaService.delete(sqtDetalleFacturaId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleFacturaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleFactura sqtDetalleFactura = new SqtDetalleFactura()
        sqtDetalleFacturaService.save(sqtDetalleFactura)

        then:
        sqtDetalleFactura.id != null
    }
}
