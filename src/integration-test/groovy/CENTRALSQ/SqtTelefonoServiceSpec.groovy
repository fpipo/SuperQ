package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTelefonoServiceSpec extends Specification {

    SqtTelefonoService sqtTelefonoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTelefono(...).save(flush: true, failOnError: true)
        //new SqtTelefono(...).save(flush: true, failOnError: true)
        //SqtTelefono sqtTelefono = new SqtTelefono(...).save(flush: true, failOnError: true)
        //new SqtTelefono(...).save(flush: true, failOnError: true)
        //new SqtTelefono(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTelefono.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTelefonoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTelefono> sqtTelefonoList = sqtTelefonoService.list(max: 2, offset: 2)

        then:
        sqtTelefonoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTelefonoService.count() == 5
    }

    void "test delete"() {
        Long sqtTelefonoId = setupData()

        expect:
        sqtTelefonoService.count() == 5

        when:
        sqtTelefonoService.delete(sqtTelefonoId)
        sessionFactory.currentSession.flush()

        then:
        sqtTelefonoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTelefono sqtTelefono = new SqtTelefono()
        sqtTelefonoService.save(sqtTelefono)

        then:
        sqtTelefono.id != null
    }
}
