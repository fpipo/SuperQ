package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCategoriaServiceSpec extends Specification {

    SqtCategoriaService sqtCategoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCategoria(...).save(flush: true, failOnError: true)
        //new SqtCategoria(...).save(flush: true, failOnError: true)
        //SqtCategoria sqtCategoria = new SqtCategoria(...).save(flush: true, failOnError: true)
        //new SqtCategoria(...).save(flush: true, failOnError: true)
        //new SqtCategoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCategoria.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCategoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCategoria> sqtCategoriaList = sqtCategoriaService.list(max: 2, offset: 2)

        then:
        sqtCategoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCategoriaService.count() == 5
    }

    void "test delete"() {
        Long sqtCategoriaId = setupData()

        expect:
        sqtCategoriaService.count() == 5

        when:
        sqtCategoriaService.delete(sqtCategoriaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCategoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCategoria sqtCategoria = new SqtCategoria()
        sqtCategoriaService.save(sqtCategoria)

        then:
        sqtCategoria.id != null
    }
}
