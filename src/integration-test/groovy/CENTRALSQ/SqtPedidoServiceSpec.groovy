package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPedidoServiceSpec extends Specification {

    SqtPedidoService sqtPedidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPedido(...).save(flush: true, failOnError: true)
        //new SqtPedido(...).save(flush: true, failOnError: true)
        //SqtPedido sqtPedido = new SqtPedido(...).save(flush: true, failOnError: true)
        //new SqtPedido(...).save(flush: true, failOnError: true)
        //new SqtPedido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPedido.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPedidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPedido> sqtPedidoList = sqtPedidoService.list(max: 2, offset: 2)

        then:
        sqtPedidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPedidoService.count() == 5
    }

    void "test delete"() {
        Long sqtPedidoId = setupData()

        expect:
        sqtPedidoService.count() == 5

        when:
        sqtPedidoService.delete(sqtPedidoId)
        sessionFactory.currentSession.flush()

        then:
        sqtPedidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPedido sqtPedido = new SqtPedido()
        sqtPedidoService.save(sqtPedido)

        then:
        sqtPedido.id != null
    }
}
