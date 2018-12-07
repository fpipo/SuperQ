package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTiendaTipoVentaServiceSpec extends Specification {

    SqtTiendaTipoVentaService sqtTiendaTipoVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTiendaTipoVenta(...).save(flush: true, failOnError: true)
        //new SqtTiendaTipoVenta(...).save(flush: true, failOnError: true)
        //SqtTiendaTipoVenta sqtTiendaTipoVenta = new SqtTiendaTipoVenta(...).save(flush: true, failOnError: true)
        //new SqtTiendaTipoVenta(...).save(flush: true, failOnError: true)
        //new SqtTiendaTipoVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTiendaTipoVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTiendaTipoVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTiendaTipoVenta> sqtTiendaTipoVentaList = sqtTiendaTipoVentaService.list(max: 2, offset: 2)

        then:
        sqtTiendaTipoVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTiendaTipoVentaService.count() == 5
    }

    void "test delete"() {
        Long sqtTiendaTipoVentaId = setupData()

        expect:
        sqtTiendaTipoVentaService.count() == 5

        when:
        sqtTiendaTipoVentaService.delete(sqtTiendaTipoVentaId)
        sessionFactory.currentSession.flush()

        then:
        sqtTiendaTipoVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTiendaTipoVenta sqtTiendaTipoVenta = new SqtTiendaTipoVenta()
        sqtTiendaTipoVentaService.save(sqtTiendaTipoVenta)

        then:
        sqtTiendaTipoVenta.id != null
    }
}
