package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRecaudacionServiceSpec extends Specification {

    SqtRecaudacionService sqtRecaudacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRecaudacion(...).save(flush: true, failOnError: true)
        //new SqtRecaudacion(...).save(flush: true, failOnError: true)
        //SqtRecaudacion sqtRecaudacion = new SqtRecaudacion(...).save(flush: true, failOnError: true)
        //new SqtRecaudacion(...).save(flush: true, failOnError: true)
        //new SqtRecaudacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRecaudacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRecaudacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRecaudacion> sqtRecaudacionList = sqtRecaudacionService.list(max: 2, offset: 2)

        then:
        sqtRecaudacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRecaudacionService.count() == 5
    }

    void "test delete"() {
        Long sqtRecaudacionId = setupData()

        expect:
        sqtRecaudacionService.count() == 5

        when:
        sqtRecaudacionService.delete(sqtRecaudacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtRecaudacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRecaudacion sqtRecaudacion = new SqtRecaudacion()
        sqtRecaudacionService.save(sqtRecaudacion)

        then:
        sqtRecaudacion.id != null
    }
}
