package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPagoTipoVentaServiceSpec extends Specification {

    SqtPagoTipoVentaService sqtPagoTipoVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPagoTipoVenta(...).save(flush: true, failOnError: true)
        //new SqtPagoTipoVenta(...).save(flush: true, failOnError: true)
        //SqtPagoTipoVenta sqtPagoTipoVenta = new SqtPagoTipoVenta(...).save(flush: true, failOnError: true)
        //new SqtPagoTipoVenta(...).save(flush: true, failOnError: true)
        //new SqtPagoTipoVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPagoTipoVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPagoTipoVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPagoTipoVenta> sqtPagoTipoVentaList = sqtPagoTipoVentaService.list(max: 2, offset: 2)

        then:
        sqtPagoTipoVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPagoTipoVentaService.count() == 5
    }

    void "test delete"() {
        Long sqtPagoTipoVentaId = setupData()

        expect:
        sqtPagoTipoVentaService.count() == 5

        when:
        sqtPagoTipoVentaService.delete(sqtPagoTipoVentaId)
        sessionFactory.currentSession.flush()

        then:
        sqtPagoTipoVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPagoTipoVenta sqtPagoTipoVenta = new SqtPagoTipoVenta()
        sqtPagoTipoVentaService.save(sqtPagoTipoVenta)

        then:
        sqtPagoTipoVenta.id != null
    }
}
