package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAcreedorServiceSpec extends Specification {

    SqtAcreedorService sqtAcreedorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAcreedor(...).save(flush: true, failOnError: true)
        //new SqtAcreedor(...).save(flush: true, failOnError: true)
        //SqtAcreedor sqtAcreedor = new SqtAcreedor(...).save(flush: true, failOnError: true)
        //new SqtAcreedor(...).save(flush: true, failOnError: true)
        //new SqtAcreedor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAcreedor.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAcreedorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAcreedor> sqtAcreedorList = sqtAcreedorService.list(max: 2, offset: 2)

        then:
        sqtAcreedorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAcreedorService.count() == 5
    }

    void "test delete"() {
        Long sqtAcreedorId = setupData()

        expect:
        sqtAcreedorService.count() == 5

        when:
        sqtAcreedorService.delete(sqtAcreedorId)
        sessionFactory.currentSession.flush()

        then:
        sqtAcreedorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAcreedor sqtAcreedor = new SqtAcreedor()
        sqtAcreedorService.save(sqtAcreedor)

        then:
        sqtAcreedor.id != null
    }
}
