package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTipoClienteServiceSpec extends Specification {

    SqtTipoClienteService sqtTipoClienteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTipoCliente(...).save(flush: true, failOnError: true)
        //new SqtTipoCliente(...).save(flush: true, failOnError: true)
        //SqtTipoCliente sqtTipoCliente = new SqtTipoCliente(...).save(flush: true, failOnError: true)
        //new SqtTipoCliente(...).save(flush: true, failOnError: true)
        //new SqtTipoCliente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTipoCliente.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTipoClienteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTipoCliente> sqtTipoClienteList = sqtTipoClienteService.list(max: 2, offset: 2)

        then:
        sqtTipoClienteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTipoClienteService.count() == 5
    }

    void "test delete"() {
        Long sqtTipoClienteId = setupData()

        expect:
        sqtTipoClienteService.count() == 5

        when:
        sqtTipoClienteService.delete(sqtTipoClienteId)
        sessionFactory.currentSession.flush()

        then:
        sqtTipoClienteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTipoCliente sqtTipoCliente = new SqtTipoCliente()
        sqtTipoClienteService.save(sqtTipoCliente)

        then:
        sqtTipoCliente.id != null
    }
}
