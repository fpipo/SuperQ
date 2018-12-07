package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRecargaServiciosServiceSpec extends Specification {

    SqtRecargaServiciosService sqtRecargaServiciosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRecargaServicios(...).save(flush: true, failOnError: true)
        //new SqtRecargaServicios(...).save(flush: true, failOnError: true)
        //SqtRecargaServicios sqtRecargaServicios = new SqtRecargaServicios(...).save(flush: true, failOnError: true)
        //new SqtRecargaServicios(...).save(flush: true, failOnError: true)
        //new SqtRecargaServicios(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRecargaServicios.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRecargaServiciosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRecargaServicios> sqtRecargaServiciosList = sqtRecargaServiciosService.list(max: 2, offset: 2)

        then:
        sqtRecargaServiciosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRecargaServiciosService.count() == 5
    }

    void "test delete"() {
        Long sqtRecargaServiciosId = setupData()

        expect:
        sqtRecargaServiciosService.count() == 5

        when:
        sqtRecargaServiciosService.delete(sqtRecargaServiciosId)
        sessionFactory.currentSession.flush()

        then:
        sqtRecargaServiciosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRecargaServicios sqtRecargaServicios = new SqtRecargaServicios()
        sqtRecargaServiciosService.save(sqtRecargaServicios)

        then:
        sqtRecargaServicios.id != null
    }
}
