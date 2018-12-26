package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMotivoAjusteServiceSpec extends Specification {

    SqtMotivoAjusteService sqtMotivoAjusteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMotivoAjuste(...).save(flush: true, failOnError: true)
        //new SqtMotivoAjuste(...).save(flush: true, failOnError: true)
        //SqtMotivoAjuste sqtMotivoAjuste = new SqtMotivoAjuste(...).save(flush: true, failOnError: true)
        //new SqtMotivoAjuste(...).save(flush: true, failOnError: true)
        //new SqtMotivoAjuste(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMotivoAjuste.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMotivoAjusteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMotivoAjuste> sqtMotivoAjusteList = sqtMotivoAjusteService.list(max: 2, offset: 2)

        then:
        sqtMotivoAjusteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMotivoAjusteService.count() == 5
    }

    void "test delete"() {
        Long sqtMotivoAjusteId = setupData()

        expect:
        sqtMotivoAjusteService.count() == 5

        when:
        sqtMotivoAjusteService.delete(sqtMotivoAjusteId)
        sessionFactory.currentSession.flush()

        then:
        sqtMotivoAjusteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMotivoAjuste sqtMotivoAjuste = new SqtMotivoAjuste()
        sqtMotivoAjusteService.save(sqtMotivoAjuste)

        then:
        sqtMotivoAjuste.id != null
    }
}
