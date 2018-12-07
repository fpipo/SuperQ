package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMovimientoServiceSpec extends Specification {

    SqtMovimientoService sqtMovimientoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMovimiento(...).save(flush: true, failOnError: true)
        //new SqtMovimiento(...).save(flush: true, failOnError: true)
        //SqtMovimiento sqtMovimiento = new SqtMovimiento(...).save(flush: true, failOnError: true)
        //new SqtMovimiento(...).save(flush: true, failOnError: true)
        //new SqtMovimiento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMovimiento.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMovimientoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMovimiento> sqtMovimientoList = sqtMovimientoService.list(max: 2, offset: 2)

        then:
        sqtMovimientoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMovimientoService.count() == 5
    }

    void "test delete"() {
        Long sqtMovimientoId = setupData()

        expect:
        sqtMovimientoService.count() == 5

        when:
        sqtMovimientoService.delete(sqtMovimientoId)
        sessionFactory.currentSession.flush()

        then:
        sqtMovimientoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMovimiento sqtMovimiento = new SqtMovimiento()
        sqtMovimientoService.save(sqtMovimiento)

        then:
        sqtMovimiento.id != null
    }
}
