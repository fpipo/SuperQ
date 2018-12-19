package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInfoAdicionalIusaServiceSpec extends Specification {

    SqtInfoAdicionalIusaService sqtInfoAdicionalIusaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInfoAdicionalIusa(...).save(flush: true, failOnError: true)
        //new SqtInfoAdicionalIusa(...).save(flush: true, failOnError: true)
        //SqtInfoAdicionalIusa sqtInfoAdicionalIusa = new SqtInfoAdicionalIusa(...).save(flush: true, failOnError: true)
        //new SqtInfoAdicionalIusa(...).save(flush: true, failOnError: true)
        //new SqtInfoAdicionalIusa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInfoAdicionalIusa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInfoAdicionalIusaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInfoAdicionalIusa> sqtInfoAdicionalIusaList = sqtInfoAdicionalIusaService.list(max: 2, offset: 2)

        then:
        sqtInfoAdicionalIusaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInfoAdicionalIusaService.count() == 5
    }

    void "test delete"() {
        Long sqtInfoAdicionalIusaId = setupData()

        expect:
        sqtInfoAdicionalIusaService.count() == 5

        when:
        sqtInfoAdicionalIusaService.delete(sqtInfoAdicionalIusaId)
        sessionFactory.currentSession.flush()

        then:
        sqtInfoAdicionalIusaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInfoAdicionalIusa sqtInfoAdicionalIusa = new SqtInfoAdicionalIusa()
        sqtInfoAdicionalIusaService.save(sqtInfoAdicionalIusa)

        then:
        sqtInfoAdicionalIusa.id != null
    }
}
