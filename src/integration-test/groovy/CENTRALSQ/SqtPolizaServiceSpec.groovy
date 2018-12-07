package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPolizaServiceSpec extends Specification {

    SqtPolizaService sqtPolizaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPoliza(...).save(flush: true, failOnError: true)
        //new SqtPoliza(...).save(flush: true, failOnError: true)
        //SqtPoliza sqtPoliza = new SqtPoliza(...).save(flush: true, failOnError: true)
        //new SqtPoliza(...).save(flush: true, failOnError: true)
        //new SqtPoliza(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPoliza.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPolizaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPoliza> sqtPolizaList = sqtPolizaService.list(max: 2, offset: 2)

        then:
        sqtPolizaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPolizaService.count() == 5
    }

    void "test delete"() {
        Long sqtPolizaId = setupData()

        expect:
        sqtPolizaService.count() == 5

        when:
        sqtPolizaService.delete(sqtPolizaId)
        sessionFactory.currentSession.flush()

        then:
        sqtPolizaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPoliza sqtPoliza = new SqtPoliza()
        sqtPolizaService.save(sqtPoliza)

        then:
        sqtPoliza.id != null
    }
}
