package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtClienteServiceSpec extends Specification {

    SqtClienteService sqtClienteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCliente(...).save(flush: true, failOnError: true)
        //new SqtCliente(...).save(flush: true, failOnError: true)
        //SqtCliente sqtCliente = new SqtCliente(...).save(flush: true, failOnError: true)
        //new SqtCliente(...).save(flush: true, failOnError: true)
        //new SqtCliente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCliente.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtClienteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCliente> sqtClienteList = sqtClienteService.list(max: 2, offset: 2)

        then:
        sqtClienteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtClienteService.count() == 5
    }

    void "test delete"() {
        Long sqtClienteId = setupData()

        expect:
        sqtClienteService.count() == 5

        when:
        sqtClienteService.delete(sqtClienteId)
        sessionFactory.currentSession.flush()

        then:
        sqtClienteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCliente sqtCliente = new SqtCliente()
        sqtClienteService.save(sqtCliente)

        then:
        sqtCliente.id != null
    }
}
