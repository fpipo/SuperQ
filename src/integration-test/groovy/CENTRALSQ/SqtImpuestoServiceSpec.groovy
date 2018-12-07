package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtImpuestoServiceSpec extends Specification {

    SqtImpuestoService sqtImpuestoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtImpuesto(...).save(flush: true, failOnError: true)
        //new SqtImpuesto(...).save(flush: true, failOnError: true)
        //SqtImpuesto sqtImpuesto = new SqtImpuesto(...).save(flush: true, failOnError: true)
        //new SqtImpuesto(...).save(flush: true, failOnError: true)
        //new SqtImpuesto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtImpuesto.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtImpuestoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtImpuesto> sqtImpuestoList = sqtImpuestoService.list(max: 2, offset: 2)

        then:
        sqtImpuestoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtImpuestoService.count() == 5
    }

    void "test delete"() {
        Long sqtImpuestoId = setupData()

        expect:
        sqtImpuestoService.count() == 5

        when:
        sqtImpuestoService.delete(sqtImpuestoId)
        sessionFactory.currentSession.flush()

        then:
        sqtImpuestoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtImpuesto sqtImpuesto = new SqtImpuesto()
        sqtImpuestoService.save(sqtImpuesto)

        then:
        sqtImpuesto.id != null
    }
}
