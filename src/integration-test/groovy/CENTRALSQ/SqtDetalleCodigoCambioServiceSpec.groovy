package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleCodigoCambioServiceSpec extends Specification {

    SqtDetalleCodigoCambioService sqtDetalleCodigoCambioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleCodigoCambio(...).save(flush: true, failOnError: true)
        //new SqtDetalleCodigoCambio(...).save(flush: true, failOnError: true)
        //SqtDetalleCodigoCambio sqtDetalleCodigoCambio = new SqtDetalleCodigoCambio(...).save(flush: true, failOnError: true)
        //new SqtDetalleCodigoCambio(...).save(flush: true, failOnError: true)
        //new SqtDetalleCodigoCambio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleCodigoCambio.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleCodigoCambioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleCodigoCambio> sqtDetalleCodigoCambioList = sqtDetalleCodigoCambioService.list(max: 2, offset: 2)

        then:
        sqtDetalleCodigoCambioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleCodigoCambioService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleCodigoCambioId = setupData()

        expect:
        sqtDetalleCodigoCambioService.count() == 5

        when:
        sqtDetalleCodigoCambioService.delete(sqtDetalleCodigoCambioId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleCodigoCambioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleCodigoCambio sqtDetalleCodigoCambio = new SqtDetalleCodigoCambio()
        sqtDetalleCodigoCambioService.save(sqtDetalleCodigoCambio)

        then:
        sqtDetalleCodigoCambio.id != null
    }
}
