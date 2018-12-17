package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtUsuarioGrupoUsuarioServiceSpec extends Specification {

    SqtUsuarioGrupoUsuarioService sqtUsuarioGrupoUsuarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtUsuarioGrupoUsuario(...).save(flush: true, failOnError: true)
        //new SqtUsuarioGrupoUsuario(...).save(flush: true, failOnError: true)
        //SqtUsuarioGrupoUsuario sqtUsuarioGrupoUsuario = new SqtUsuarioGrupoUsuario(...).save(flush: true, failOnError: true)
        //new SqtUsuarioGrupoUsuario(...).save(flush: true, failOnError: true)
        //new SqtUsuarioGrupoUsuario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtUsuarioGrupoUsuario.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtUsuarioGrupoUsuarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtUsuarioGrupoUsuario> sqtUsuarioGrupoUsuarioList = sqtUsuarioGrupoUsuarioService.list(max: 2, offset: 2)

        then:
        sqtUsuarioGrupoUsuarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtUsuarioGrupoUsuarioService.count() == 5
    }

    void "test delete"() {
        Long sqtUsuarioGrupoUsuarioId = setupData()

        expect:
        sqtUsuarioGrupoUsuarioService.count() == 5

        when:
        sqtUsuarioGrupoUsuarioService.delete(sqtUsuarioGrupoUsuarioId)
        sessionFactory.currentSession.flush()

        then:
        sqtUsuarioGrupoUsuarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtUsuarioGrupoUsuario sqtUsuarioGrupoUsuario = new SqtUsuarioGrupoUsuario()
        sqtUsuarioGrupoUsuarioService.save(sqtUsuarioGrupoUsuario)

        then:
        sqtUsuarioGrupoUsuario.id != null
    }
}
