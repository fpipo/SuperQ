package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPaisServiceSpec extends Specification {

    SqtPaisService sqtPaisService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPais(...).save(flush: true, failOnError: true)
        //new SqtPais(...).save(flush: true, failOnError: true)
        //SqtPais sqtPais = new SqtPais(...).save(flush: true, failOnError: true)
        //new SqtPais(...).save(flush: true, failOnError: true)
        //new SqtPais(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPais.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPaisService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPais> sqtPaisList = sqtPaisService.list(max: 2, offset: 2)

        then:
        sqtPaisList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPaisService.count() == 5
    }

    void "test delete"() {
        Long sqtPaisId = setupData()

        expect:
        sqtPaisService.count() == 5

        when:
        sqtPaisService.delete(sqtPaisId)
        sessionFactory.currentSession.flush()

        then:
        sqtPaisService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPais sqtPais = new SqtPais()
        sqtPaisService.save(sqtPais)

        then:
        sqtPais.id != null
    }
}
