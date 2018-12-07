package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCatalgoPanHorneadoServiceSpec extends Specification {

    SqtCatalgoPanHorneadoService sqtCatalgoPanHorneadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCatalgoPanHorneado(...).save(flush: true, failOnError: true)
        //new SqtCatalgoPanHorneado(...).save(flush: true, failOnError: true)
        //SqtCatalgoPanHorneado sqtCatalgoPanHorneado = new SqtCatalgoPanHorneado(...).save(flush: true, failOnError: true)
        //new SqtCatalgoPanHorneado(...).save(flush: true, failOnError: true)
        //new SqtCatalgoPanHorneado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCatalgoPanHorneado.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCatalgoPanHorneadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCatalgoPanHorneado> sqtCatalgoPanHorneadoList = sqtCatalgoPanHorneadoService.list(max: 2, offset: 2)

        then:
        sqtCatalgoPanHorneadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCatalgoPanHorneadoService.count() == 5
    }

    void "test delete"() {
        Long sqtCatalgoPanHorneadoId = setupData()

        expect:
        sqtCatalgoPanHorneadoService.count() == 5

        when:
        sqtCatalgoPanHorneadoService.delete(sqtCatalgoPanHorneadoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCatalgoPanHorneadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCatalgoPanHorneado sqtCatalgoPanHorneado = new SqtCatalgoPanHorneado()
        sqtCatalgoPanHorneadoService.save(sqtCatalgoPanHorneado)

        then:
        sqtCatalgoPanHorneado.id != null
    }
}
