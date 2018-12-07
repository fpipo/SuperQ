package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAccionesServiceSpec extends Specification {

    SqtAccionesService sqtAccionesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAcciones(...).save(flush: true, failOnError: true)
        //new SqtAcciones(...).save(flush: true, failOnError: true)
        //SqtAcciones sqtAcciones = new SqtAcciones(...).save(flush: true, failOnError: true)
        //new SqtAcciones(...).save(flush: true, failOnError: true)
        //new SqtAcciones(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAcciones.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAccionesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAcciones> sqtAccionesList = sqtAccionesService.list(max: 2, offset: 2)

        then:
        sqtAccionesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAccionesService.count() == 5
    }

    void "test delete"() {
        Long sqtAccionesId = setupData()

        expect:
        sqtAccionesService.count() == 5

        when:
        sqtAccionesService.delete(sqtAccionesId)
        sessionFactory.currentSession.flush()

        then:
        sqtAccionesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAcciones sqtAcciones = new SqtAcciones()
        sqtAccionesService.save(sqtAcciones)

        then:
        sqtAcciones.id != null
    }
}
