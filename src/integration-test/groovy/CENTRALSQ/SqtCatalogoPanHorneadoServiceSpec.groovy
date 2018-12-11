package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCatalogoPanHorneadoServiceSpec extends Specification {

    SqtCatalogoPanHorneadoService sqtCatalogoPanHorneadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCatalogoPanHorneado(...).save(flush: true, failOnError: true)
        //new SqtCatalogoPanHorneado(...).save(flush: true, failOnError: true)
        //SqtCatalogoPanHorneado sqtCatalogoPanHorneado = new SqtCatalogoPanHorneado(...).save(flush: true, failOnError: true)
        //new SqtCatalogoPanHorneado(...).save(flush: true, failOnError: true)
        //new SqtCatalogoPanHorneado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCatalogoPanHorneado.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCatalogoPanHorneadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCatalogoPanHorneado> sqtCatalogoPanHorneadoList = sqtCatalogoPanHorneadoService.list(max: 2, offset: 2)

        then:
        sqtCatalogoPanHorneadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCatalogoPanHorneadoService.count() == 5
    }

    void "test delete"() {
        Long sqtCatalogoPanHorneadoId = setupData()

        expect:
        sqtCatalogoPanHorneadoService.count() == 5

        when:
        sqtCatalogoPanHorneadoService.delete(sqtCatalogoPanHorneadoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCatalogoPanHorneadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCatalogoPanHorneado sqtCatalogoPanHorneado = new SqtCatalogoPanHorneado()
        sqtCatalogoPanHorneadoService.save(sqtCatalogoPanHorneado)

        then:
        sqtCatalogoPanHorneado.id != null
    }
}
