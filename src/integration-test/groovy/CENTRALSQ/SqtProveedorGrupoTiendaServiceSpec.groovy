package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProveedorGrupoTiendaServiceSpec extends Specification {

    SqtProveedorGrupoTiendaService sqtProveedorGrupoTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProveedorGrupoTienda(...).save(flush: true, failOnError: true)
        //new SqtProveedorGrupoTienda(...).save(flush: true, failOnError: true)
        //SqtProveedorGrupoTienda sqtProveedorGrupoTienda = new SqtProveedorGrupoTienda(...).save(flush: true, failOnError: true)
        //new SqtProveedorGrupoTienda(...).save(flush: true, failOnError: true)
        //new SqtProveedorGrupoTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProveedorGrupoTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProveedorGrupoTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProveedorGrupoTienda> sqtProveedorGrupoTiendaList = sqtProveedorGrupoTiendaService.list(max: 2, offset: 2)

        then:
        sqtProveedorGrupoTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProveedorGrupoTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtProveedorGrupoTiendaId = setupData()

        expect:
        sqtProveedorGrupoTiendaService.count() == 5

        when:
        sqtProveedorGrupoTiendaService.delete(sqtProveedorGrupoTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtProveedorGrupoTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProveedorGrupoTienda sqtProveedorGrupoTienda = new SqtProveedorGrupoTienda()
        sqtProveedorGrupoTiendaService.save(sqtProveedorGrupoTienda)

        then:
        sqtProveedorGrupoTienda.id != null
    }
}
