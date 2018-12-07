package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAsignacionServiceSpec extends Specification {

    SqtAsignacionService sqtAsignacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAsignacion(...).save(flush: true, failOnError: true)
        //new SqtAsignacion(...).save(flush: true, failOnError: true)
        //SqtAsignacion sqtAsignacion = new SqtAsignacion(...).save(flush: true, failOnError: true)
        //new SqtAsignacion(...).save(flush: true, failOnError: true)
        //new SqtAsignacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAsignacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAsignacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAsignacion> sqtAsignacionList = sqtAsignacionService.list(max: 2, offset: 2)

        then:
        sqtAsignacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAsignacionService.count() == 5
    }

    void "test delete"() {
        Long sqtAsignacionId = setupData()

        expect:
        sqtAsignacionService.count() == 5

        when:
        sqtAsignacionService.delete(sqtAsignacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtAsignacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAsignacion sqtAsignacion = new SqtAsignacion()
        sqtAsignacionService.save(sqtAsignacion)

        then:
        sqtAsignacion.id != null
    }
}
