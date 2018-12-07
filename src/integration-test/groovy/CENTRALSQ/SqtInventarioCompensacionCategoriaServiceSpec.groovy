package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioCompensacionCategoriaServiceSpec extends Specification {

    SqtInventarioCompensacionCategoriaService sqtInventarioCompensacionCategoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioCompensacionCategoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCompensacionCategoria(...).save(flush: true, failOnError: true)
        //SqtInventarioCompensacionCategoria sqtInventarioCompensacionCategoria = new SqtInventarioCompensacionCategoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCompensacionCategoria(...).save(flush: true, failOnError: true)
        //new SqtInventarioCompensacionCategoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioCompensacionCategoria.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioCompensacionCategoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioCompensacionCategoria> sqtInventarioCompensacionCategoriaList = sqtInventarioCompensacionCategoriaService.list(max: 2, offset: 2)

        then:
        sqtInventarioCompensacionCategoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioCompensacionCategoriaService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioCompensacionCategoriaId = setupData()

        expect:
        sqtInventarioCompensacionCategoriaService.count() == 5

        when:
        sqtInventarioCompensacionCategoriaService.delete(sqtInventarioCompensacionCategoriaId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioCompensacionCategoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioCompensacionCategoria sqtInventarioCompensacionCategoria = new SqtInventarioCompensacionCategoria()
        sqtInventarioCompensacionCategoriaService.save(sqtInventarioCompensacionCategoria)

        then:
        sqtInventarioCompensacionCategoria.id != null
    }
}
