package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioGeneralServiceSpec extends Specification {

    SqtInventarioGeneralService sqtInventarioGeneralService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioGeneral(...).save(flush: true, failOnError: true)
        //new SqtInventarioGeneral(...).save(flush: true, failOnError: true)
        //SqtInventarioGeneral sqtInventarioGeneral = new SqtInventarioGeneral(...).save(flush: true, failOnError: true)
        //new SqtInventarioGeneral(...).save(flush: true, failOnError: true)
        //new SqtInventarioGeneral(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioGeneral.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioGeneralService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioGeneral> sqtInventarioGeneralList = sqtInventarioGeneralService.list(max: 2, offset: 2)

        then:
        sqtInventarioGeneralList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioGeneralService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioGeneralId = setupData()

        expect:
        sqtInventarioGeneralService.count() == 5

        when:
        sqtInventarioGeneralService.delete(sqtInventarioGeneralId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioGeneralService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioGeneral sqtInventarioGeneral = new SqtInventarioGeneral()
        sqtInventarioGeneralService.save(sqtInventarioGeneral)

        then:
        sqtInventarioGeneral.id != null
    }
}
