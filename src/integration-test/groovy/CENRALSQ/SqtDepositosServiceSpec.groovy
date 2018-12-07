package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDepositosServiceSpec extends Specification {

    SqtDepositosService sqtDepositosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDepositos(...).save(flush: true, failOnError: true)
        //new SqtDepositos(...).save(flush: true, failOnError: true)
        //SqtDepositos sqtDepositos = new SqtDepositos(...).save(flush: true, failOnError: true)
        //new SqtDepositos(...).save(flush: true, failOnError: true)
        //new SqtDepositos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDepositos.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDepositosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDepositos> sqtDepositosList = sqtDepositosService.list(max: 2, offset: 2)

        then:
        sqtDepositosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDepositosService.count() == 5
    }

    void "test delete"() {
        Long sqtDepositosId = setupData()

        expect:
        sqtDepositosService.count() == 5

        when:
        sqtDepositosService.delete(sqtDepositosId)
        sessionFactory.currentSession.flush()

        then:
        sqtDepositosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDepositos sqtDepositos = new SqtDepositos()
        sqtDepositosService.save(sqtDepositos)

        then:
        sqtDepositos.id != null
    }
}
