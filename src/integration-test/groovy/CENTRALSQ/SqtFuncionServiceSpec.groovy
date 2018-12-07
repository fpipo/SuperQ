package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtFuncionServiceSpec extends Specification {

    SqtFuncionService sqtFuncionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtFuncion(...).save(flush: true, failOnError: true)
        //new SqtFuncion(...).save(flush: true, failOnError: true)
        //SqtFuncion sqtFuncion = new SqtFuncion(...).save(flush: true, failOnError: true)
        //new SqtFuncion(...).save(flush: true, failOnError: true)
        //new SqtFuncion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtFuncion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtFuncionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtFuncion> sqtFuncionList = sqtFuncionService.list(max: 2, offset: 2)

        then:
        sqtFuncionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtFuncionService.count() == 5
    }

    void "test delete"() {
        Long sqtFuncionId = setupData()

        expect:
        sqtFuncionService.count() == 5

        when:
        sqtFuncionService.delete(sqtFuncionId)
        sessionFactory.currentSession.flush()

        then:
        sqtFuncionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtFuncion sqtFuncion = new SqtFuncion()
        sqtFuncionService.save(sqtFuncion)

        then:
        sqtFuncion.id != null
    }
}
