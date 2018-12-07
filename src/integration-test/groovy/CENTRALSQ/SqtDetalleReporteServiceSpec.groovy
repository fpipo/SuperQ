package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleReporteServiceSpec extends Specification {

    SqtDetalleReporteService sqtDetalleReporteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleReporte(...).save(flush: true, failOnError: true)
        //new SqtDetalleReporte(...).save(flush: true, failOnError: true)
        //SqtDetalleReporte sqtDetalleReporte = new SqtDetalleReporte(...).save(flush: true, failOnError: true)
        //new SqtDetalleReporte(...).save(flush: true, failOnError: true)
        //new SqtDetalleReporte(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleReporte.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleReporteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleReporte> sqtDetalleReporteList = sqtDetalleReporteService.list(max: 2, offset: 2)

        then:
        sqtDetalleReporteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleReporteService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleReporteId = setupData()

        expect:
        sqtDetalleReporteService.count() == 5

        when:
        sqtDetalleReporteService.delete(sqtDetalleReporteId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleReporteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleReporte sqtDetalleReporte = new SqtDetalleReporte()
        sqtDetalleReporteService.save(sqtDetalleReporte)

        then:
        sqtDetalleReporte.id != null
    }
}
