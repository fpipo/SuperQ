package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPasswordServiceSpec extends Specification {

    SqtPasswordService sqtPasswordService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPassword(...).save(flush: true, failOnError: true)
        //new SqtPassword(...).save(flush: true, failOnError: true)
        //SqtPassword sqtPassword = new SqtPassword(...).save(flush: true, failOnError: true)
        //new SqtPassword(...).save(flush: true, failOnError: true)
        //new SqtPassword(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPassword.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPasswordService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPassword> sqtPasswordList = sqtPasswordService.list(max: 2, offset: 2)

        then:
        sqtPasswordList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPasswordService.count() == 5
    }

    void "test delete"() {
        Long sqtPasswordId = setupData()

        expect:
        sqtPasswordService.count() == 5

        when:
        sqtPasswordService.delete(sqtPasswordId)
        sessionFactory.currentSession.flush()

        then:
        sqtPasswordService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPassword sqtPassword = new SqtPassword()
        sqtPasswordService.save(sqtPassword)

        then:
        sqtPassword.id != null
    }
}
