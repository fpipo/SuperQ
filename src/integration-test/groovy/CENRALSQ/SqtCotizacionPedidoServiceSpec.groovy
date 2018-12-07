package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCotizacionPedidoServiceSpec extends Specification {

    SqtCotizacionPedidoService sqtCotizacionPedidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCotizacionPedido(...).save(flush: true, failOnError: true)
        //new SqtCotizacionPedido(...).save(flush: true, failOnError: true)
        //SqtCotizacionPedido sqtCotizacionPedido = new SqtCotizacionPedido(...).save(flush: true, failOnError: true)
        //new SqtCotizacionPedido(...).save(flush: true, failOnError: true)
        //new SqtCotizacionPedido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCotizacionPedido.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCotizacionPedidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCotizacionPedido> sqtCotizacionPedidoList = sqtCotizacionPedidoService.list(max: 2, offset: 2)

        then:
        sqtCotizacionPedidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCotizacionPedidoService.count() == 5
    }

    void "test delete"() {
        Long sqtCotizacionPedidoId = setupData()

        expect:
        sqtCotizacionPedidoService.count() == 5

        when:
        sqtCotizacionPedidoService.delete(sqtCotizacionPedidoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCotizacionPedidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCotizacionPedido sqtCotizacionPedido = new SqtCotizacionPedido()
        sqtCotizacionPedidoService.save(sqtCotizacionPedido)

        then:
        sqtCotizacionPedido.id != null
    }
}
