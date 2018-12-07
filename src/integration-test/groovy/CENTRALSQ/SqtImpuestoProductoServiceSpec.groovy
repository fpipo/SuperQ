package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtImpuestoProductoServiceSpec extends Specification {

    SqtImpuestoProductoService sqtImpuestoProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtImpuestoProducto(...).save(flush: true, failOnError: true)
        //new SqtImpuestoProducto(...).save(flush: true, failOnError: true)
        //SqtImpuestoProducto sqtImpuestoProducto = new SqtImpuestoProducto(...).save(flush: true, failOnError: true)
        //new SqtImpuestoProducto(...).save(flush: true, failOnError: true)
        //new SqtImpuestoProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtImpuestoProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtImpuestoProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtImpuestoProducto> sqtImpuestoProductoList = sqtImpuestoProductoService.list(max: 2, offset: 2)

        then:
        sqtImpuestoProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtImpuestoProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtImpuestoProductoId = setupData()

        expect:
        sqtImpuestoProductoService.count() == 5

        when:
        sqtImpuestoProductoService.delete(sqtImpuestoProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtImpuestoProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtImpuestoProducto sqtImpuestoProducto = new SqtImpuestoProducto()
        sqtImpuestoProductoService.save(sqtImpuestoProducto)

        then:
        sqtImpuestoProducto.id != null
    }
}
