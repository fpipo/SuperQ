package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProductoProveedorServiceSpec extends Specification {

    SqtProductoProveedorService sqtProductoProveedorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProductoProveedor(...).save(flush: true, failOnError: true)
        //new SqtProductoProveedor(...).save(flush: true, failOnError: true)
        //SqtProductoProveedor sqtProductoProveedor = new SqtProductoProveedor(...).save(flush: true, failOnError: true)
        //new SqtProductoProveedor(...).save(flush: true, failOnError: true)
        //new SqtProductoProveedor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProductoProveedor.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProductoProveedorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProductoProveedor> sqtProductoProveedorList = sqtProductoProveedorService.list(max: 2, offset: 2)

        then:
        sqtProductoProveedorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProductoProveedorService.count() == 5
    }

    void "test delete"() {
        Long sqtProductoProveedorId = setupData()

        expect:
        sqtProductoProveedorService.count() == 5

        when:
        sqtProductoProveedorService.delete(sqtProductoProveedorId)
        sessionFactory.currentSession.flush()

        then:
        sqtProductoProveedorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProductoProveedor sqtProductoProveedor = new SqtProductoProveedor()
        sqtProductoProveedorService.save(sqtProductoProveedor)

        then:
        sqtProductoProveedor.id != null
    }
}
