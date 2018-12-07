package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtVisitaSupervisorServiceSpec extends Specification {

    SqtVisitaSupervisorService sqtVisitaSupervisorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtVisitaSupervisor(...).save(flush: true, failOnError: true)
        //new SqtVisitaSupervisor(...).save(flush: true, failOnError: true)
        //SqtVisitaSupervisor sqtVisitaSupervisor = new SqtVisitaSupervisor(...).save(flush: true, failOnError: true)
        //new SqtVisitaSupervisor(...).save(flush: true, failOnError: true)
        //new SqtVisitaSupervisor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtVisitaSupervisor.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtVisitaSupervisorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtVisitaSupervisor> sqtVisitaSupervisorList = sqtVisitaSupervisorService.list(max: 2, offset: 2)

        then:
        sqtVisitaSupervisorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtVisitaSupervisorService.count() == 5
    }

    void "test delete"() {
        Long sqtVisitaSupervisorId = setupData()

        expect:
        sqtVisitaSupervisorService.count() == 5

        when:
        sqtVisitaSupervisorService.delete(sqtVisitaSupervisorId)
        sessionFactory.currentSession.flush()

        then:
        sqtVisitaSupervisorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtVisitaSupervisor sqtVisitaSupervisor = new SqtVisitaSupervisor()
        sqtVisitaSupervisorService.save(sqtVisitaSupervisor)

        then:
        sqtVisitaSupervisor.id != null
    }
}
