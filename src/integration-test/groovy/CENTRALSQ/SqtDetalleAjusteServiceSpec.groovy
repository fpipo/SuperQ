package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleAjusteServiceSpec extends Specification {

    SqtDetalleAjusteService sqtDetalleAjusteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleAjuste(...).save(flush: true, failOnError: true)
        //new SqtDetalleAjuste(...).save(flush: true, failOnError: true)
        //SqtDetalleAjuste sqtDetalleAjuste = new SqtDetalleAjuste(...).save(flush: true, failOnError: true)
        //new SqtDetalleAjuste(...).save(flush: true, failOnError: true)
        //new SqtDetalleAjuste(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleAjuste.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleAjusteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleAjuste> sqtDetalleAjusteList = sqtDetalleAjusteService.list(max: 2, offset: 2)

        then:
        sqtDetalleAjusteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleAjusteService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleAjusteId = setupData()

        expect:
        sqtDetalleAjusteService.count() == 5

        when:
        sqtDetalleAjusteService.delete(sqtDetalleAjusteId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleAjusteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleAjuste sqtDetalleAjuste = new SqtDetalleAjuste()
        sqtDetalleAjusteService.save(sqtDetalleAjuste)

        then:
        sqtDetalleAjuste.id != null
    }
}
