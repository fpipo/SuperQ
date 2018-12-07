package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCajaTiendaServiceSpec extends Specification {

    SqtCajaTiendaService sqtCajaTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCajaTienda(...).save(flush: true, failOnError: true)
        //new SqtCajaTienda(...).save(flush: true, failOnError: true)
        //SqtCajaTienda sqtCajaTienda = new SqtCajaTienda(...).save(flush: true, failOnError: true)
        //new SqtCajaTienda(...).save(flush: true, failOnError: true)
        //new SqtCajaTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCajaTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCajaTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCajaTienda> sqtCajaTiendaList = sqtCajaTiendaService.list(max: 2, offset: 2)

        then:
        sqtCajaTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCajaTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtCajaTiendaId = setupData()

        expect:
        sqtCajaTiendaService.count() == 5

        when:
        sqtCajaTiendaService.delete(sqtCajaTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCajaTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCajaTienda sqtCajaTienda = new SqtCajaTienda()
        sqtCajaTiendaService.save(sqtCajaTienda)

        then:
        sqtCajaTienda.id != null
    }
}
