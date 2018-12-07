package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAjusteServiceSpec extends Specification {

    SqtAjusteService sqtAjusteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAjuste(...).save(flush: true, failOnError: true)
        //new SqtAjuste(...).save(flush: true, failOnError: true)
        //SqtAjuste sqtAjuste = new SqtAjuste(...).save(flush: true, failOnError: true)
        //new SqtAjuste(...).save(flush: true, failOnError: true)
        //new SqtAjuste(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAjuste.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAjusteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAjuste> sqtAjusteList = sqtAjusteService.list(max: 2, offset: 2)

        then:
        sqtAjusteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAjusteService.count() == 5
    }

    void "test delete"() {
        Long sqtAjusteId = setupData()

        expect:
        sqtAjusteService.count() == 5

        when:
        sqtAjusteService.delete(sqtAjusteId)
        sessionFactory.currentSession.flush()

        then:
        sqtAjusteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAjuste sqtAjuste = new SqtAjuste()
        sqtAjusteService.save(sqtAjuste)

        then:
        sqtAjuste.id != null
    }
}
