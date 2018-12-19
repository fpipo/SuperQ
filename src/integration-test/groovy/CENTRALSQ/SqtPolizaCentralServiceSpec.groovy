package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPolizaCentralServiceSpec extends Specification {

    SqtPolizaCentralService sqtPolizaCentralService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPolizaCentral(...).save(flush: true, failOnError: true)
        //new SqtPolizaCentral(...).save(flush: true, failOnError: true)
        //SqtPolizaCentral sqtPolizaCentral = new SqtPolizaCentral(...).save(flush: true, failOnError: true)
        //new SqtPolizaCentral(...).save(flush: true, failOnError: true)
        //new SqtPolizaCentral(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPolizaCentral.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPolizaCentralService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPolizaCentral> sqtPolizaCentralList = sqtPolizaCentralService.list(max: 2, offset: 2)

        then:
        sqtPolizaCentralList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPolizaCentralService.count() == 5
    }

    void "test delete"() {
        Long sqtPolizaCentralId = setupData()

        expect:
        sqtPolizaCentralService.count() == 5

        when:
        sqtPolizaCentralService.delete(sqtPolizaCentralId)
        sessionFactory.currentSession.flush()

        then:
        sqtPolizaCentralService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPolizaCentral sqtPolizaCentral = new SqtPolizaCentral()
        sqtPolizaCentralService.save(sqtPolizaCentral)

        then:
        sqtPolizaCentral.id != null
    }
}
