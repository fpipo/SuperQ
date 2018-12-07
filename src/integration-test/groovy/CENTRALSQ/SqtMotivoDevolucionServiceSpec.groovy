package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMotivoDevolucionServiceSpec extends Specification {

    SqtMotivoDevolucionService sqtMotivoDevolucionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMotivoDevolucion(...).save(flush: true, failOnError: true)
        //new SqtMotivoDevolucion(...).save(flush: true, failOnError: true)
        //SqtMotivoDevolucion sqtMotivoDevolucion = new SqtMotivoDevolucion(...).save(flush: true, failOnError: true)
        //new SqtMotivoDevolucion(...).save(flush: true, failOnError: true)
        //new SqtMotivoDevolucion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMotivoDevolucion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMotivoDevolucionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMotivoDevolucion> sqtMotivoDevolucionList = sqtMotivoDevolucionService.list(max: 2, offset: 2)

        then:
        sqtMotivoDevolucionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMotivoDevolucionService.count() == 5
    }

    void "test delete"() {
        Long sqtMotivoDevolucionId = setupData()

        expect:
        sqtMotivoDevolucionService.count() == 5

        when:
        sqtMotivoDevolucionService.delete(sqtMotivoDevolucionId)
        sessionFactory.currentSession.flush()

        then:
        sqtMotivoDevolucionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMotivoDevolucion sqtMotivoDevolucion = new SqtMotivoDevolucion()
        sqtMotivoDevolucionService.save(sqtMotivoDevolucion)

        then:
        sqtMotivoDevolucion.id != null
    }
}
