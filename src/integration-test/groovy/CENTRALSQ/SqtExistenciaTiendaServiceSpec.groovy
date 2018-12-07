package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtExistenciaTiendaServiceSpec extends Specification {

    SqtExistenciaTiendaService sqtExistenciaTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtExistenciaTienda(...).save(flush: true, failOnError: true)
        //new SqtExistenciaTienda(...).save(flush: true, failOnError: true)
        //SqtExistenciaTienda sqtExistenciaTienda = new SqtExistenciaTienda(...).save(flush: true, failOnError: true)
        //new SqtExistenciaTienda(...).save(flush: true, failOnError: true)
        //new SqtExistenciaTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtExistenciaTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtExistenciaTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtExistenciaTienda> sqtExistenciaTiendaList = sqtExistenciaTiendaService.list(max: 2, offset: 2)

        then:
        sqtExistenciaTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtExistenciaTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtExistenciaTiendaId = setupData()

        expect:
        sqtExistenciaTiendaService.count() == 5

        when:
        sqtExistenciaTiendaService.delete(sqtExistenciaTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtExistenciaTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtExistenciaTienda sqtExistenciaTienda = new SqtExistenciaTienda()
        sqtExistenciaTiendaService.save(sqtExistenciaTienda)

        then:
        sqtExistenciaTienda.id != null
    }
}
