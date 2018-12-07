package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtEmisoresComisionServiceSpec extends Specification {

    SqtEmisoresComisionService sqtEmisoresComisionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtEmisoresComision(...).save(flush: true, failOnError: true)
        //new SqtEmisoresComision(...).save(flush: true, failOnError: true)
        //SqtEmisoresComision sqtEmisoresComision = new SqtEmisoresComision(...).save(flush: true, failOnError: true)
        //new SqtEmisoresComision(...).save(flush: true, failOnError: true)
        //new SqtEmisoresComision(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtEmisoresComision.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtEmisoresComisionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtEmisoresComision> sqtEmisoresComisionList = sqtEmisoresComisionService.list(max: 2, offset: 2)

        then:
        sqtEmisoresComisionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtEmisoresComisionService.count() == 5
    }

    void "test delete"() {
        Long sqtEmisoresComisionId = setupData()

        expect:
        sqtEmisoresComisionService.count() == 5

        when:
        sqtEmisoresComisionService.delete(sqtEmisoresComisionId)
        sessionFactory.currentSession.flush()

        then:
        sqtEmisoresComisionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtEmisoresComision sqtEmisoresComision = new SqtEmisoresComision()
        sqtEmisoresComisionService.save(sqtEmisoresComision)

        then:
        sqtEmisoresComision.id != null
    }
}
