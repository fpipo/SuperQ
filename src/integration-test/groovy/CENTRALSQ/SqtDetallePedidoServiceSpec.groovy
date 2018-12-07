package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetallePedidoServiceSpec extends Specification {

    SqtDetallePedidoService sqtDetallePedidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetallePedido(...).save(flush: true, failOnError: true)
        //new SqtDetallePedido(...).save(flush: true, failOnError: true)
        //SqtDetallePedido sqtDetallePedido = new SqtDetallePedido(...).save(flush: true, failOnError: true)
        //new SqtDetallePedido(...).save(flush: true, failOnError: true)
        //new SqtDetallePedido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetallePedido.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetallePedidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetallePedido> sqtDetallePedidoList = sqtDetallePedidoService.list(max: 2, offset: 2)

        then:
        sqtDetallePedidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetallePedidoService.count() == 5
    }

    void "test delete"() {
        Long sqtDetallePedidoId = setupData()

        expect:
        sqtDetallePedidoService.count() == 5

        when:
        sqtDetallePedidoService.delete(sqtDetallePedidoId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetallePedidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetallePedido sqtDetallePedido = new SqtDetallePedido()
        sqtDetallePedidoService.save(sqtDetallePedido)

        then:
        sqtDetallePedido.id != null
    }
}
