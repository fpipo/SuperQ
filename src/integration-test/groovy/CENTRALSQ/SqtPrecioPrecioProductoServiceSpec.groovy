package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPrecioPrecioProductoServiceSpec extends Specification {

    SqtPrecioPrecioProductoService sqtPrecioPrecioProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPrecioPrecioProducto(...).save(flush: true, failOnError: true)
        //new SqtPrecioPrecioProducto(...).save(flush: true, failOnError: true)
        //SqtPrecioPrecioProducto sqtPrecioPrecioProducto = new SqtPrecioPrecioProducto(...).save(flush: true, failOnError: true)
        //new SqtPrecioPrecioProducto(...).save(flush: true, failOnError: true)
        //new SqtPrecioPrecioProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPrecioPrecioProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPrecioPrecioProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPrecioPrecioProducto> sqtPrecioPrecioProductoList = sqtPrecioPrecioProductoService.list(max: 2, offset: 2)

        then:
        sqtPrecioPrecioProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPrecioPrecioProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtPrecioPrecioProductoId = setupData()

        expect:
        sqtPrecioPrecioProductoService.count() == 5

        when:
        sqtPrecioPrecioProductoService.delete(sqtPrecioPrecioProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtPrecioPrecioProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPrecioPrecioProducto sqtPrecioPrecioProducto = new SqtPrecioPrecioProducto()
        sqtPrecioPrecioProductoService.save(sqtPrecioPrecioProducto)

        then:
        sqtPrecioPrecioProducto.id != null
    }
}
