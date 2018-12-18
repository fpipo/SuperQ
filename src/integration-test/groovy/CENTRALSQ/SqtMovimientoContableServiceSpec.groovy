package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMovimientoContableServiceSpec extends Specification {

    SqtMovimientoContableService sqtMovimientoContableService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMovimientoContable(...).save(flush: true, failOnError: true)
        //new SqtMovimientoContable(...).save(flush: true, failOnError: true)
        //SqtMovimientoContable sqtMovimientoContable = new SqtMovimientoContable(...).save(flush: true, failOnError: true)
        //new SqtMovimientoContable(...).save(flush: true, failOnError: true)
        //new SqtMovimientoContable(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMovimientoContable.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMovimientoContableService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMovimientoContable> sqtMovimientoContableList = sqtMovimientoContableService.list(max: 2, offset: 2)

        then:
        sqtMovimientoContableList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMovimientoContableService.count() == 5
    }

    void "test delete"() {
        Long sqtMovimientoContableId = setupData()

        expect:
        sqtMovimientoContableService.count() == 5

        when:
        sqtMovimientoContableService.delete(sqtMovimientoContableId)
        sessionFactory.currentSession.flush()

        then:
        sqtMovimientoContableService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMovimientoContable sqtMovimientoContable = new SqtMovimientoContable()
        sqtMovimientoContableService.save(sqtMovimientoContable)

        then:
        sqtMovimientoContable.id != null
    }
}
