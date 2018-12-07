package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCierreVentaDiaServiceSpec extends Specification {

    SqtCierreVentaDiaService sqtCierreVentaDiaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCierreVentaDia(...).save(flush: true, failOnError: true)
        //new SqtCierreVentaDia(...).save(flush: true, failOnError: true)
        //SqtCierreVentaDia sqtCierreVentaDia = new SqtCierreVentaDia(...).save(flush: true, failOnError: true)
        //new SqtCierreVentaDia(...).save(flush: true, failOnError: true)
        //new SqtCierreVentaDia(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCierreVentaDia.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCierreVentaDiaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCierreVentaDia> sqtCierreVentaDiaList = sqtCierreVentaDiaService.list(max: 2, offset: 2)

        then:
        sqtCierreVentaDiaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCierreVentaDiaService.count() == 5
    }

    void "test delete"() {
        Long sqtCierreVentaDiaId = setupData()

        expect:
        sqtCierreVentaDiaService.count() == 5

        when:
        sqtCierreVentaDiaService.delete(sqtCierreVentaDiaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCierreVentaDiaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCierreVentaDia sqtCierreVentaDia = new SqtCierreVentaDia()
        sqtCierreVentaDiaService.save(sqtCierreVentaDia)

        then:
        sqtCierreVentaDia.id != null
    }
}
