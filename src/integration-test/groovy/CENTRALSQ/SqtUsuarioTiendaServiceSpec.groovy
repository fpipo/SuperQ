package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtUsuarioTiendaServiceSpec extends Specification {

    SqtUsuarioTiendaService sqtUsuarioTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtUsuarioTienda(...).save(flush: true, failOnError: true)
        //new SqtUsuarioTienda(...).save(flush: true, failOnError: true)
        //SqtUsuarioTienda sqtUsuarioTienda = new SqtUsuarioTienda(...).save(flush: true, failOnError: true)
        //new SqtUsuarioTienda(...).save(flush: true, failOnError: true)
        //new SqtUsuarioTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtUsuarioTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtUsuarioTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtUsuarioTienda> sqtUsuarioTiendaList = sqtUsuarioTiendaService.list(max: 2, offset: 2)

        then:
        sqtUsuarioTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtUsuarioTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtUsuarioTiendaId = setupData()

        expect:
        sqtUsuarioTiendaService.count() == 5

        when:
        sqtUsuarioTiendaService.delete(sqtUsuarioTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtUsuarioTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtUsuarioTienda sqtUsuarioTienda = new SqtUsuarioTienda()
        sqtUsuarioTiendaService.save(sqtUsuarioTienda)

        then:
        sqtUsuarioTienda.id != null
    }
}
