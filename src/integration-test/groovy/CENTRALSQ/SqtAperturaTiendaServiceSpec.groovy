package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAperturaTiendaServiceSpec extends Specification {

    SqtAperturaTiendaService sqtAperturaTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAperturaTienda(...).save(flush: true, failOnError: true)
        //new SqtAperturaTienda(...).save(flush: true, failOnError: true)
        //SqtAperturaTienda sqtAperturaTienda = new SqtAperturaTienda(...).save(flush: true, failOnError: true)
        //new SqtAperturaTienda(...).save(flush: true, failOnError: true)
        //new SqtAperturaTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAperturaTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAperturaTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAperturaTienda> sqtAperturaTiendaList = sqtAperturaTiendaService.list(max: 2, offset: 2)

        then:
        sqtAperturaTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAperturaTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtAperturaTiendaId = setupData()

        expect:
        sqtAperturaTiendaService.count() == 5

        when:
        sqtAperturaTiendaService.delete(sqtAperturaTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtAperturaTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAperturaTienda sqtAperturaTienda = new SqtAperturaTienda()
        sqtAperturaTiendaService.save(sqtAperturaTienda)

        then:
        sqtAperturaTienda.id != null
    }
}
