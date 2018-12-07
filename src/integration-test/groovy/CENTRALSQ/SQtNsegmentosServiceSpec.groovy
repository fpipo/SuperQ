package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SQtNsegmentosServiceSpec extends Specification {

    SQtNsegmentosService SQtNsegmentosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SQtNsegmentos(...).save(flush: true, failOnError: true)
        //new SQtNsegmentos(...).save(flush: true, failOnError: true)
        //SQtNsegmentos SQtNsegmentos = new SQtNsegmentos(...).save(flush: true, failOnError: true)
        //new SQtNsegmentos(...).save(flush: true, failOnError: true)
        //new SQtNsegmentos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //SQtNsegmentos.id
    }

    void "test get"() {
        setupData()

        expect:
        SQtNsegmentosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SQtNsegmentos> SQtNsegmentosList = SQtNsegmentosService.list(max: 2, offset: 2)

        then:
        SQtNsegmentosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        SQtNsegmentosService.count() == 5
    }

    void "test delete"() {
        Long SQtNsegmentosId = setupData()

        expect:
        SQtNsegmentosService.count() == 5

        when:
        SQtNsegmentosService.delete(SQtNsegmentosId)
        sessionFactory.currentSession.flush()

        then:
        SQtNsegmentosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SQtNsegmentos SQtNsegmentos = new SQtNsegmentos()
        SQtNsegmentosService.save(SQtNsegmentos)

        then:
        SQtNsegmentos.id != null
    }
}
