package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDeudorServiceSpec extends Specification {

    SqtDeudorService sqtDeudorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDeudor(...).save(flush: true, failOnError: true)
        //new SqtDeudor(...).save(flush: true, failOnError: true)
        //SqtDeudor sqtDeudor = new SqtDeudor(...).save(flush: true, failOnError: true)
        //new SqtDeudor(...).save(flush: true, failOnError: true)
        //new SqtDeudor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDeudor.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDeudorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDeudor> sqtDeudorList = sqtDeudorService.list(max: 2, offset: 2)

        then:
        sqtDeudorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDeudorService.count() == 5
    }

    void "test delete"() {
        Long sqtDeudorId = setupData()

        expect:
        sqtDeudorService.count() == 5

        when:
        sqtDeudorService.delete(sqtDeudorId)
        sessionFactory.currentSession.flush()

        then:
        sqtDeudorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDeudor sqtDeudor = new SqtDeudor()
        sqtDeudorService.save(sqtDeudor)

        then:
        sqtDeudor.id != null
    }
}
