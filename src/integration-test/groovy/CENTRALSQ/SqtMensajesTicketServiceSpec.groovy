package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMensajesTicketServiceSpec extends Specification {

    SqtMensajesTicketService sqtMensajesTicketService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMensajesTicket(...).save(flush: true, failOnError: true)
        //new SqtMensajesTicket(...).save(flush: true, failOnError: true)
        //SqtMensajesTicket sqtMensajesTicket = new SqtMensajesTicket(...).save(flush: true, failOnError: true)
        //new SqtMensajesTicket(...).save(flush: true, failOnError: true)
        //new SqtMensajesTicket(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMensajesTicket.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMensajesTicketService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMensajesTicket> sqtMensajesTicketList = sqtMensajesTicketService.list(max: 2, offset: 2)

        then:
        sqtMensajesTicketList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMensajesTicketService.count() == 5
    }

    void "test delete"() {
        Long sqtMensajesTicketId = setupData()

        expect:
        sqtMensajesTicketService.count() == 5

        when:
        sqtMensajesTicketService.delete(sqtMensajesTicketId)
        sessionFactory.currentSession.flush()

        then:
        sqtMensajesTicketService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMensajesTicket sqtMensajesTicket = new SqtMensajesTicket()
        sqtMensajesTicketService.save(sqtMensajesTicket)

        then:
        sqtMensajesTicket.id != null
    }
}
