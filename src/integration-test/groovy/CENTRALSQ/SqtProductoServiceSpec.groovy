package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProductoServiceSpec extends Specification {

    SqtProductoService sqtProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProducto(...).save(flush: true, failOnError: true)
        //new SqtProducto(...).save(flush: true, failOnError: true)
        //SqtProducto sqtProducto = new SqtProducto(...).save(flush: true, failOnError: true)
        //new SqtProducto(...).save(flush: true, failOnError: true)
        //new SqtProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProducto> sqtProductoList = sqtProductoService.list(max: 2, offset: 2)

        then:
        sqtProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtProductoId = setupData()

        expect:
        sqtProductoService.count() == 5

        when:
        sqtProductoService.delete(sqtProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProducto sqtProducto = new SqtProducto()
        sqtProductoService.save(sqtProducto)

        then:
        sqtProducto.id != null
    }
}
