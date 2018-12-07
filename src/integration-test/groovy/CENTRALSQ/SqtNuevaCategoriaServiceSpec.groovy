package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtNuevaCategoriaServiceSpec extends Specification {

    SqtNuevaCategoriaService sqtNuevaCategoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtNuevaCategoria(...).save(flush: true, failOnError: true)
        //new SqtNuevaCategoria(...).save(flush: true, failOnError: true)
        //SqtNuevaCategoria sqtNuevaCategoria = new SqtNuevaCategoria(...).save(flush: true, failOnError: true)
        //new SqtNuevaCategoria(...).save(flush: true, failOnError: true)
        //new SqtNuevaCategoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtNuevaCategoria.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtNuevaCategoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtNuevaCategoria> sqtNuevaCategoriaList = sqtNuevaCategoriaService.list(max: 2, offset: 2)

        then:
        sqtNuevaCategoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtNuevaCategoriaService.count() == 5
    }

    void "test delete"() {
        Long sqtNuevaCategoriaId = setupData()

        expect:
        sqtNuevaCategoriaService.count() == 5

        when:
        sqtNuevaCategoriaService.delete(sqtNuevaCategoriaId)
        sessionFactory.currentSession.flush()

        then:
        sqtNuevaCategoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtNuevaCategoria sqtNuevaCategoria = new SqtNuevaCategoria()
        sqtNuevaCategoriaService.save(sqtNuevaCategoria)

        then:
        sqtNuevaCategoria.id != null
    }
}
