package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtComisionRangoServiceSpec extends Specification {

    SqtComisionRangoService sqtComisionRangoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtComisionRango(...).save(flush: true, failOnError: true)
        //new SqtComisionRango(...).save(flush: true, failOnError: true)
        //SqtComisionRango sqtComisionRango = new SqtComisionRango(...).save(flush: true, failOnError: true)
        //new SqtComisionRango(...).save(flush: true, failOnError: true)
        //new SqtComisionRango(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtComisionRango.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtComisionRangoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtComisionRango> sqtComisionRangoList = sqtComisionRangoService.list(max: 2, offset: 2)

        then:
        sqtComisionRangoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtComisionRangoService.count() == 5
    }

    void "test delete"() {
        Long sqtComisionRangoId = setupData()

        expect:
        sqtComisionRangoService.count() == 5

        when:
        sqtComisionRangoService.delete(sqtComisionRangoId)
        sessionFactory.currentSession.flush()

        then:
        sqtComisionRangoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtComisionRango sqtComisionRango = new SqtComisionRango()
        sqtComisionRangoService.save(sqtComisionRango)

        then:
        sqtComisionRango.id != null
    }
}
