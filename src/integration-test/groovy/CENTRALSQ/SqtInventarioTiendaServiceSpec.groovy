package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioTiendaServiceSpec extends Specification {

    SqtInventarioTiendaService sqtInventarioTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioTienda(...).save(flush: true, failOnError: true)
        //new SqtInventarioTienda(...).save(flush: true, failOnError: true)
        //SqtInventarioTienda sqtInventarioTienda = new SqtInventarioTienda(...).save(flush: true, failOnError: true)
        //new SqtInventarioTienda(...).save(flush: true, failOnError: true)
        //new SqtInventarioTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioTienda> sqtInventarioTiendaList = sqtInventarioTiendaService.list(max: 2, offset: 2)

        then:
        sqtInventarioTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioTiendaId = setupData()

        expect:
        sqtInventarioTiendaService.count() == 5

        when:
        sqtInventarioTiendaService.delete(sqtInventarioTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioTienda sqtInventarioTienda = new SqtInventarioTienda()
        sqtInventarioTiendaService.save(sqtInventarioTienda)

        then:
        sqtInventarioTienda.id != null
    }
}
