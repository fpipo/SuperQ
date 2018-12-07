package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleDevolucionServiceSpec extends Specification {

    SqtDetalleDevolucionService sqtDetalleDevolucionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleDevolucion(...).save(flush: true, failOnError: true)
        //new SqtDetalleDevolucion(...).save(flush: true, failOnError: true)
        //SqtDetalleDevolucion sqtDetalleDevolucion = new SqtDetalleDevolucion(...).save(flush: true, failOnError: true)
        //new SqtDetalleDevolucion(...).save(flush: true, failOnError: true)
        //new SqtDetalleDevolucion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleDevolucion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleDevolucionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleDevolucion> sqtDetalleDevolucionList = sqtDetalleDevolucionService.list(max: 2, offset: 2)

        then:
        sqtDetalleDevolucionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleDevolucionService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleDevolucionId = setupData()

        expect:
        sqtDetalleDevolucionService.count() == 5

        when:
        sqtDetalleDevolucionService.delete(sqtDetalleDevolucionId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleDevolucionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleDevolucion sqtDetalleDevolucion = new SqtDetalleDevolucion()
        sqtDetalleDevolucionService.save(sqtDetalleDevolucion)

        then:
        sqtDetalleDevolucion.id != null
    }
}
