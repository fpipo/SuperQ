package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDireccionServiceSpec extends Specification {

    SqtDireccionService sqtDireccionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDireccion(...).save(flush: true, failOnError: true)
        //new SqtDireccion(...).save(flush: true, failOnError: true)
        //SqtDireccion sqtDireccion = new SqtDireccion(...).save(flush: true, failOnError: true)
        //new SqtDireccion(...).save(flush: true, failOnError: true)
        //new SqtDireccion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDireccion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDireccionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDireccion> sqtDireccionList = sqtDireccionService.list(max: 2, offset: 2)

        then:
        sqtDireccionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDireccionService.count() == 5
    }

    void "test delete"() {
        Long sqtDireccionId = setupData()

        expect:
        sqtDireccionService.count() == 5

        when:
        sqtDireccionService.delete(sqtDireccionId)
        sessionFactory.currentSession.flush()

        then:
        sqtDireccionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDireccion sqtDireccion = new SqtDireccion()
        sqtDireccionService.save(sqtDireccion)

        then:
        sqtDireccion.id != null
    }
}
