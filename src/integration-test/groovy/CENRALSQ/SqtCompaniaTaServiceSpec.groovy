package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCompaniaTaServiceSpec extends Specification {

    SqtCompaniaTaService sqtCompaniaTaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCompaniaTa(...).save(flush: true, failOnError: true)
        //new SqtCompaniaTa(...).save(flush: true, failOnError: true)
        //SqtCompaniaTa sqtCompaniaTa = new SqtCompaniaTa(...).save(flush: true, failOnError: true)
        //new SqtCompaniaTa(...).save(flush: true, failOnError: true)
        //new SqtCompaniaTa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCompaniaTa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCompaniaTaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCompaniaTa> sqtCompaniaTaList = sqtCompaniaTaService.list(max: 2, offset: 2)

        then:
        sqtCompaniaTaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCompaniaTaService.count() == 5
    }

    void "test delete"() {
        Long sqtCompaniaTaId = setupData()

        expect:
        sqtCompaniaTaService.count() == 5

        when:
        sqtCompaniaTaService.delete(sqtCompaniaTaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCompaniaTaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCompaniaTa sqtCompaniaTa = new SqtCompaniaTa()
        sqtCompaniaTaService.save(sqtCompaniaTa)

        then:
        sqtCompaniaTa.id != null
    }
}
