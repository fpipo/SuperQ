package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPagoIusaServiceSpec extends Specification {

    SqtPagoIusaService sqtPagoIusaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPagoIusa(...).save(flush: true, failOnError: true)
        //new SqtPagoIusa(...).save(flush: true, failOnError: true)
        //SqtPagoIusa sqtPagoIusa = new SqtPagoIusa(...).save(flush: true, failOnError: true)
        //new SqtPagoIusa(...).save(flush: true, failOnError: true)
        //new SqtPagoIusa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPagoIusa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPagoIusaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPagoIusa> sqtPagoIusaList = sqtPagoIusaService.list(max: 2, offset: 2)

        then:
        sqtPagoIusaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPagoIusaService.count() == 5
    }

    void "test delete"() {
        Long sqtPagoIusaId = setupData()

        expect:
        sqtPagoIusaService.count() == 5

        when:
        sqtPagoIusaService.delete(sqtPagoIusaId)
        sessionFactory.currentSession.flush()

        then:
        sqtPagoIusaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPagoIusa sqtPagoIusa = new SqtPagoIusa()
        sqtPagoIusaService.save(sqtPagoIusa)

        then:
        sqtPagoIusa.id != null
    }
}
