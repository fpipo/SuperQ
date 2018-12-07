package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtSupervisorTiendaServiceSpec extends Specification {

    SqtSupervisorTiendaService sqtSupervisorTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtSupervisorTienda(...).save(flush: true, failOnError: true)
        //new SqtSupervisorTienda(...).save(flush: true, failOnError: true)
        //SqtSupervisorTienda sqtSupervisorTienda = new SqtSupervisorTienda(...).save(flush: true, failOnError: true)
        //new SqtSupervisorTienda(...).save(flush: true, failOnError: true)
        //new SqtSupervisorTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtSupervisorTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtSupervisorTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtSupervisorTienda> sqtSupervisorTiendaList = sqtSupervisorTiendaService.list(max: 2, offset: 2)

        then:
        sqtSupervisorTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtSupervisorTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtSupervisorTiendaId = setupData()

        expect:
        sqtSupervisorTiendaService.count() == 5

        when:
        sqtSupervisorTiendaService.delete(sqtSupervisorTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtSupervisorTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtSupervisorTienda sqtSupervisorTienda = new SqtSupervisorTienda()
        sqtSupervisorTiendaService.save(sqtSupervisorTienda)

        then:
        sqtSupervisorTienda.id != null
    }
}
