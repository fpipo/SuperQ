package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtFolioServiceSpec extends Specification {

    SqtFolioService sqtFolioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtFolio(...).save(flush: true, failOnError: true)
        //new SqtFolio(...).save(flush: true, failOnError: true)
        //SqtFolio sqtFolio = new SqtFolio(...).save(flush: true, failOnError: true)
        //new SqtFolio(...).save(flush: true, failOnError: true)
        //new SqtFolio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtFolio.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtFolioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtFolio> sqtFolioList = sqtFolioService.list(max: 2, offset: 2)

        then:
        sqtFolioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtFolioService.count() == 5
    }

    void "test delete"() {
        Long sqtFolioId = setupData()

        expect:
        sqtFolioService.count() == 5

        when:
        sqtFolioService.delete(sqtFolioId)
        sessionFactory.currentSession.flush()

        then:
        sqtFolioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtFolio sqtFolio = new SqtFolio()
        sqtFolioService.save(sqtFolio)

        then:
        sqtFolio.id != null
    }
}
