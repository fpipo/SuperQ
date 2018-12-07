package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtSubgrupoServiceSpec extends Specification {

    SqtSubgrupoService sqtSubgrupoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtSubgrupo(...).save(flush: true, failOnError: true)
        //new SqtSubgrupo(...).save(flush: true, failOnError: true)
        //SqtSubgrupo sqtSubgrupo = new SqtSubgrupo(...).save(flush: true, failOnError: true)
        //new SqtSubgrupo(...).save(flush: true, failOnError: true)
        //new SqtSubgrupo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtSubgrupo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtSubgrupoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtSubgrupo> sqtSubgrupoList = sqtSubgrupoService.list(max: 2, offset: 2)

        then:
        sqtSubgrupoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtSubgrupoService.count() == 5
    }

    void "test delete"() {
        Long sqtSubgrupoId = setupData()

        expect:
        sqtSubgrupoService.count() == 5

        when:
        sqtSubgrupoService.delete(sqtSubgrupoId)
        sessionFactory.currentSession.flush()

        then:
        sqtSubgrupoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtSubgrupo sqtSubgrupo = new SqtSubgrupo()
        sqtSubgrupoService.save(sqtSubgrupo)

        then:
        sqtSubgrupo.id != null
    }
}
