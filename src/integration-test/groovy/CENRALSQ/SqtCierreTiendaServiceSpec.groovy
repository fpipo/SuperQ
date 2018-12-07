package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCierreTiendaServiceSpec extends Specification {

    SqtCierreTiendaService sqtCierreTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCierreTienda(...).save(flush: true, failOnError: true)
        //new SqtCierreTienda(...).save(flush: true, failOnError: true)
        //SqtCierreTienda sqtCierreTienda = new SqtCierreTienda(...).save(flush: true, failOnError: true)
        //new SqtCierreTienda(...).save(flush: true, failOnError: true)
        //new SqtCierreTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCierreTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCierreTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCierreTienda> sqtCierreTiendaList = sqtCierreTiendaService.list(max: 2, offset: 2)

        then:
        sqtCierreTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCierreTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtCierreTiendaId = setupData()

        expect:
        sqtCierreTiendaService.count() == 5

        when:
        sqtCierreTiendaService.delete(sqtCierreTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCierreTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCierreTienda sqtCierreTienda = new SqtCierreTienda()
        sqtCierreTiendaService.save(sqtCierreTienda)

        then:
        sqtCierreTienda.id != null
    }
}
