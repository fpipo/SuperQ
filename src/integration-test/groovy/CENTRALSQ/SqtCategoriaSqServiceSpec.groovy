package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCategoriaSqServiceSpec extends Specification {

    SqtCategoriaSqService sqtCategoriaSqService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCategoriaSq(...).save(flush: true, failOnError: true)
        //new SqtCategoriaSq(...).save(flush: true, failOnError: true)
        //SqtCategoriaSq sqtCategoriaSq = new SqtCategoriaSq(...).save(flush: true, failOnError: true)
        //new SqtCategoriaSq(...).save(flush: true, failOnError: true)
        //new SqtCategoriaSq(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCategoriaSq.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCategoriaSqService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCategoriaSq> sqtCategoriaSqList = sqtCategoriaSqService.list(max: 2, offset: 2)

        then:
        sqtCategoriaSqList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCategoriaSqService.count() == 5
    }

    void "test delete"() {
        Long sqtCategoriaSqId = setupData()

        expect:
        sqtCategoriaSqService.count() == 5

        when:
        sqtCategoriaSqService.delete(sqtCategoriaSqId)
        sessionFactory.currentSession.flush()

        then:
        sqtCategoriaSqService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCategoriaSq sqtCategoriaSq = new SqtCategoriaSq()
        sqtCategoriaSqService.save(sqtCategoriaSq)

        then:
        sqtCategoriaSq.id != null
    }
}
