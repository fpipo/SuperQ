package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtNuevoGrupoServiceSpec extends Specification {

    SqtNuevoGrupoService sqtNuevoGrupoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtNuevoGrupo(...).save(flush: true, failOnError: true)
        //new SqtNuevoGrupo(...).save(flush: true, failOnError: true)
        //SqtNuevoGrupo sqtNuevoGrupo = new SqtNuevoGrupo(...).save(flush: true, failOnError: true)
        //new SqtNuevoGrupo(...).save(flush: true, failOnError: true)
        //new SqtNuevoGrupo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtNuevoGrupo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtNuevoGrupoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtNuevoGrupo> sqtNuevoGrupoList = sqtNuevoGrupoService.list(max: 2, offset: 2)

        then:
        sqtNuevoGrupoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtNuevoGrupoService.count() == 5
    }

    void "test delete"() {
        Long sqtNuevoGrupoId = setupData()

        expect:
        sqtNuevoGrupoService.count() == 5

        when:
        sqtNuevoGrupoService.delete(sqtNuevoGrupoId)
        sessionFactory.currentSession.flush()

        then:
        sqtNuevoGrupoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtNuevoGrupo sqtNuevoGrupo = new SqtNuevoGrupo()
        sqtNuevoGrupoService.save(sqtNuevoGrupo)

        then:
        sqtNuevoGrupo.id != null
    }
}
