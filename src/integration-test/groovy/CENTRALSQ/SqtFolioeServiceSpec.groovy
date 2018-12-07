package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtFolioeServiceSpec extends Specification {

    SqtFolioeService sqtFolioeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtFolioe(...).save(flush: true, failOnError: true)
        //new SqtFolioe(...).save(flush: true, failOnError: true)
        //SqtFolioe sqtFolioe = new SqtFolioe(...).save(flush: true, failOnError: true)
        //new SqtFolioe(...).save(flush: true, failOnError: true)
        //new SqtFolioe(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtFolioe.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtFolioeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtFolioe> sqtFolioeList = sqtFolioeService.list(max: 2, offset: 2)

        then:
        sqtFolioeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtFolioeService.count() == 5
    }

    void "test delete"() {
        Long sqtFolioeId = setupData()

        expect:
        sqtFolioeService.count() == 5

        when:
        sqtFolioeService.delete(sqtFolioeId)
        sessionFactory.currentSession.flush()

        then:
        sqtFolioeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtFolioe sqtFolioe = new SqtFolioe()
        sqtFolioeService.save(sqtFolioe)

        then:
        sqtFolioe.id != null
    }
}
