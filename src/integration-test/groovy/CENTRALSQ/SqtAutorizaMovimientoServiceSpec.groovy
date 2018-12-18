package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAutorizaMovimientoServiceSpec extends Specification {

    SqtAutorizaMovimientoService sqtAutorizaMovimientoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAutorizaMovimiento(...).save(flush: true, failOnError: true)
        //new SqtAutorizaMovimiento(...).save(flush: true, failOnError: true)
        //SqtAutorizaMovimiento sqtAutorizaMovimiento = new SqtAutorizaMovimiento(...).save(flush: true, failOnError: true)
        //new SqtAutorizaMovimiento(...).save(flush: true, failOnError: true)
        //new SqtAutorizaMovimiento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAutorizaMovimiento.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAutorizaMovimientoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAutorizaMovimiento> sqtAutorizaMovimientoList = sqtAutorizaMovimientoService.list(max: 2, offset: 2)

        then:
        sqtAutorizaMovimientoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAutorizaMovimientoService.count() == 5
    }

    void "test delete"() {
        Long sqtAutorizaMovimientoId = setupData()

        expect:
        sqtAutorizaMovimientoService.count() == 5

        when:
        sqtAutorizaMovimientoService.delete(sqtAutorizaMovimientoId)
        sessionFactory.currentSession.flush()

        then:
        sqtAutorizaMovimientoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAutorizaMovimiento sqtAutorizaMovimiento = new SqtAutorizaMovimiento()
        sqtAutorizaMovimientoService.save(sqtAutorizaMovimiento)

        then:
        sqtAutorizaMovimiento.id != null
    }
}
