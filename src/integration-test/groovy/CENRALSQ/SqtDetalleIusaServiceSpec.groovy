package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleIusaServiceSpec extends Specification {

    SqtDetalleIusaService sqtDetalleIusaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleIusa(...).save(flush: true, failOnError: true)
        //new SqtDetalleIusa(...).save(flush: true, failOnError: true)
        //SqtDetalleIusa sqtDetalleIusa = new SqtDetalleIusa(...).save(flush: true, failOnError: true)
        //new SqtDetalleIusa(...).save(flush: true, failOnError: true)
        //new SqtDetalleIusa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleIusa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleIusaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleIusa> sqtDetalleIusaList = sqtDetalleIusaService.list(max: 2, offset: 2)

        then:
        sqtDetalleIusaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleIusaService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleIusaId = setupData()

        expect:
        sqtDetalleIusaService.count() == 5

        when:
        sqtDetalleIusaService.delete(sqtDetalleIusaId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleIusaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleIusa sqtDetalleIusa = new SqtDetalleIusa()
        sqtDetalleIusaService.save(sqtDetalleIusa)

        then:
        sqtDetalleIusa.id != null
    }
}
