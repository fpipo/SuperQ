package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtKardexServiceSpec extends Specification {

    SqtKardexService sqtKardexService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtKardex(...).save(flush: true, failOnError: true)
        //new SqtKardex(...).save(flush: true, failOnError: true)
        //SqtKardex sqtKardex = new SqtKardex(...).save(flush: true, failOnError: true)
        //new SqtKardex(...).save(flush: true, failOnError: true)
        //new SqtKardex(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtKardex.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtKardexService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtKardex> sqtKardexList = sqtKardexService.list(max: 2, offset: 2)

        then:
        sqtKardexList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtKardexService.count() == 5
    }

    void "test delete"() {
        Long sqtKardexId = setupData()

        expect:
        sqtKardexService.count() == 5

        when:
        sqtKardexService.delete(sqtKardexId)
        sessionFactory.currentSession.flush()

        then:
        sqtKardexService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtKardex sqtKardex = new SqtKardex()
        sqtKardexService.save(sqtKardex)

        then:
        sqtKardex.id != null
    }
}
