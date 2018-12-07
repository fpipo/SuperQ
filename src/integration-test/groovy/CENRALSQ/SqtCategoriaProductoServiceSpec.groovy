package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCategoriaProductoServiceSpec extends Specification {

    SqtCategoriaProductoService sqtCategoriaProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCategoriaProducto(...).save(flush: true, failOnError: true)
        //new SqtCategoriaProducto(...).save(flush: true, failOnError: true)
        //SqtCategoriaProducto sqtCategoriaProducto = new SqtCategoriaProducto(...).save(flush: true, failOnError: true)
        //new SqtCategoriaProducto(...).save(flush: true, failOnError: true)
        //new SqtCategoriaProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCategoriaProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCategoriaProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCategoriaProducto> sqtCategoriaProductoList = sqtCategoriaProductoService.list(max: 2, offset: 2)

        then:
        sqtCategoriaProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCategoriaProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtCategoriaProductoId = setupData()

        expect:
        sqtCategoriaProductoService.count() == 5

        when:
        sqtCategoriaProductoService.delete(sqtCategoriaProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCategoriaProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCategoriaProducto sqtCategoriaProducto = new SqtCategoriaProducto()
        sqtCategoriaProductoService.save(sqtCategoriaProducto)

        then:
        sqtCategoriaProducto.id != null
    }
}
