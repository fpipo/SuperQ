package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTraspasoServiceSpec extends Specification {

    SqtTraspasoService sqtTraspasoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTraspaso(...).save(flush: true, failOnError: true)
        //new SqtTraspaso(...).save(flush: true, failOnError: true)
        //SqtTraspaso sqtTraspaso = new SqtTraspaso(...).save(flush: true, failOnError: true)
        //new SqtTraspaso(...).save(flush: true, failOnError: true)
        //new SqtTraspaso(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTraspaso.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTraspasoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTraspaso> sqtTraspasoList = sqtTraspasoService.list(max: 2, offset: 2)

        then:
        sqtTraspasoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTraspasoService.count() == 5
    }

    void "test delete"() {
        Long sqtTraspasoId = setupData()

        expect:
        sqtTraspasoService.count() == 5

        when:
        sqtTraspasoService.delete(sqtTraspasoId)
        sessionFactory.currentSession.flush()

        then:
        sqtTraspasoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTraspaso sqtTraspaso = new SqtTraspaso()
        sqtTraspasoService.save(sqtTraspaso)

        then:
        sqtTraspaso.id != null
    }
}
