package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRedqServiceSpec extends Specification {

    SqtRedqService sqtRedqService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRedq(...).save(flush: true, failOnError: true)
        //new SqtRedq(...).save(flush: true, failOnError: true)
        //SqtRedq sqtRedq = new SqtRedq(...).save(flush: true, failOnError: true)
        //new SqtRedq(...).save(flush: true, failOnError: true)
        //new SqtRedq(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRedq.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRedqService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRedq> sqtRedqList = sqtRedqService.list(max: 2, offset: 2)

        then:
        sqtRedqList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRedqService.count() == 5
    }

    void "test delete"() {
        Long sqtRedqId = setupData()

        expect:
        sqtRedqService.count() == 5

        when:
        sqtRedqService.delete(sqtRedqId)
        sessionFactory.currentSession.flush()

        then:
        sqtRedqService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRedq sqtRedq = new SqtRedq()
        sqtRedqService.save(sqtRedq)

        then:
        sqtRedq.id != null
    }
}
