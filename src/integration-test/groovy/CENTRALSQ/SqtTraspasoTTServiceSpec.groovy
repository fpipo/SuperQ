package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTraspasoTTServiceSpec extends Specification {

    SqtTraspasoTTService sqtTraspasoTTService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTraspasoTT(...).save(flush: true, failOnError: true)
        //new SqtTraspasoTT(...).save(flush: true, failOnError: true)
        //SqtTraspasoTT sqtTraspasoTT = new SqtTraspasoTT(...).save(flush: true, failOnError: true)
        //new SqtTraspasoTT(...).save(flush: true, failOnError: true)
        //new SqtTraspasoTT(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTraspasoTT.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTraspasoTTService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTraspasoTT> sqtTraspasoTTList = sqtTraspasoTTService.list(max: 2, offset: 2)

        then:
        sqtTraspasoTTList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTraspasoTTService.count() == 5
    }

    void "test delete"() {
        Long sqtTraspasoTTId = setupData()

        expect:
        sqtTraspasoTTService.count() == 5

        when:
        sqtTraspasoTTService.delete(sqtTraspasoTTId)
        sessionFactory.currentSession.flush()

        then:
        sqtTraspasoTTService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTraspasoTT sqtTraspasoTT = new SqtTraspasoTT()
        sqtTraspasoTTService.save(sqtTraspasoTT)

        then:
        sqtTraspasoTT.id != null
    }
}
