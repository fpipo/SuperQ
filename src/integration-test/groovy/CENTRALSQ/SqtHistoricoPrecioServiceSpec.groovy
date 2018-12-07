package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtHistoricoPrecioServiceSpec extends Specification {

    SqtHistoricoPrecioService sqtHistoricoPrecioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtHistoricoPrecio(...).save(flush: true, failOnError: true)
        //new SqtHistoricoPrecio(...).save(flush: true, failOnError: true)
        //SqtHistoricoPrecio sqtHistoricoPrecio = new SqtHistoricoPrecio(...).save(flush: true, failOnError: true)
        //new SqtHistoricoPrecio(...).save(flush: true, failOnError: true)
        //new SqtHistoricoPrecio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtHistoricoPrecio.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtHistoricoPrecioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtHistoricoPrecio> sqtHistoricoPrecioList = sqtHistoricoPrecioService.list(max: 2, offset: 2)

        then:
        sqtHistoricoPrecioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtHistoricoPrecioService.count() == 5
    }

    void "test delete"() {
        Long sqtHistoricoPrecioId = setupData()

        expect:
        sqtHistoricoPrecioService.count() == 5

        when:
        sqtHistoricoPrecioService.delete(sqtHistoricoPrecioId)
        sessionFactory.currentSession.flush()

        then:
        sqtHistoricoPrecioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtHistoricoPrecio sqtHistoricoPrecio = new SqtHistoricoPrecio()
        sqtHistoricoPrecioService.save(sqtHistoricoPrecio)

        then:
        sqtHistoricoPrecio.id != null
    }
}
