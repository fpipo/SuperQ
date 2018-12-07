package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtEstadoServiceSpec extends Specification {

    SqtEstadoService sqtEstadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtEstado(...).save(flush: true, failOnError: true)
        //new SqtEstado(...).save(flush: true, failOnError: true)
        //SqtEstado sqtEstado = new SqtEstado(...).save(flush: true, failOnError: true)
        //new SqtEstado(...).save(flush: true, failOnError: true)
        //new SqtEstado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtEstado.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtEstadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtEstado> sqtEstadoList = sqtEstadoService.list(max: 2, offset: 2)

        then:
        sqtEstadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtEstadoService.count() == 5
    }

    void "test delete"() {
        Long sqtEstadoId = setupData()

        expect:
        sqtEstadoService.count() == 5

        when:
        sqtEstadoService.delete(sqtEstadoId)
        sessionFactory.currentSession.flush()

        then:
        sqtEstadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtEstado sqtEstado = new SqtEstado()
        sqtEstadoService.save(sqtEstado)

        then:
        sqtEstado.id != null
    }
}
