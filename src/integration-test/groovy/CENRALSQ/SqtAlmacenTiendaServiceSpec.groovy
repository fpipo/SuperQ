package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAlmacenTiendaServiceSpec extends Specification {

    SqtAlmacenTiendaService sqtAlmacenTiendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAlmacenTienda(...).save(flush: true, failOnError: true)
        //new SqtAlmacenTienda(...).save(flush: true, failOnError: true)
        //SqtAlmacenTienda sqtAlmacenTienda = new SqtAlmacenTienda(...).save(flush: true, failOnError: true)
        //new SqtAlmacenTienda(...).save(flush: true, failOnError: true)
        //new SqtAlmacenTienda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAlmacenTienda.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAlmacenTiendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAlmacenTienda> sqtAlmacenTiendaList = sqtAlmacenTiendaService.list(max: 2, offset: 2)

        then:
        sqtAlmacenTiendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAlmacenTiendaService.count() == 5
    }

    void "test delete"() {
        Long sqtAlmacenTiendaId = setupData()

        expect:
        sqtAlmacenTiendaService.count() == 5

        when:
        sqtAlmacenTiendaService.delete(sqtAlmacenTiendaId)
        sessionFactory.currentSession.flush()

        then:
        sqtAlmacenTiendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAlmacenTienda sqtAlmacenTienda = new SqtAlmacenTienda()
        sqtAlmacenTiendaService.save(sqtAlmacenTienda)

        then:
        sqtAlmacenTienda.id != null
    }
}
