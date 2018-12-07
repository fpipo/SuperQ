package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtGrupoServiceSpec extends Specification {

    SqtGrupoService sqtGrupoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtGrupo(...).save(flush: true, failOnError: true)
        //new SqtGrupo(...).save(flush: true, failOnError: true)
        //SqtGrupo sqtGrupo = new SqtGrupo(...).save(flush: true, failOnError: true)
        //new SqtGrupo(...).save(flush: true, failOnError: true)
        //new SqtGrupo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtGrupo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtGrupoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtGrupo> sqtGrupoList = sqtGrupoService.list(max: 2, offset: 2)

        then:
        sqtGrupoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtGrupoService.count() == 5
    }

    void "test delete"() {
        Long sqtGrupoId = setupData()

        expect:
        sqtGrupoService.count() == 5

        when:
        sqtGrupoService.delete(sqtGrupoId)
        sessionFactory.currentSession.flush()

        then:
        sqtGrupoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtGrupo sqtGrupo = new SqtGrupo()
        sqtGrupoService.save(sqtGrupo)

        then:
        sqtGrupo.id != null
    }
}
