package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDepositoCierreServiceSpec extends Specification {

    SqtDepositoCierreService sqtDepositoCierreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDepositoCierre(...).save(flush: true, failOnError: true)
        //new SqtDepositoCierre(...).save(flush: true, failOnError: true)
        //SqtDepositoCierre sqtDepositoCierre = new SqtDepositoCierre(...).save(flush: true, failOnError: true)
        //new SqtDepositoCierre(...).save(flush: true, failOnError: true)
        //new SqtDepositoCierre(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDepositoCierre.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDepositoCierreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDepositoCierre> sqtDepositoCierreList = sqtDepositoCierreService.list(max: 2, offset: 2)

        then:
        sqtDepositoCierreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDepositoCierreService.count() == 5
    }

    void "test delete"() {
        Long sqtDepositoCierreId = setupData()

        expect:
        sqtDepositoCierreService.count() == 5

        when:
        sqtDepositoCierreService.delete(sqtDepositoCierreId)
        sessionFactory.currentSession.flush()

        then:
        sqtDepositoCierreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDepositoCierre sqtDepositoCierre = new SqtDepositoCierre()
        sqtDepositoCierreService.save(sqtDepositoCierre)

        then:
        sqtDepositoCierre.id != null
    }
}
