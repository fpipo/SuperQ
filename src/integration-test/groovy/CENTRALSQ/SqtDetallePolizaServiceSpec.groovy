package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetallePolizaServiceSpec extends Specification {

    SqtDetallePolizaService sqtDetallePolizaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetallePoliza(...).save(flush: true, failOnError: true)
        //new SqtDetallePoliza(...).save(flush: true, failOnError: true)
        //SqtDetallePoliza sqtDetallePoliza = new SqtDetallePoliza(...).save(flush: true, failOnError: true)
        //new SqtDetallePoliza(...).save(flush: true, failOnError: true)
        //new SqtDetallePoliza(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetallePoliza.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetallePolizaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetallePoliza> sqtDetallePolizaList = sqtDetallePolizaService.list(max: 2, offset: 2)

        then:
        sqtDetallePolizaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetallePolizaService.count() == 5
    }

    void "test delete"() {
        Long sqtDetallePolizaId = setupData()

        expect:
        sqtDetallePolizaService.count() == 5

        when:
        sqtDetallePolizaService.delete(sqtDetallePolizaId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetallePolizaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetallePoliza sqtDetallePoliza = new SqtDetallePoliza()
        sqtDetallePolizaService.save(sqtDetallePoliza)

        then:
        sqtDetallePoliza.id != null
    }
}
