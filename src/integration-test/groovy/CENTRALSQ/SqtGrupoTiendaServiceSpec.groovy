package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtGrupoTiendaServiceSpec extends Specification {

    SqtGrupoTiendaService sqtGrupoTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtGrupoTienda(...).save(flush: true, failOnError: true)
        //new SqtGrupoTienda(...).save(flush: true, failOnError: true)
        //SqtGrupoTienda sqtGrupoTienda = new SqtGrupoTienda(...).save(flush: true, failOnError: true)
        //new SqtGrupoTienda(...).save(flush: true, failOnError: true)
        //new SqtGrupoTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtGrupoTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtGrupoTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtGrupoTienda> sqtGrupoTiendaList = sqtGrupoTiendaService.list(max: 2, offset: 2)

        then:
        sqtGrupoTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtGrupoTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtGrupoTiendaId = setupData()

        expect:
        sqtGrupoTiendaService.count() == 5

        when:
        sqtGrupoTiendaService.delete(sqtGrupoTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtGrupoTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtGrupoTienda sqtGrupoTienda = new SqtGrupoTienda()
        sqtGrupoTiendaService.save(sqtGrupoTienda)

        then:
        sqtGrupoTienda.id != null
    }
}
