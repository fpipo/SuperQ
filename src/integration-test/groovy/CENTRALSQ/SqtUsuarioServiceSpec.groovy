package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtUsuarioServiceSpec extends Specification {

    SqtUsuarioService sqtUsuarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtUsuario(...).save(flush: true, failOnError: true)
        //new SqtUsuario(...).save(flush: true, failOnError: true)
        //SqtUsuario sqtUsuario = new SqtUsuario(...).save(flush: true, failOnError: true)
        //new SqtUsuario(...).save(flush: true, failOnError: true)
        //new SqtUsuario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtUsuario.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtUsuarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtUsuario> sqtUsuarioList = sqtUsuarioService.list(max: 2, offset: 2)

        then:
        sqtUsuarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtUsuarioService.count() == 5
    }

    void "test delete"() {
        Long sqtUsuarioId = setupData()

        expect:
        sqtUsuarioService.count() == 5

        when:
        sqtUsuarioService.delete(sqtUsuarioId)
        sessionFactory.currentSession.flush()

        then:
        sqtUsuarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtUsuario sqtUsuario = new SqtUsuario()
        sqtUsuarioService.save(sqtUsuario)

        then:
        sqtUsuario.id != null
    }
}
