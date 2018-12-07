package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtReporteServiceSpec extends Specification {

    SqtReporteService sqtReporteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtReporte(...).save(flush: true, failOnError: true)
        //new SqtReporte(...).save(flush: true, failOnError: true)
        //SqtReporte sqtReporte = new SqtReporte(...).save(flush: true, failOnError: true)
        //new SqtReporte(...).save(flush: true, failOnError: true)
        //new SqtReporte(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtReporte.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtReporteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtReporte> sqtReporteList = sqtReporteService.list(max: 2, offset: 2)

        then:
        sqtReporteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtReporteService.count() == 5
    }

    void "test delete"() {
        Long sqtReporteId = setupData()

        expect:
        sqtReporteService.count() == 5

        when:
        sqtReporteService.delete(sqtReporteId)
        sessionFactory.currentSession.flush()

        then:
        sqtReporteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtReporte sqtReporte = new SqtReporte()
        sqtReporteService.save(sqtReporte)

        then:
        sqtReporte.id != null
    }
}
