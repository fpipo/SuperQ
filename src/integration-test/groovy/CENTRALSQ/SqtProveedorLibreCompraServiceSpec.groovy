package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProveedorLibreCompraServiceSpec extends Specification {

    SqtProveedorLibreCompraService sqtProveedorLibreCompraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProveedorLibreCompra(...).save(flush: true, failOnError: true)
        //new SqtProveedorLibreCompra(...).save(flush: true, failOnError: true)
        //SqtProveedorLibreCompra sqtProveedorLibreCompra = new SqtProveedorLibreCompra(...).save(flush: true, failOnError: true)
        //new SqtProveedorLibreCompra(...).save(flush: true, failOnError: true)
        //new SqtProveedorLibreCompra(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProveedorLibreCompra.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProveedorLibreCompraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProveedorLibreCompra> sqtProveedorLibreCompraList = sqtProveedorLibreCompraService.list(max: 2, offset: 2)

        then:
        sqtProveedorLibreCompraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProveedorLibreCompraService.count() == 5
    }

    void "test delete"() {
        Long sqtProveedorLibreCompraId = setupData()

        expect:
        sqtProveedorLibreCompraService.count() == 5

        when:
        sqtProveedorLibreCompraService.delete(sqtProveedorLibreCompraId)
        sessionFactory.currentSession.flush()

        then:
        sqtProveedorLibreCompraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProveedorLibreCompra sqtProveedorLibreCompra = new SqtProveedorLibreCompra()
        sqtProveedorLibreCompraService.save(sqtProveedorLibreCompra)

        then:
        sqtProveedorLibreCompra.id != null
    }
}
