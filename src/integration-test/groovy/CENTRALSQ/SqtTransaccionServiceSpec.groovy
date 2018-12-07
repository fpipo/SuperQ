package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTransaccionServiceSpec extends Specification {

    SqtTransaccionService sqtTransaccionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTransaccion(...).save(flush: true, failOnError: true)
        //new SqtTransaccion(...).save(flush: true, failOnError: true)
        //SqtTransaccion sqtTransaccion = new SqtTransaccion(...).save(flush: true, failOnError: true)
        //new SqtTransaccion(...).save(flush: true, failOnError: true)
        //new SqtTransaccion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTransaccion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTransaccionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTransaccion> sqtTransaccionList = sqtTransaccionService.list(max: 2, offset: 2)

        then:
        sqtTransaccionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTransaccionService.count() == 5
    }

    void "test delete"() {
        Long sqtTransaccionId = setupData()

        expect:
        sqtTransaccionService.count() == 5

        when:
        sqtTransaccionService.delete(sqtTransaccionId)
        sessionFactory.currentSession.flush()

        then:
        sqtTransaccionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTransaccion sqtTransaccion = new SqtTransaccion()
        sqtTransaccionService.save(sqtTransaccion)

        then:
        sqtTransaccion.id != null
    }
}
