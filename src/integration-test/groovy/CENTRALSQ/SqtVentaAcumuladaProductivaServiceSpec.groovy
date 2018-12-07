package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtVentaAcumuladaProductivaServiceSpec extends Specification {

    SqtVentaAcumuladaProductivaService sqtVentaAcumuladaProductivaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtVentaAcumuladaProductiva(...).save(flush: true, failOnError: true)
        //new SqtVentaAcumuladaProductiva(...).save(flush: true, failOnError: true)
        //SqtVentaAcumuladaProductiva sqtVentaAcumuladaProductiva = new SqtVentaAcumuladaProductiva(...).save(flush: true, failOnError: true)
        //new SqtVentaAcumuladaProductiva(...).save(flush: true, failOnError: true)
        //new SqtVentaAcumuladaProductiva(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtVentaAcumuladaProductiva.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtVentaAcumuladaProductivaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtVentaAcumuladaProductiva> sqtVentaAcumuladaProductivaList = sqtVentaAcumuladaProductivaService.list(max: 2, offset: 2)

        then:
        sqtVentaAcumuladaProductivaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtVentaAcumuladaProductivaService.count() == 5
    }

    void "test delete"() {
        Long sqtVentaAcumuladaProductivaId = setupData()

        expect:
        sqtVentaAcumuladaProductivaService.count() == 5

        when:
        sqtVentaAcumuladaProductivaService.delete(sqtVentaAcumuladaProductivaId)
        sessionFactory.currentSession.flush()

        then:
        sqtVentaAcumuladaProductivaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtVentaAcumuladaProductiva sqtVentaAcumuladaProductiva = new SqtVentaAcumuladaProductiva()
        sqtVentaAcumuladaProductivaService.save(sqtVentaAcumuladaProductiva)

        then:
        sqtVentaAcumuladaProductiva.id != null
    }
}
