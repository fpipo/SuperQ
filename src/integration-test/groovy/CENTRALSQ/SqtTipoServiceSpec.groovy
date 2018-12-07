package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTipoServiceSpec extends Specification {

    SqtTipoService sqtTipoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTipo(...).save(flush: true, failOnError: true)
        //new SqtTipo(...).save(flush: true, failOnError: true)
        //SqtTipo sqtTipo = new SqtTipo(...).save(flush: true, failOnError: true)
        //new SqtTipo(...).save(flush: true, failOnError: true)
        //new SqtTipo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTipo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTipoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTipo> sqtTipoList = sqtTipoService.list(max: 2, offset: 2)

        then:
        sqtTipoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTipoService.count() == 5
    }

    void "test delete"() {
        Long sqtTipoId = setupData()

        expect:
        sqtTipoService.count() == 5

        when:
        sqtTipoService.delete(sqtTipoId)
        sessionFactory.currentSession.flush()

        then:
        sqtTipoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTipo sqtTipo = new SqtTipo()
        sqtTipoService.save(sqtTipo)

        then:
        sqtTipo.id != null
    }
}
