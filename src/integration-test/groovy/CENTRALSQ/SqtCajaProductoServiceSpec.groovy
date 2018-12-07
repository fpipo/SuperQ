package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCajaProductoServiceSpec extends Specification {

    SqtCajaProductoService sqtCajaProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCajaProducto(...).save(flush: true, failOnError: true)
        //new SqtCajaProducto(...).save(flush: true, failOnError: true)
        //SqtCajaProducto sqtCajaProducto = new SqtCajaProducto(...).save(flush: true, failOnError: true)
        //new SqtCajaProducto(...).save(flush: true, failOnError: true)
        //new SqtCajaProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCajaProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCajaProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCajaProducto> sqtCajaProductoList = sqtCajaProductoService.list(max: 2, offset: 2)

        then:
        sqtCajaProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCajaProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtCajaProductoId = setupData()

        expect:
        sqtCajaProductoService.count() == 5

        when:
        sqtCajaProductoService.delete(sqtCajaProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCajaProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCajaProducto sqtCajaProducto = new SqtCajaProducto()
        sqtCajaProductoService.save(sqtCajaProducto)

        then:
        sqtCajaProducto.id != null
    }
}
