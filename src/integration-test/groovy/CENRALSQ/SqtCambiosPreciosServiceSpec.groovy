package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCambiosPreciosServiceSpec extends Specification {

    SqtCambiosPreciosService sqtCambiosPreciosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCambiosPrecios(...).save(flush: true, failOnError: true)
        //new SqtCambiosPrecios(...).save(flush: true, failOnError: true)
        //SqtCambiosPrecios sqtCambiosPrecios = new SqtCambiosPrecios(...).save(flush: true, failOnError: true)
        //new SqtCambiosPrecios(...).save(flush: true, failOnError: true)
        //new SqtCambiosPrecios(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCambiosPrecios.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCambiosPreciosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCambiosPrecios> sqtCambiosPreciosList = sqtCambiosPreciosService.list(max: 2, offset: 2)

        then:
        sqtCambiosPreciosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCambiosPreciosService.count() == 5
    }

    void "test delete"() {
        Long sqtCambiosPreciosId = setupData()

        expect:
        sqtCambiosPreciosService.count() == 5

        when:
        sqtCambiosPreciosService.delete(sqtCambiosPreciosId)
        sessionFactory.currentSession.flush()

        then:
        sqtCambiosPreciosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCambiosPrecios sqtCambiosPrecios = new SqtCambiosPrecios()
        sqtCambiosPreciosService.save(sqtCambiosPrecios)

        then:
        sqtCambiosPrecios.id != null
    }
}
