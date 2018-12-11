package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCatalogoCigarrosServiceSpec extends Specification {

    SqtCatalogoCigarrosService sqtCatalogoCigarrosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCatalogoCigarros(...).save(flush: true, failOnError: true)
        //new SqtCatalogoCigarros(...).save(flush: true, failOnError: true)
        //SqtCatalogoCigarros sqtCatalogoCigarros = new SqtCatalogoCigarros(...).save(flush: true, failOnError: true)
        //new SqtCatalogoCigarros(...).save(flush: true, failOnError: true)
        //new SqtCatalogoCigarros(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCatalogoCigarros.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCatalogoCigarrosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCatalogoCigarros> sqtCatalogoCigarrosList = sqtCatalogoCigarrosService.list(max: 2, offset: 2)

        then:
        sqtCatalogoCigarrosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCatalogoCigarrosService.count() == 5
    }

    void "test delete"() {
        Long sqtCatalogoCigarrosId = setupData()

        expect:
        sqtCatalogoCigarrosService.count() == 5

        when:
        sqtCatalogoCigarrosService.delete(sqtCatalogoCigarrosId)
        sessionFactory.currentSession.flush()

        then:
        sqtCatalogoCigarrosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCatalogoCigarros sqtCatalogoCigarros = new SqtCatalogoCigarros()
        sqtCatalogoCigarrosService.save(sqtCatalogoCigarros)

        then:
        sqtCatalogoCigarros.id != null
    }
}
