package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtZonaServiceSpec extends Specification {

    SqtZonaService sqtZonaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtZona(...).save(flush: true, failOnError: true)
        //new SqtZona(...).save(flush: true, failOnError: true)
        //SqtZona sqtZona = new SqtZona(...).save(flush: true, failOnError: true)
        //new SqtZona(...).save(flush: true, failOnError: true)
        //new SqtZona(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtZona.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtZonaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtZona> sqtZonaList = sqtZonaService.list(max: 2, offset: 2)

        then:
        sqtZonaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtZonaService.count() == 5
    }

    void "test delete"() {
        Long sqtZonaId = setupData()

        expect:
        sqtZonaService.count() == 5

        when:
        sqtZonaService.delete(sqtZonaId)
        sessionFactory.currentSession.flush()

        then:
        sqtZonaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtZona sqtZona = new SqtZona()
        sqtZonaService.save(sqtZona)

        then:
        sqtZona.id != null
    }
}
