package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleVentaProductoServiceSpec extends Specification {

    SqtDetalleVentaProductoService sqtDetalleVentaProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleVentaProducto(...).save(flush: true, failOnError: true)
        //new SqtDetalleVentaProducto(...).save(flush: true, failOnError: true)
        //SqtDetalleVentaProducto sqtDetalleVentaProducto = new SqtDetalleVentaProducto(...).save(flush: true, failOnError: true)
        //new SqtDetalleVentaProducto(...).save(flush: true, failOnError: true)
        //new SqtDetalleVentaProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleVentaProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleVentaProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleVentaProducto> sqtDetalleVentaProductoList = sqtDetalleVentaProductoService.list(max: 2, offset: 2)

        then:
        sqtDetalleVentaProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleVentaProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleVentaProductoId = setupData()

        expect:
        sqtDetalleVentaProductoService.count() == 5

        when:
        sqtDetalleVentaProductoService.delete(sqtDetalleVentaProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleVentaProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleVentaProducto sqtDetalleVentaProducto = new SqtDetalleVentaProducto()
        sqtDetalleVentaProductoService.save(sqtDetalleVentaProducto)

        then:
        sqtDetalleVentaProducto.id != null
    }
}
