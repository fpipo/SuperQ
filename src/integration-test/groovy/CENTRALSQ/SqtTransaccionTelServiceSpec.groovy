package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTransaccionTelServiceSpec extends Specification {

    SqtTransaccionTelService sqtTransaccionTelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTransaccionTel(...).save(flush: true, failOnError: true)
        //new SqtTransaccionTel(...).save(flush: true, failOnError: true)
        //SqtTransaccionTel sqtTransaccionTel = new SqtTransaccionTel(...).save(flush: true, failOnError: true)
        //new SqtTransaccionTel(...).save(flush: true, failOnError: true)
        //new SqtTransaccionTel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTransaccionTel.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTransaccionTelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTransaccionTel> sqtTransaccionTelList = sqtTransaccionTelService.list(max: 2, offset: 2)

        then:
        sqtTransaccionTelList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTransaccionTelService.count() == 5
    }

    void "test delete"() {
        Long sqtTransaccionTelId = setupData()

        expect:
        sqtTransaccionTelService.count() == 5

        when:
        sqtTransaccionTelService.delete(sqtTransaccionTelId)
        sessionFactory.currentSession.flush()

        then:
        sqtTransaccionTelService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTransaccionTel sqtTransaccionTel = new SqtTransaccionTel()
        sqtTransaccionTelService.save(sqtTransaccionTel)

        then:
        sqtTransaccionTel.id != null
    }
}
