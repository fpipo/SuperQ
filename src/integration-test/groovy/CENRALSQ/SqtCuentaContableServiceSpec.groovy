package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCuentaContableServiceSpec extends Specification {

    SqtCuentaContableService sqtCuentaContableService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCuentaContable(...).save(flush: true, failOnError: true)
        //new SqtCuentaContable(...).save(flush: true, failOnError: true)
        //SqtCuentaContable sqtCuentaContable = new SqtCuentaContable(...).save(flush: true, failOnError: true)
        //new SqtCuentaContable(...).save(flush: true, failOnError: true)
        //new SqtCuentaContable(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCuentaContable.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCuentaContableService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCuentaContable> sqtCuentaContableList = sqtCuentaContableService.list(max: 2, offset: 2)

        then:
        sqtCuentaContableList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCuentaContableService.count() == 5
    }

    void "test delete"() {
        Long sqtCuentaContableId = setupData()

        expect:
        sqtCuentaContableService.count() == 5

        when:
        sqtCuentaContableService.delete(sqtCuentaContableId)
        sessionFactory.currentSession.flush()

        then:
        sqtCuentaContableService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCuentaContable sqtCuentaContable = new SqtCuentaContable()
        sqtCuentaContableService.save(sqtCuentaContable)

        then:
        sqtCuentaContable.id != null
    }
}
