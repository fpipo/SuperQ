package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRetiroCajaServiceSpec extends Specification {

    SqtRetiroCajaService sqtRetiroCajaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRetiroCaja(...).save(flush: true, failOnError: true)
        //new SqtRetiroCaja(...).save(flush: true, failOnError: true)
        //SqtRetiroCaja sqtRetiroCaja = new SqtRetiroCaja(...).save(flush: true, failOnError: true)
        //new SqtRetiroCaja(...).save(flush: true, failOnError: true)
        //new SqtRetiroCaja(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRetiroCaja.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRetiroCajaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRetiroCaja> sqtRetiroCajaList = sqtRetiroCajaService.list(max: 2, offset: 2)

        then:
        sqtRetiroCajaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRetiroCajaService.count() == 5
    }

    void "test delete"() {
        Long sqtRetiroCajaId = setupData()

        expect:
        sqtRetiroCajaService.count() == 5

        when:
        sqtRetiroCajaService.delete(sqtRetiroCajaId)
        sessionFactory.currentSession.flush()

        then:
        sqtRetiroCajaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRetiroCaja sqtRetiroCaja = new SqtRetiroCaja()
        sqtRetiroCajaService.save(sqtRetiroCaja)

        then:
        sqtRetiroCaja.id != null
    }
}
