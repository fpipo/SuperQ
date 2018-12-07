package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtBitacoraServiceSpec extends Specification {

    SqtBitacoraService sqtBitacoraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtBitacora(...).save(flush: true, failOnError: true)
        //new SqtBitacora(...).save(flush: true, failOnError: true)
        //SqtBitacora sqtBitacora = new SqtBitacora(...).save(flush: true, failOnError: true)
        //new SqtBitacora(...).save(flush: true, failOnError: true)
        //new SqtBitacora(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtBitacora.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtBitacoraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtBitacora> sqtBitacoraList = sqtBitacoraService.list(max: 2, offset: 2)

        then:
        sqtBitacoraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtBitacoraService.count() == 5
    }

    void "test delete"() {
        Long sqtBitacoraId = setupData()

        expect:
        sqtBitacoraService.count() == 5

        when:
        sqtBitacoraService.delete(sqtBitacoraId)
        sessionFactory.currentSession.flush()

        then:
        sqtBitacoraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtBitacora sqtBitacora = new SqtBitacora()
        sqtBitacoraService.save(sqtBitacora)

        then:
        sqtBitacora.id != null
    }
}
