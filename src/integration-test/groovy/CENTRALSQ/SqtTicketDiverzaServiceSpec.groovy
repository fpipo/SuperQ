package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTicketDiverzaServiceSpec extends Specification {

    SqtTicketDiverzaService sqtTicketDiverzaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTicketDiverza(...).save(flush: true, failOnError: true)
        //new SqtTicketDiverza(...).save(flush: true, failOnError: true)
        //SqtTicketDiverza sqtTicketDiverza = new SqtTicketDiverza(...).save(flush: true, failOnError: true)
        //new SqtTicketDiverza(...).save(flush: true, failOnError: true)
        //new SqtTicketDiverza(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTicketDiverza.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTicketDiverzaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTicketDiverza> sqtTicketDiverzaList = sqtTicketDiverzaService.list(max: 2, offset: 2)

        then:
        sqtTicketDiverzaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTicketDiverzaService.count() == 5
    }

    void "test delete"() {
        Long sqtTicketDiverzaId = setupData()

        expect:
        sqtTicketDiverzaService.count() == 5

        when:
        sqtTicketDiverzaService.delete(sqtTicketDiverzaId)
        sessionFactory.currentSession.flush()

        then:
        sqtTicketDiverzaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTicketDiverza sqtTicketDiverza = new SqtTicketDiverza()
        sqtTicketDiverzaService.save(sqtTicketDiverza)

        then:
        sqtTicketDiverza.id != null
    }
}
