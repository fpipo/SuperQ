package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtSupervisorServiceSpec extends Specification {

    SqtSupervisorService sqtSupervisorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtSupervisor(...).save(flush: true, failOnError: true)
        //new SqtSupervisor(...).save(flush: true, failOnError: true)
        //SqtSupervisor sqtSupervisor = new SqtSupervisor(...).save(flush: true, failOnError: true)
        //new SqtSupervisor(...).save(flush: true, failOnError: true)
        //new SqtSupervisor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtSupervisor.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtSupervisorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtSupervisor> sqtSupervisorList = sqtSupervisorService.list(max: 2, offset: 2)

        then:
        sqtSupervisorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtSupervisorService.count() == 5
    }

    void "test delete"() {
        Long sqtSupervisorId = setupData()

        expect:
        sqtSupervisorService.count() == 5

        when:
        sqtSupervisorService.delete(sqtSupervisorId)
        sessionFactory.currentSession.flush()

        then:
        sqtSupervisorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtSupervisor sqtSupervisor = new SqtSupervisor()
        sqtSupervisorService.save(sqtSupervisor)

        then:
        sqtSupervisor.id != null
    }
}
