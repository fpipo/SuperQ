package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPrecioProductoServiceSpec extends Specification {

    SqtPrecioProductoService sqtPrecioProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPrecioProducto(...).save(flush: true, failOnError: true)
        //new SqtPrecioProducto(...).save(flush: true, failOnError: true)
        //SqtPrecioProducto sqtPrecioProducto = new SqtPrecioProducto(...).save(flush: true, failOnError: true)
        //new SqtPrecioProducto(...).save(flush: true, failOnError: true)
        //new SqtPrecioProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPrecioProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPrecioProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPrecioProducto> sqtPrecioProductoList = sqtPrecioProductoService.list(max: 2, offset: 2)

        then:
        sqtPrecioProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPrecioProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtPrecioProductoId = setupData()

        expect:
        sqtPrecioProductoService.count() == 5

        when:
        sqtPrecioProductoService.delete(sqtPrecioProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtPrecioProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPrecioProducto sqtPrecioProducto = new SqtPrecioProducto()
        sqtPrecioProductoService.save(sqtPrecioProducto)

        then:
        sqtPrecioProducto.id != null
    }
}
