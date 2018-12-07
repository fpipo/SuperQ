package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleBitacoraServiceSpec extends Specification {

    SqtDetalleBitacoraService sqtDetalleBitacoraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleBitacora(...).save(flush: true, failOnError: true)
        //new SqtDetalleBitacora(...).save(flush: true, failOnError: true)
        //SqtDetalleBitacora sqtDetalleBitacora = new SqtDetalleBitacora(...).save(flush: true, failOnError: true)
        //new SqtDetalleBitacora(...).save(flush: true, failOnError: true)
        //new SqtDetalleBitacora(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleBitacora.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleBitacoraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleBitacora> sqtDetalleBitacoraList = sqtDetalleBitacoraService.list(max: 2, offset: 2)

        then:
        sqtDetalleBitacoraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleBitacoraService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleBitacoraId = setupData()

        expect:
        sqtDetalleBitacoraService.count() == 5

        when:
        sqtDetalleBitacoraService.delete(sqtDetalleBitacoraId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleBitacoraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleBitacora sqtDetalleBitacora = new SqtDetalleBitacora()
        sqtDetalleBitacoraService.save(sqtDetalleBitacora)

        then:
        sqtDetalleBitacora.id != null
    }
}
