package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPreciosOfertaServiceSpec extends Specification {

    SqtPreciosOfertaService sqtPreciosOfertaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPreciosOferta(...).save(flush: true, failOnError: true)
        //new SqtPreciosOferta(...).save(flush: true, failOnError: true)
        //SqtPreciosOferta sqtPreciosOferta = new SqtPreciosOferta(...).save(flush: true, failOnError: true)
        //new SqtPreciosOferta(...).save(flush: true, failOnError: true)
        //new SqtPreciosOferta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPreciosOferta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPreciosOfertaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPreciosOferta> sqtPreciosOfertaList = sqtPreciosOfertaService.list(max: 2, offset: 2)

        then:
        sqtPreciosOfertaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPreciosOfertaService.count() == 5
    }

    void "test delete"() {
        Long sqtPreciosOfertaId = setupData()

        expect:
        sqtPreciosOfertaService.count() == 5

        when:
        sqtPreciosOfertaService.delete(sqtPreciosOfertaId)
        sessionFactory.currentSession.flush()

        then:
        sqtPreciosOfertaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPreciosOferta sqtPreciosOferta = new SqtPreciosOferta()
        sqtPreciosOfertaService.save(sqtPreciosOferta)

        then:
        sqtPreciosOferta.id != null
    }
}
