package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtConfiguracionServiceSpec extends Specification {

    SqtConfiguracionService sqtConfiguracionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtConfiguracion(...).save(flush: true, failOnError: true)
        //new SqtConfiguracion(...).save(flush: true, failOnError: true)
        //SqtConfiguracion sqtConfiguracion = new SqtConfiguracion(...).save(flush: true, failOnError: true)
        //new SqtConfiguracion(...).save(flush: true, failOnError: true)
        //new SqtConfiguracion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtConfiguracion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtConfiguracionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtConfiguracion> sqtConfiguracionList = sqtConfiguracionService.list(max: 2, offset: 2)

        then:
        sqtConfiguracionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtConfiguracionService.count() == 5
    }

    void "test delete"() {
        Long sqtConfiguracionId = setupData()

        expect:
        sqtConfiguracionService.count() == 5

        when:
        sqtConfiguracionService.delete(sqtConfiguracionId)
        sessionFactory.currentSession.flush()

        then:
        sqtConfiguracionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtConfiguracion sqtConfiguracion = new SqtConfiguracion()
        sqtConfiguracionService.save(sqtConfiguracion)

        then:
        sqtConfiguracion.id != null
    }
}
