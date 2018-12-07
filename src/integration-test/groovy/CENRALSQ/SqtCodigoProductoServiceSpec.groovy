package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCodigoProductoServiceSpec extends Specification {

    SqtCodigoProductoService sqtCodigoProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCodigoProducto(...).save(flush: true, failOnError: true)
        //new SqtCodigoProducto(...).save(flush: true, failOnError: true)
        //SqtCodigoProducto sqtCodigoProducto = new SqtCodigoProducto(...).save(flush: true, failOnError: true)
        //new SqtCodigoProducto(...).save(flush: true, failOnError: true)
        //new SqtCodigoProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCodigoProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCodigoProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCodigoProducto> sqtCodigoProductoList = sqtCodigoProductoService.list(max: 2, offset: 2)

        then:
        sqtCodigoProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCodigoProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtCodigoProductoId = setupData()

        expect:
        sqtCodigoProductoService.count() == 5

        when:
        sqtCodigoProductoService.delete(sqtCodigoProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCodigoProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCodigoProducto sqtCodigoProducto = new SqtCodigoProducto()
        sqtCodigoProductoService.save(sqtCodigoProducto)

        then:
        sqtCodigoProducto.id != null
    }
}
