package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtIdiomaServiceSpec extends Specification {

    SqtIdiomaService sqtIdiomaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtIdioma(...).save(flush: true, failOnError: true)
        //new SqtIdioma(...).save(flush: true, failOnError: true)
        //SqtIdioma sqtIdioma = new SqtIdioma(...).save(flush: true, failOnError: true)
        //new SqtIdioma(...).save(flush: true, failOnError: true)
        //new SqtIdioma(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtIdioma.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtIdiomaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtIdioma> sqtIdiomaList = sqtIdiomaService.list(max: 2, offset: 2)

        then:
        sqtIdiomaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtIdiomaService.count() == 5
    }

    void "test delete"() {
        Long sqtIdiomaId = setupData()

        expect:
        sqtIdiomaService.count() == 5

        when:
        sqtIdiomaService.delete(sqtIdiomaId)
        sessionFactory.currentSession.flush()

        then:
        sqtIdiomaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtIdioma sqtIdioma = new SqtIdioma()
        sqtIdiomaService.save(sqtIdioma)

        then:
        sqtIdioma.id != null
    }
}
