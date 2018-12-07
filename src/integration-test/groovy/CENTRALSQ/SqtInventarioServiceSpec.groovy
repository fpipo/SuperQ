package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioServiceSpec extends Specification {

    SqtInventarioService sqtInventarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventario(...).save(flush: true, failOnError: true)
        //new SqtInventario(...).save(flush: true, failOnError: true)
        //SqtInventario sqtInventario = new SqtInventario(...).save(flush: true, failOnError: true)
        //new SqtInventario(...).save(flush: true, failOnError: true)
        //new SqtInventario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventario.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventario> sqtInventarioList = sqtInventarioService.list(max: 2, offset: 2)

        then:
        sqtInventarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioId = setupData()

        expect:
        sqtInventarioService.count() == 5

        when:
        sqtInventarioService.delete(sqtInventarioId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventario sqtInventario = new SqtInventario()
        sqtInventarioService.save(sqtInventario)

        then:
        sqtInventario.id != null
    }
}
