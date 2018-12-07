package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDevolucionServiceSpec extends Specification {

    SqtDevolucionService sqtDevolucionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDevolucion(...).save(flush: true, failOnError: true)
        //new SqtDevolucion(...).save(flush: true, failOnError: true)
        //SqtDevolucion sqtDevolucion = new SqtDevolucion(...).save(flush: true, failOnError: true)
        //new SqtDevolucion(...).save(flush: true, failOnError: true)
        //new SqtDevolucion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDevolucion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDevolucionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDevolucion> sqtDevolucionList = sqtDevolucionService.list(max: 2, offset: 2)

        then:
        sqtDevolucionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDevolucionService.count() == 5
    }

    void "test delete"() {
        Long sqtDevolucionId = setupData()

        expect:
        sqtDevolucionService.count() == 5

        when:
        sqtDevolucionService.delete(sqtDevolucionId)
        sessionFactory.currentSession.flush()

        then:
        sqtDevolucionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDevolucion sqtDevolucion = new SqtDevolucion()
        sqtDevolucionService.save(sqtDevolucion)

        then:
        sqtDevolucion.id != null
    }
}
