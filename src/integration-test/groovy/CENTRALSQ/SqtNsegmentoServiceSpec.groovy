package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtNsegmentoServiceSpec extends Specification {

    SqtNsegmentoService sqtNsegmentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtNsegmento(...).save(flush: true, failOnError: true)
        //new SqtNsegmento(...).save(flush: true, failOnError: true)
        //SqtNsegmento sqtNsegmento = new SqtNsegmento(...).save(flush: true, failOnError: true)
        //new SqtNsegmento(...).save(flush: true, failOnError: true)
        //new SqtNsegmento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtNsegmento.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtNsegmentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtNsegmento> sqtNsegmentoList = sqtNsegmentoService.list(max: 2, offset: 2)

        then:
        sqtNsegmentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtNsegmentoService.count() == 5
    }

    void "test delete"() {
        Long sqtNsegmentoId = setupData()

        expect:
        sqtNsegmentoService.count() == 5

        when:
        sqtNsegmentoService.delete(sqtNsegmentoId)
        sessionFactory.currentSession.flush()

        then:
        sqtNsegmentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtNsegmento sqtNsegmento = new SqtNsegmento()
        sqtNsegmentoService.save(sqtNsegmento)

        then:
        sqtNsegmento.id != null
    }
}
