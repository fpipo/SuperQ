package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtEstatusServiceSpec extends Specification {

    SqtEstatusService sqtEstatusService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtEstatus(...).save(flush: true, failOnError: true)
        //new SqtEstatus(...).save(flush: true, failOnError: true)
        //SqtEstatus sqtEstatus = new SqtEstatus(...).save(flush: true, failOnError: true)
        //new SqtEstatus(...).save(flush: true, failOnError: true)
        //new SqtEstatus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtEstatus.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtEstatusService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtEstatus> sqtEstatusList = sqtEstatusService.list(max: 2, offset: 2)

        then:
        sqtEstatusList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtEstatusService.count() == 5
    }

    void "test delete"() {
        Long sqtEstatusId = setupData()

        expect:
        sqtEstatusService.count() == 5

        when:
        sqtEstatusService.delete(sqtEstatusId)
        sessionFactory.currentSession.flush()

        then:
        sqtEstatusService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtEstatus sqtEstatus = new SqtEstatus()
        sqtEstatusService.save(sqtEstatus)

        then:
        sqtEstatus.id != null
    }
}
