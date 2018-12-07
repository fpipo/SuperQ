package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCuentaBancoServiceSpec extends Specification {

    SqtCuentaBancoService sqtCuentaBancoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCuentaBanco(...).save(flush: true, failOnError: true)
        //new SqtCuentaBanco(...).save(flush: true, failOnError: true)
        //SqtCuentaBanco sqtCuentaBanco = new SqtCuentaBanco(...).save(flush: true, failOnError: true)
        //new SqtCuentaBanco(...).save(flush: true, failOnError: true)
        //new SqtCuentaBanco(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCuentaBanco.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCuentaBancoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCuentaBanco> sqtCuentaBancoList = sqtCuentaBancoService.list(max: 2, offset: 2)

        then:
        sqtCuentaBancoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCuentaBancoService.count() == 5
    }

    void "test delete"() {
        Long sqtCuentaBancoId = setupData()

        expect:
        sqtCuentaBancoService.count() == 5

        when:
        sqtCuentaBancoService.delete(sqtCuentaBancoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCuentaBancoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCuentaBanco sqtCuentaBanco = new SqtCuentaBanco()
        sqtCuentaBancoService.save(sqtCuentaBanco)

        then:
        sqtCuentaBanco.id != null
    }
}
