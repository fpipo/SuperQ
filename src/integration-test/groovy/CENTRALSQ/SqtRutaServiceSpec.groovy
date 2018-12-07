package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRutaServiceSpec extends Specification {

    SqtRutaService sqtRutaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRuta(...).save(flush: true, failOnError: true)
        //new SqtRuta(...).save(flush: true, failOnError: true)
        //SqtRuta sqtRuta = new SqtRuta(...).save(flush: true, failOnError: true)
        //new SqtRuta(...).save(flush: true, failOnError: true)
        //new SqtRuta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRuta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRutaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRuta> sqtRutaList = sqtRutaService.list(max: 2, offset: 2)

        then:
        sqtRutaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRutaService.count() == 5
    }

    void "test delete"() {
        Long sqtRutaId = setupData()

        expect:
        sqtRutaService.count() == 5

        when:
        sqtRutaService.delete(sqtRutaId)
        sessionFactory.currentSession.flush()

        then:
        sqtRutaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRuta sqtRuta = new SqtRuta()
        sqtRutaService.save(sqtRuta)

        then:
        sqtRuta.id != null
    }
}
