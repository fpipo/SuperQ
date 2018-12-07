package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCatalogoGlasgoServiceSpec extends Specification {

    SqtCatalogoGlasgoService sqtCatalogoGlasgoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCatalogoGlasgo(...).save(flush: true, failOnError: true)
        //new SqtCatalogoGlasgo(...).save(flush: true, failOnError: true)
        //SqtCatalogoGlasgo sqtCatalogoGlasgo = new SqtCatalogoGlasgo(...).save(flush: true, failOnError: true)
        //new SqtCatalogoGlasgo(...).save(flush: true, failOnError: true)
        //new SqtCatalogoGlasgo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCatalogoGlasgo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCatalogoGlasgoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCatalogoGlasgo> sqtCatalogoGlasgoList = sqtCatalogoGlasgoService.list(max: 2, offset: 2)

        then:
        sqtCatalogoGlasgoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCatalogoGlasgoService.count() == 5
    }

    void "test delete"() {
        Long sqtCatalogoGlasgoId = setupData()

        expect:
        sqtCatalogoGlasgoService.count() == 5

        when:
        sqtCatalogoGlasgoService.delete(sqtCatalogoGlasgoId)
        sessionFactory.currentSession.flush()

        then:
        sqtCatalogoGlasgoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCatalogoGlasgo sqtCatalogoGlasgo = new SqtCatalogoGlasgo()
        sqtCatalogoGlasgoService.save(sqtCatalogoGlasgo)

        then:
        sqtCatalogoGlasgo.id != null
    }
}
