package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtKardexBanamexServiceSpec extends Specification {

    SqtKardexBanamexService sqtKardexBanamexService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtKardexBanamex(...).save(flush: true, failOnError: true)
        //new SqtKardexBanamex(...).save(flush: true, failOnError: true)
        //SqtKardexBanamex sqtKardexBanamex = new SqtKardexBanamex(...).save(flush: true, failOnError: true)
        //new SqtKardexBanamex(...).save(flush: true, failOnError: true)
        //new SqtKardexBanamex(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtKardexBanamex.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtKardexBanamexService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtKardexBanamex> sqtKardexBanamexList = sqtKardexBanamexService.list(max: 2, offset: 2)

        then:
        sqtKardexBanamexList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtKardexBanamexService.count() == 5
    }

    void "test delete"() {
        Long sqtKardexBanamexId = setupData()

        expect:
        sqtKardexBanamexService.count() == 5

        when:
        sqtKardexBanamexService.delete(sqtKardexBanamexId)
        sessionFactory.currentSession.flush()

        then:
        sqtKardexBanamexService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtKardexBanamex sqtKardexBanamex = new SqtKardexBanamex()
        sqtKardexBanamexService.save(sqtKardexBanamex)

        then:
        sqtKardexBanamex.id != null
    }
}
