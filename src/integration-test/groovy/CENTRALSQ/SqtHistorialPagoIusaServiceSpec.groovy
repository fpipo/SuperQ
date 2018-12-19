package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtHistorialPagoIusaServiceSpec extends Specification {

    SqtHistorialPagoIusaService sqtHistorialPagoIusaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtHistorialPagoIusa(...).save(flush: true, failOnError: true)
        //new SqtHistorialPagoIusa(...).save(flush: true, failOnError: true)
        //SqtHistorialPagoIusa sqtHistorialPagoIusa = new SqtHistorialPagoIusa(...).save(flush: true, failOnError: true)
        //new SqtHistorialPagoIusa(...).save(flush: true, failOnError: true)
        //new SqtHistorialPagoIusa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtHistorialPagoIusa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtHistorialPagoIusaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtHistorialPagoIusa> sqtHistorialPagoIusaList = sqtHistorialPagoIusaService.list(max: 2, offset: 2)

        then:
        sqtHistorialPagoIusaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtHistorialPagoIusaService.count() == 5
    }

    void "test delete"() {
        Long sqtHistorialPagoIusaId = setupData()

        expect:
        sqtHistorialPagoIusaService.count() == 5

        when:
        sqtHistorialPagoIusaService.delete(sqtHistorialPagoIusaId)
        sessionFactory.currentSession.flush()

        then:
        sqtHistorialPagoIusaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtHistorialPagoIusa sqtHistorialPagoIusa = new SqtHistorialPagoIusa()
        sqtHistorialPagoIusaService.save(sqtHistorialPagoIusa)

        then:
        sqtHistorialPagoIusa.id != null
    }
}
