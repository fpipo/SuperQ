package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtFacturaServiceSpec extends Specification {

    SqtFacturaService sqtFacturaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtFactura(...).save(flush: true, failOnError: true)
        //new SqtFactura(...).save(flush: true, failOnError: true)
        //SqtFactura sqtFactura = new SqtFactura(...).save(flush: true, failOnError: true)
        //new SqtFactura(...).save(flush: true, failOnError: true)
        //new SqtFactura(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtFactura.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtFacturaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtFactura> sqtFacturaList = sqtFacturaService.list(max: 2, offset: 2)

        then:
        sqtFacturaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtFacturaService.count() == 5
    }

    void "test delete"() {
        Long sqtFacturaId = setupData()

        expect:
        sqtFacturaService.count() == 5

        when:
        sqtFacturaService.delete(sqtFacturaId)
        sessionFactory.currentSession.flush()

        then:
        sqtFacturaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtFactura sqtFactura = new SqtFactura()
        sqtFacturaService.save(sqtFactura)

        then:
        sqtFactura.id != null
    }
}
