package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtReembolsoServiceSpec extends Specification {

    SqtReembolsoService sqtReembolsoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtReembolso(...).save(flush: true, failOnError: true)
        //new SqtReembolso(...).save(flush: true, failOnError: true)
        //SqtReembolso sqtReembolso = new SqtReembolso(...).save(flush: true, failOnError: true)
        //new SqtReembolso(...).save(flush: true, failOnError: true)
        //new SqtReembolso(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtReembolso.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtReembolsoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtReembolso> sqtReembolsoList = sqtReembolsoService.list(max: 2, offset: 2)

        then:
        sqtReembolsoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtReembolsoService.count() == 5
    }

    void "test delete"() {
        Long sqtReembolsoId = setupData()

        expect:
        sqtReembolsoService.count() == 5

        when:
        sqtReembolsoService.delete(sqtReembolsoId)
        sessionFactory.currentSession.flush()

        then:
        sqtReembolsoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtReembolso sqtReembolso = new SqtReembolso()
        sqtReembolsoService.save(sqtReembolso)

        then:
        sqtReembolso.id != null
    }
}
