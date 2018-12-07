package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtProductoPaqueteServiceSpec extends Specification {

    SqtProductoPaqueteService sqtProductoPaqueteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtProductoPaquete(...).save(flush: true, failOnError: true)
        //new SqtProductoPaquete(...).save(flush: true, failOnError: true)
        //SqtProductoPaquete sqtProductoPaquete = new SqtProductoPaquete(...).save(flush: true, failOnError: true)
        //new SqtProductoPaquete(...).save(flush: true, failOnError: true)
        //new SqtProductoPaquete(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtProductoPaquete.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtProductoPaqueteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtProductoPaquete> sqtProductoPaqueteList = sqtProductoPaqueteService.list(max: 2, offset: 2)

        then:
        sqtProductoPaqueteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtProductoPaqueteService.count() == 5
    }

    void "test delete"() {
        Long sqtProductoPaqueteId = setupData()

        expect:
        sqtProductoPaqueteService.count() == 5

        when:
        sqtProductoPaqueteService.delete(sqtProductoPaqueteId)
        sessionFactory.currentSession.flush()

        then:
        sqtProductoPaqueteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtProductoPaquete sqtProductoPaquete = new SqtProductoPaquete()
        sqtProductoPaqueteService.save(sqtProductoPaquete)

        then:
        sqtProductoPaquete.id != null
    }
}
