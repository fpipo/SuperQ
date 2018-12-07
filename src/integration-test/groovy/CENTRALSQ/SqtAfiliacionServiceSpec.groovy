package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAfiliacionServiceSpec extends Specification {

    SqtAfiliacionService sqtAfiliacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAfiliacion(...).save(flush: true, failOnError: true)
        //new SqtAfiliacion(...).save(flush: true, failOnError: true)
        //SqtAfiliacion sqtAfiliacion = new SqtAfiliacion(...).save(flush: true, failOnError: true)
        //new SqtAfiliacion(...).save(flush: true, failOnError: true)
        //new SqtAfiliacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAfiliacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAfiliacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAfiliacion> sqtAfiliacionList = sqtAfiliacionService.list(max: 2, offset: 2)

        then:
        sqtAfiliacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAfiliacionService.count() == 5
    }

    void "test delete"() {
        Long sqtAfiliacionId = setupData()

        expect:
        sqtAfiliacionService.count() == 5

        when:
        sqtAfiliacionService.delete(sqtAfiliacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtAfiliacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAfiliacion sqtAfiliacion = new SqtAfiliacion()
        sqtAfiliacionService.save(sqtAfiliacion)

        then:
        sqtAfiliacion.id != null
    }
}
