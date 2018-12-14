package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTraspasoParcialServiceSpec extends Specification {

    SqtTraspasoParcialService sqtTraspasoParcialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTraspasoParcial(...).save(flush: true, failOnError: true)
        //new SqtTraspasoParcial(...).save(flush: true, failOnError: true)
        //SqtTraspasoParcial sqtTraspasoParcial = new SqtTraspasoParcial(...).save(flush: true, failOnError: true)
        //new SqtTraspasoParcial(...).save(flush: true, failOnError: true)
        //new SqtTraspasoParcial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTraspasoParcial.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTraspasoParcialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTraspasoParcial> sqtTraspasoParcialList = sqtTraspasoParcialService.list(max: 2, offset: 2)

        then:
        sqtTraspasoParcialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTraspasoParcialService.count() == 5
    }

    void "test delete"() {
        Long sqtTraspasoParcialId = setupData()

        expect:
        sqtTraspasoParcialService.count() == 5

        when:
        sqtTraspasoParcialService.delete(sqtTraspasoParcialId)
        sessionFactory.currentSession.flush()

        then:
        sqtTraspasoParcialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTraspasoParcial sqtTraspasoParcial = new SqtTraspasoParcial()
        sqtTraspasoParcialService.save(sqtTraspasoParcial)

        then:
        sqtTraspasoParcial.id != null
    }
}
