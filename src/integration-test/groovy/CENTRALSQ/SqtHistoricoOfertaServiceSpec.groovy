package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtHistoricoOfertaServiceSpec extends Specification {

    SqtHistoricoOfertaService sqtHistoricoOfertaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtHistoricoOferta(...).save(flush: true, failOnError: true)
        //new SqtHistoricoOferta(...).save(flush: true, failOnError: true)
        //SqtHistoricoOferta sqtHistoricoOferta = new SqtHistoricoOferta(...).save(flush: true, failOnError: true)
        //new SqtHistoricoOferta(...).save(flush: true, failOnError: true)
        //new SqtHistoricoOferta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtHistoricoOferta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtHistoricoOfertaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtHistoricoOferta> sqtHistoricoOfertaList = sqtHistoricoOfertaService.list(max: 2, offset: 2)

        then:
        sqtHistoricoOfertaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtHistoricoOfertaService.count() == 5
    }

    void "test delete"() {
        Long sqtHistoricoOfertaId = setupData()

        expect:
        sqtHistoricoOfertaService.count() == 5

        when:
        sqtHistoricoOfertaService.delete(sqtHistoricoOfertaId)
        sessionFactory.currentSession.flush()

        then:
        sqtHistoricoOfertaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtHistoricoOferta sqtHistoricoOferta = new SqtHistoricoOferta()
        sqtHistoricoOfertaService.save(sqtHistoricoOferta)

        then:
        sqtHistoricoOferta.id != null
    }
}
