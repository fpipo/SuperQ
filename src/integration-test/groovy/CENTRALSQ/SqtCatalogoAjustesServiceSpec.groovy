package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCatalogoAjustesServiceSpec extends Specification {

    SqtCatalogoAjustesService sqtCatalogoAjustesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCatalogoAjustes(...).save(flush: true, failOnError: true)
        //new SqtCatalogoAjustes(...).save(flush: true, failOnError: true)
        //SqtCatalogoAjustes sqtCatalogoAjustes = new SqtCatalogoAjustes(...).save(flush: true, failOnError: true)
        //new SqtCatalogoAjustes(...).save(flush: true, failOnError: true)
        //new SqtCatalogoAjustes(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCatalogoAjustes.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCatalogoAjustesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCatalogoAjustes> sqtCatalogoAjustesList = sqtCatalogoAjustesService.list(max: 2, offset: 2)

        then:
        sqtCatalogoAjustesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCatalogoAjustesService.count() == 5
    }

    void "test delete"() {
        Long sqtCatalogoAjustesId = setupData()

        expect:
        sqtCatalogoAjustesService.count() == 5

        when:
        sqtCatalogoAjustesService.delete(sqtCatalogoAjustesId)
        sessionFactory.currentSession.flush()

        then:
        sqtCatalogoAjustesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCatalogoAjustes sqtCatalogoAjustes = new SqtCatalogoAjustes()
        sqtCatalogoAjustesService.save(sqtCatalogoAjustes)

        then:
        sqtCatalogoAjustes.id != null
    }
}
