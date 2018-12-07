package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtUsuarioIusaServiceSpec extends Specification {

    SqtUsuarioIusaService sqtUsuarioIusaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtUsuarioIusa(...).save(flush: true, failOnError: true)
        //new SqtUsuarioIusa(...).save(flush: true, failOnError: true)
        //SqtUsuarioIusa sqtUsuarioIusa = new SqtUsuarioIusa(...).save(flush: true, failOnError: true)
        //new SqtUsuarioIusa(...).save(flush: true, failOnError: true)
        //new SqtUsuarioIusa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtUsuarioIusa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtUsuarioIusaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtUsuarioIusa> sqtUsuarioIusaList = sqtUsuarioIusaService.list(max: 2, offset: 2)

        then:
        sqtUsuarioIusaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtUsuarioIusaService.count() == 5
    }

    void "test delete"() {
        Long sqtUsuarioIusaId = setupData()

        expect:
        sqtUsuarioIusaService.count() == 5

        when:
        sqtUsuarioIusaService.delete(sqtUsuarioIusaId)
        sessionFactory.currentSession.flush()

        then:
        sqtUsuarioIusaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtUsuarioIusa sqtUsuarioIusa = new SqtUsuarioIusa()
        sqtUsuarioIusaService.save(sqtUsuarioIusa)

        then:
        sqtUsuarioIusa.id != null
    }
}
