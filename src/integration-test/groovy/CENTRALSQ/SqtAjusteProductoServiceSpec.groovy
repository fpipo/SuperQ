package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAjusteProductoServiceSpec extends Specification {

    SqtAjusteProductoService sqtAjusteProductoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAjusteProducto(...).save(flush: true, failOnError: true)
        //new SqtAjusteProducto(...).save(flush: true, failOnError: true)
        //SqtAjusteProducto sqtAjusteProducto = new SqtAjusteProducto(...).save(flush: true, failOnError: true)
        //new SqtAjusteProducto(...).save(flush: true, failOnError: true)
        //new SqtAjusteProducto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAjusteProducto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAjusteProductoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAjusteProducto> sqtAjusteProductoList = sqtAjusteProductoService.list(max: 2, offset: 2)

        then:
        sqtAjusteProductoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAjusteProductoService.count() == 5
    }

    void "test delete"() {
        Long sqtAjusteProductoId = setupData()

        expect:
        sqtAjusteProductoService.count() == 5

        when:
        sqtAjusteProductoService.delete(sqtAjusteProductoId)
        sessionFactory.currentSession.flush()

        then:
        sqtAjusteProductoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAjusteProducto sqtAjusteProducto = new SqtAjusteProducto()
        sqtAjusteProductoService.save(sqtAjusteProducto)

        then:
        sqtAjusteProducto.id != null
    }
}
