package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleTraspasoServiceSpec extends Specification {

    SqtDetalleTraspasoService sqtDetalleTraspasoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleTraspaso(...).save(flush: true, failOnError: true)
        //new SqtDetalleTraspaso(...).save(flush: true, failOnError: true)
        //SqtDetalleTraspaso sqtDetalleTraspaso = new SqtDetalleTraspaso(...).save(flush: true, failOnError: true)
        //new SqtDetalleTraspaso(...).save(flush: true, failOnError: true)
        //new SqtDetalleTraspaso(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleTraspaso.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleTraspasoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleTraspaso> sqtDetalleTraspasoList = sqtDetalleTraspasoService.list(max: 2, offset: 2)

        then:
        sqtDetalleTraspasoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleTraspasoService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleTraspasoId = setupData()

        expect:
        sqtDetalleTraspasoService.count() == 5

        when:
        sqtDetalleTraspasoService.delete(sqtDetalleTraspasoId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleTraspasoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleTraspaso sqtDetalleTraspaso = new SqtDetalleTraspaso()
        sqtDetalleTraspasoService.save(sqtDetalleTraspaso)

        then:
        sqtDetalleTraspaso.id != null
    }
}
