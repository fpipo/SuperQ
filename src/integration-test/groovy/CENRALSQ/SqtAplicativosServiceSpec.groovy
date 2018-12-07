package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAplicativosServiceSpec extends Specification {

    SqtAplicativosService sqtAplicativosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAplicativos(...).save(flush: true, failOnError: true)
        //new SqtAplicativos(...).save(flush: true, failOnError: true)
        //SqtAplicativos sqtAplicativos = new SqtAplicativos(...).save(flush: true, failOnError: true)
        //new SqtAplicativos(...).save(flush: true, failOnError: true)
        //new SqtAplicativos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAplicativos.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAplicativosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAplicativos> sqtAplicativosList = sqtAplicativosService.list(max: 2, offset: 2)

        then:
        sqtAplicativosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAplicativosService.count() == 5
    }

    void "test delete"() {
        Long sqtAplicativosId = setupData()

        expect:
        sqtAplicativosService.count() == 5

        when:
        sqtAplicativosService.delete(sqtAplicativosId)
        sessionFactory.currentSession.flush()

        then:
        sqtAplicativosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAplicativos sqtAplicativos = new SqtAplicativos()
        sqtAplicativosService.save(sqtAplicativos)

        then:
        sqtAplicativos.id != null
    }
}
