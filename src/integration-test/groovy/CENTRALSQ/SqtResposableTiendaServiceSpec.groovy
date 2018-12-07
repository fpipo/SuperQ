package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtResposableTiendaServiceSpec extends Specification {

    SqtResposableTiendaService sqtResposableTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtResposableTienda(...).save(flush: true, failOnError: true)
        //new SqtResposableTienda(...).save(flush: true, failOnError: true)
        //SqtResposableTienda sqtResposableTienda = new SqtResposableTienda(...).save(flush: true, failOnError: true)
        //new SqtResposableTienda(...).save(flush: true, failOnError: true)
        //new SqtResposableTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtResposableTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtResposableTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtResposableTienda> sqtResposableTiendaList = sqtResposableTiendaService.list(max: 2, offset: 2)

        then:
        sqtResposableTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtResposableTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtResposableTiendaId = setupData()

        expect:
        sqtResposableTiendaService.count() == 5

        when:
        sqtResposableTiendaService.delete(sqtResposableTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtResposableTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtResposableTienda sqtResposableTienda = new SqtResposableTienda()
        sqtResposableTiendaService.save(sqtResposableTienda)

        then:
        sqtResposableTienda.id != null
    }
}
