package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCajaServiceSpec extends Specification {

    SqtCajaService sqtCajaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCaja(...).save(flush: true, failOnError: true)
        //new SqtCaja(...).save(flush: true, failOnError: true)
        //SqtCaja sqtCaja = new SqtCaja(...).save(flush: true, failOnError: true)
        //new SqtCaja(...).save(flush: true, failOnError: true)
        //new SqtCaja(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCaja.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCajaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCaja> sqtCajaList = sqtCajaService.list(max: 2, offset: 2)

        then:
        sqtCajaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCajaService.count() == 5
    }

    void "test delete"() {
        Long sqtCajaId = setupData()

        expect:
        sqtCajaService.count() == 5

        when:
        sqtCajaService.delete(sqtCajaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCajaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCaja sqtCaja = new SqtCaja()
        sqtCajaService.save(sqtCaja)

        then:
        sqtCaja.id != null
    }
}
