package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtSupervisorSqServiceSpec extends Specification {

    SqtSupervisorSqService sqtSupervisorSqService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtSupervisorSq(...).save(flush: true, failOnError: true)
        //new SqtSupervisorSq(...).save(flush: true, failOnError: true)
        //SqtSupervisorSq sqtSupervisorSq = new SqtSupervisorSq(...).save(flush: true, failOnError: true)
        //new SqtSupervisorSq(...).save(flush: true, failOnError: true)
        //new SqtSupervisorSq(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtSupervisorSq.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtSupervisorSqService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtSupervisorSq> sqtSupervisorSqList = sqtSupervisorSqService.list(max: 2, offset: 2)

        then:
        sqtSupervisorSqList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtSupervisorSqService.count() == 5
    }

    void "test delete"() {
        Long sqtSupervisorSqId = setupData()

        expect:
        sqtSupervisorSqService.count() == 5

        when:
        sqtSupervisorSqService.delete(sqtSupervisorSqId)
        sessionFactory.currentSession.flush()

        then:
        sqtSupervisorSqService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtSupervisorSq sqtSupervisorSq = new SqtSupervisorSq()
        sqtSupervisorSqService.save(sqtSupervisorSq)

        then:
        sqtSupervisorSq.id != null
    }
}
