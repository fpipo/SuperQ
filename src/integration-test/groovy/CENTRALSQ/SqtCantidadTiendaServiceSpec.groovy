package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCantidadTiendaServiceSpec extends Specification {

    SqtCantidadTiendaService sqtCantidadTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCantidadTienda(...).save(flush: true, failOnError: true)
        //new SqtCantidadTienda(...).save(flush: true, failOnError: true)
        //SqtCantidadTienda sqtCantidadTienda = new SqtCantidadTienda(...).save(flush: true, failOnError: true)
        //new SqtCantidadTienda(...).save(flush: true, failOnError: true)
        //new SqtCantidadTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCantidadTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCantidadTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCantidadTienda> sqtCantidadTiendaList = sqtCantidadTiendaService.list(max: 2, offset: 2)

        then:
        sqtCantidadTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCantidadTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtCantidadTiendaId = setupData()

        expect:
        sqtCantidadTiendaService.count() == 5

        when:
        sqtCantidadTiendaService.delete(sqtCantidadTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCantidadTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCantidadTienda sqtCantidadTienda = new SqtCantidadTienda()
        sqtCantidadTiendaService.save(sqtCantidadTienda)

        then:
        sqtCantidadTienda.id != null
    }
}
