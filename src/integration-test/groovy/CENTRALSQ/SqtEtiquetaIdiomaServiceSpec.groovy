package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtEtiquetaIdiomaServiceSpec extends Specification {

    SqtEtiquetaIdiomaService sqtEtiquetaIdiomaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtEtiquetaIdioma(...).save(flush: true, failOnError: true)
        //new SqtEtiquetaIdioma(...).save(flush: true, failOnError: true)
        //SqtEtiquetaIdioma sqtEtiquetaIdioma = new SqtEtiquetaIdioma(...).save(flush: true, failOnError: true)
        //new SqtEtiquetaIdioma(...).save(flush: true, failOnError: true)
        //new SqtEtiquetaIdioma(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtEtiquetaIdioma.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtEtiquetaIdiomaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtEtiquetaIdioma> sqtEtiquetaIdiomaList = sqtEtiquetaIdiomaService.list(max: 2, offset: 2)

        then:
        sqtEtiquetaIdiomaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtEtiquetaIdiomaService.count() == 5
    }

    void "test delete"() {
        Long sqtEtiquetaIdiomaId = setupData()

        expect:
        sqtEtiquetaIdiomaService.count() == 5

        when:
        sqtEtiquetaIdiomaService.delete(sqtEtiquetaIdiomaId)
        sessionFactory.currentSession.flush()

        then:
        sqtEtiquetaIdiomaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtEtiquetaIdioma sqtEtiquetaIdioma = new SqtEtiquetaIdioma()
        sqtEtiquetaIdiomaService.save(sqtEtiquetaIdioma)

        then:
        sqtEtiquetaIdioma.id != null
    }
}
