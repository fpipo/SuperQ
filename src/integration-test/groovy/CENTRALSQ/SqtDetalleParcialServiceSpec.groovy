package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDetalleParcialServiceSpec extends Specification {

    SqtDetalleParcialService sqtDetalleParcialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDetalleParcial(...).save(flush: true, failOnError: true)
        //new SqtDetalleParcial(...).save(flush: true, failOnError: true)
        //SqtDetalleParcial sqtDetalleParcial = new SqtDetalleParcial(...).save(flush: true, failOnError: true)
        //new SqtDetalleParcial(...).save(flush: true, failOnError: true)
        //new SqtDetalleParcial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDetalleParcial.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDetalleParcialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDetalleParcial> sqtDetalleParcialList = sqtDetalleParcialService.list(max: 2, offset: 2)

        then:
        sqtDetalleParcialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDetalleParcialService.count() == 5
    }

    void "test delete"() {
        Long sqtDetalleParcialId = setupData()

        expect:
        sqtDetalleParcialService.count() == 5

        when:
        sqtDetalleParcialService.delete(sqtDetalleParcialId)
        sessionFactory.currentSession.flush()

        then:
        sqtDetalleParcialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDetalleParcial sqtDetalleParcial = new SqtDetalleParcial()
        sqtDetalleParcialService.save(sqtDetalleParcial)

        then:
        sqtDetalleParcial.id != null
    }
}
