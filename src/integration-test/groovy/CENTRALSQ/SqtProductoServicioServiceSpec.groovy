package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProductoServicioServiceSpec extends Specification {

    SqtProductoServicioService sqtProductoServicioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProductoServicio(...).save(flush: true, failOnError: true)
        //new SqtProductoServicio(...).save(flush: true, failOnError: true)
        //SqtProductoServicio sqtProductoServicio = new SqtProductoServicio(...).save(flush: true, failOnError: true)
        //new SqtProductoServicio(...).save(flush: true, failOnError: true)
        //new SqtProductoServicio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProductoServicio.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProductoServicioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProductoServicio> sqtProductoServicioList = sqtProductoServicioService.list(max: 2, offset: 2)

        then:
        sqtProductoServicioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProductoServicioService.count() == 5
    }

    void "test delete"() {
        Long sqtProductoServicioId = setupData()

        expect:
        sqtProductoServicioService.count() == 5

        when:
        sqtProductoServicioService.delete(sqtProductoServicioId)
        sessionFactory.currentSession.flush()

        then:
        sqtProductoServicioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProductoServicio sqtProductoServicio = new SqtProductoServicio()
        sqtProductoServicioService.save(sqtProductoServicio)

        then:
        sqtProductoServicio.id != null
    }
}
