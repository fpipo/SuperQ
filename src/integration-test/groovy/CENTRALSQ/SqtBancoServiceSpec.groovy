package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtBancoServiceSpec extends Specification {

    SqtBancoService sqtBancoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtBanco(...).save(flush: true, failOnError: true)
        //new SqtBanco(...).save(flush: true, failOnError: true)
        //SqtBanco sqtBanco = new SqtBanco(...).save(flush: true, failOnError: true)
        //new SqtBanco(...).save(flush: true, failOnError: true)
        //new SqtBanco(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtBanco.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtBancoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtBanco> sqtBancoList = sqtBancoService.list(max: 2, offset: 2)

        then:
        sqtBancoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtBancoService.count() == 5
    }

    void "test delete"() {
        Long sqtBancoId = setupData()

        expect:
        sqtBancoService.count() == 5

        when:
        sqtBancoService.delete(sqtBancoId)
        sessionFactory.currentSession.flush()

        then:
        sqtBancoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtBanco sqtBanco = new SqtBanco()
        sqtBancoService.save(sqtBanco)

        then:
        sqtBanco.id != null
    }
}
