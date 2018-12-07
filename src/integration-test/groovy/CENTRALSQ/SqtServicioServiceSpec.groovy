package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtServicioServiceSpec extends Specification {

    SqtServicioService sqtServicioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtServicio(...).save(flush: true, failOnError: true)
        //new SqtServicio(...).save(flush: true, failOnError: true)
        //SqtServicio sqtServicio = new SqtServicio(...).save(flush: true, failOnError: true)
        //new SqtServicio(...).save(flush: true, failOnError: true)
        //new SqtServicio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtServicio.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtServicioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtServicio> sqtServicioList = sqtServicioService.list(max: 2, offset: 2)

        then:
        sqtServicioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtServicioService.count() == 5
    }

    void "test delete"() {
        Long sqtServicioId = setupData()

        expect:
        sqtServicioService.count() == 5

        when:
        sqtServicioService.delete(sqtServicioId)
        sessionFactory.currentSession.flush()

        then:
        sqtServicioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtServicio sqtServicio = new SqtServicio()
        sqtServicioService.save(sqtServicio)

        then:
        sqtServicio.id != null
    }
}
