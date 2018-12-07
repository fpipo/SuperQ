package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtEmisoresRemesaServiceSpec extends Specification {

    SqtEmisoresRemesaService sqtEmisoresRemesaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtEmisoresRemesa(...).save(flush: true, failOnError: true)
        //new SqtEmisoresRemesa(...).save(flush: true, failOnError: true)
        //SqtEmisoresRemesa sqtEmisoresRemesa = new SqtEmisoresRemesa(...).save(flush: true, failOnError: true)
        //new SqtEmisoresRemesa(...).save(flush: true, failOnError: true)
        //new SqtEmisoresRemesa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtEmisoresRemesa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtEmisoresRemesaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtEmisoresRemesa> sqtEmisoresRemesaList = sqtEmisoresRemesaService.list(max: 2, offset: 2)

        then:
        sqtEmisoresRemesaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtEmisoresRemesaService.count() == 5
    }

    void "test delete"() {
        Long sqtEmisoresRemesaId = setupData()

        expect:
        sqtEmisoresRemesaService.count() == 5

        when:
        sqtEmisoresRemesaService.delete(sqtEmisoresRemesaId)
        sessionFactory.currentSession.flush()

        then:
        sqtEmisoresRemesaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtEmisoresRemesa sqtEmisoresRemesa = new SqtEmisoresRemesa()
        sqtEmisoresRemesaService.save(sqtEmisoresRemesa)

        then:
        sqtEmisoresRemesa.id != null
    }
}
