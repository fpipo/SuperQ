package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCantidadCajaServiceSpec extends Specification {

    SqtCantidadCajaService sqtCantidadCajaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCantidadCaja(...).save(flush: true, failOnError: true)
        //new SqtCantidadCaja(...).save(flush: true, failOnError: true)
        //SqtCantidadCaja sqtCantidadCaja = new SqtCantidadCaja(...).save(flush: true, failOnError: true)
        //new SqtCantidadCaja(...).save(flush: true, failOnError: true)
        //new SqtCantidadCaja(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCantidadCaja.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCantidadCajaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCantidadCaja> sqtCantidadCajaList = sqtCantidadCajaService.list(max: 2, offset: 2)

        then:
        sqtCantidadCajaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCantidadCajaService.count() == 5
    }

    void "test delete"() {
        Long sqtCantidadCajaId = setupData()

        expect:
        sqtCantidadCajaService.count() == 5

        when:
        sqtCantidadCajaService.delete(sqtCantidadCajaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCantidadCajaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCantidadCaja sqtCantidadCaja = new SqtCantidadCaja()
        sqtCantidadCajaService.save(sqtCantidadCaja)

        then:
        sqtCantidadCaja.id != null
    }
}
