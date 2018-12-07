package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtSegmentosServiceSpec extends Specification {

    SqtSegmentosService sqtSegmentosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtSegmentos(...).save(flush: true, failOnError: true)
        //new SqtSegmentos(...).save(flush: true, failOnError: true)
        //SqtSegmentos sqtSegmentos = new SqtSegmentos(...).save(flush: true, failOnError: true)
        //new SqtSegmentos(...).save(flush: true, failOnError: true)
        //new SqtSegmentos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtSegmentos.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtSegmentosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtSegmentos> sqtSegmentosList = sqtSegmentosService.list(max: 2, offset: 2)

        then:
        sqtSegmentosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtSegmentosService.count() == 5
    }

    void "test delete"() {
        Long sqtSegmentosId = setupData()

        expect:
        sqtSegmentosService.count() == 5

        when:
        sqtSegmentosService.delete(sqtSegmentosId)
        sessionFactory.currentSession.flush()

        then:
        sqtSegmentosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtSegmentos sqtSegmentos = new SqtSegmentos()
        sqtSegmentosService.save(sqtSegmentos)

        then:
        sqtSegmentos.id != null
    }
}
