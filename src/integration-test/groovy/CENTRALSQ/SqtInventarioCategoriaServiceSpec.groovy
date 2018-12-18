package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioCategoriaServiceSpec extends Specification {

    SqtInventarioCategoriaService sqtInventarioCategoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioCategoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCategoria(...).save(flush: true, failOnError: true)
        //SqtInventarioCategoria sqtInventarioCategoria = new SqtInventarioCategoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCategoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCategoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioCategoria.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioCategoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioCategoria> sqtInventarioCategoriaList = sqtInventarioCategoriaService.list(max: 2, offset: 2)

        then:
        sqtInventarioCategoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioCategoriaService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioCategoriaId = setupData()

        expect:
        sqtInventarioCategoriaService.count() == 5

        when:
        sqtInventarioCategoriaService.delete(sqtInventarioCategoriaId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioCategoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioCategoria sqtInventarioCategoria = new SqtInventarioCategoria()
        sqtInventarioCategoriaService.save(sqtInventarioCategoria)

        then:
        sqtInventarioCategoria.id != null
    }
}
