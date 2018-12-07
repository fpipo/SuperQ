package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioCartegoriaServiceSpec extends Specification {

    SqtInventarioCartegoriaService sqtInventarioCartegoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioCartegoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCartegoria(...).save(flush: true, failOnError: true)
        //SqtInventarioCartegoria sqtInventarioCartegoria = new SqtInventarioCartegoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCartegoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCartegoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioCartegoria.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioCartegoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioCartegoria> sqtInventarioCartegoriaList = sqtInventarioCartegoriaService.list(max: 2, offset: 2)

        then:
        sqtInventarioCartegoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioCartegoriaService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioCartegoriaId = setupData()

        expect:
        sqtInventarioCartegoriaService.count() == 5

        when:
        sqtInventarioCartegoriaService.delete(sqtInventarioCartegoriaId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioCartegoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioCartegoria sqtInventarioCartegoria = new SqtInventarioCartegoria()
        sqtInventarioCartegoriaService.save(sqtInventarioCartegoria)

        then:
        sqtInventarioCartegoria.id != null
    }
}
