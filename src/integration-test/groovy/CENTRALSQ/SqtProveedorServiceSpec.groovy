package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProveedorServiceSpec extends Specification {

    SqtProveedorService sqtProveedorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProveedor(...).save(flush: true, failOnError: true)
        //new SqtProveedor(...).save(flush: true, failOnError: true)
        //SqtProveedor sqtProveedor = new SqtProveedor(...).save(flush: true, failOnError: true)
        //new SqtProveedor(...).save(flush: true, failOnError: true)
        //new SqtProveedor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProveedor.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProveedorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProveedor> sqtProveedorList = sqtProveedorService.list(max: 2, offset: 2)

        then:
        sqtProveedorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProveedorService.count() == 5
    }

    void "test delete"() {
        Long sqtProveedorId = setupData()

        expect:
        sqtProveedorService.count() == 5

        when:
        sqtProveedorService.delete(sqtProveedorId)
        sessionFactory.currentSession.flush()

        then:
        sqtProveedorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProveedor sqtProveedor = new SqtProveedor()
        sqtProveedorService.save(sqtProveedor)

        then:
        sqtProveedor.id != null
    }
}
