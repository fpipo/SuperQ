package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCodigoCambioServiceSpec extends Specification {

    SqtCodigoCambioService sqtCodigoCambioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCodigoCambio(...).save(flush: true, failOnError: true)
        //new SqtCodigoCambio(...).save(flush: true, failOnError: true)
        //SqtCodigoCambio sqtCodigoCambio = new SqtCodigoCambio(...).save(flush: true, failOnError: true)
        //new SqtCodigoCambio(...).save(flush: true, failOnError: true)
        //new SqtCodigoCambio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCodigoCambio.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCodigoCambioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCodigoCambio> sqtCodigoCambioList = sqtCodigoCambioService.list(max: 2, offset: 2)

        then:
        sqtCodigoCambioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCodigoCambioService.count() == 5
    }

    void "test delete"() {
        Long sqtCodigoCambioId = setupData()

        expect:
        sqtCodigoCambioService.count() == 5

        when:
        sqtCodigoCambioService.delete(sqtCodigoCambioId)
        sessionFactory.currentSession.flush()

        then:
        sqtCodigoCambioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCodigoCambio sqtCodigoCambio = new SqtCodigoCambio()
        sqtCodigoCambioService.save(sqtCodigoCambio)

        then:
        sqtCodigoCambio.id != null
    }
}
