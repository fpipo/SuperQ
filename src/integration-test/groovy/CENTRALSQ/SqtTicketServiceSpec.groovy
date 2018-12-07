package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTicketServiceSpec extends Specification {

    SqtTicketService sqtTicketService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTicket(...).save(flush: true, failOnError: true)
        //new SqtTicket(...).save(flush: true, failOnError: true)
        //SqtTicket sqtTicket = new SqtTicket(...).save(flush: true, failOnError: true)
        //new SqtTicket(...).save(flush: true, failOnError: true)
        //new SqtTicket(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTicket.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTicketService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTicket> sqtTicketList = sqtTicketService.list(max: 2, offset: 2)

        then:
        sqtTicketList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTicketService.count() == 5
    }

    void "test delete"() {
        Long sqtTicketId = setupData()

        expect:
        sqtTicketService.count() == 5

        when:
        sqtTicketService.delete(sqtTicketId)
        sessionFactory.currentSession.flush()

        then:
        sqtTicketService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTicket sqtTicket = new SqtTicket()
        sqtTicketService.save(sqtTicket)

        then:
        sqtTicket.id != null
    }
}
