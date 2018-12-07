package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioFisicoServiceSpec extends Specification {

    SqtInventarioFisicoService sqtInventarioFisicoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioFisico(...).save(flush: true, failOnError: true)
        //new SqtInventarioFisico(...).save(flush: true, failOnError: true)
        //SqtInventarioFisico sqtInventarioFisico = new SqtInventarioFisico(...).save(flush: true, failOnError: true)
        //new SqtInventarioFisico(...).save(flush: true, failOnError: true)
        //new SqtInventarioFisico(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioFisico.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioFisicoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioFisico> sqtInventarioFisicoList = sqtInventarioFisicoService.list(max: 2, offset: 2)

        then:
        sqtInventarioFisicoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioFisicoService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioFisicoId = setupData()

        expect:
        sqtInventarioFisicoService.count() == 5

        when:
        sqtInventarioFisicoService.delete(sqtInventarioFisicoId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioFisicoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioFisico sqtInventarioFisico = new SqtInventarioFisico()
        sqtInventarioFisicoService.save(sqtInventarioFisico)

        then:
        sqtInventarioFisico.id != null
    }
}
