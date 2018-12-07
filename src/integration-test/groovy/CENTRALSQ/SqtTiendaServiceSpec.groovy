package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTiendaServiceSpec extends Specification {

    SqtTiendaService sqtTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTienda(...).save(flush: true, failOnError: true)
        //new SqtTienda(...).save(flush: true, failOnError: true)
        //SqtTienda sqtTienda = new SqtTienda(...).save(flush: true, failOnError: true)
        //new SqtTienda(...).save(flush: true, failOnError: true)
        //new SqtTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTienda> sqtTiendaList = sqtTiendaService.list(max: 2, offset: 2)

        then:
        sqtTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtTiendaId = setupData()

        expect:
        sqtTiendaService.count() == 5

        when:
        sqtTiendaService.delete(sqtTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTienda sqtTienda = new SqtTienda()
        sqtTiendaService.save(sqtTienda)

        then:
        sqtTienda.id != null
    }
}
