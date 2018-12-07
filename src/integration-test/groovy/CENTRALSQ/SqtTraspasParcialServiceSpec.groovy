package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTraspasParcialServiceSpec extends Specification {

    SqtTraspasParcialService sqtTraspasParcialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTraspasParcial(...).save(flush: true, failOnError: true)
        //new SqtTraspasParcial(...).save(flush: true, failOnError: true)
        //SqtTraspasParcial sqtTraspasParcial = new SqtTraspasParcial(...).save(flush: true, failOnError: true)
        //new SqtTraspasParcial(...).save(flush: true, failOnError: true)
        //new SqtTraspasParcial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTraspasParcial.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTraspasParcialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTraspasParcial> sqtTraspasParcialList = sqtTraspasParcialService.list(max: 2, offset: 2)

        then:
        sqtTraspasParcialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTraspasParcialService.count() == 5
    }

    void "test delete"() {
        Long sqtTraspasParcialId = setupData()

        expect:
        sqtTraspasParcialService.count() == 5

        when:
        sqtTraspasParcialService.delete(sqtTraspasParcialId)
        sessionFactory.currentSession.flush()

        then:
        sqtTraspasParcialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTraspasParcial sqtTraspasParcial = new SqtTraspasParcial()
        sqtTraspasParcialService.save(sqtTraspasParcial)

        then:
        sqtTraspasParcial.id != null
    }
}
