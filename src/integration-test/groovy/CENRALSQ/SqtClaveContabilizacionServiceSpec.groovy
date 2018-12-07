package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtClaveContabilizacionServiceSpec extends Specification {

    SqtClaveContabilizacionService sqtClaveContabilizacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtClaveContabilizacion(...).save(flush: true, failOnError: true)
        //new SqtClaveContabilizacion(...).save(flush: true, failOnError: true)
        //SqtClaveContabilizacion sqtClaveContabilizacion = new SqtClaveContabilizacion(...).save(flush: true, failOnError: true)
        //new SqtClaveContabilizacion(...).save(flush: true, failOnError: true)
        //new SqtClaveContabilizacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtClaveContabilizacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtClaveContabilizacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtClaveContabilizacion> sqtClaveContabilizacionList = sqtClaveContabilizacionService.list(max: 2, offset: 2)

        then:
        sqtClaveContabilizacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtClaveContabilizacionService.count() == 5
    }

    void "test delete"() {
        Long sqtClaveContabilizacionId = setupData()

        expect:
        sqtClaveContabilizacionService.count() == 5

        when:
        sqtClaveContabilizacionService.delete(sqtClaveContabilizacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtClaveContabilizacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtClaveContabilizacion sqtClaveContabilizacion = new SqtClaveContabilizacion()
        sqtClaveContabilizacionService.save(sqtClaveContabilizacion)

        then:
        sqtClaveContabilizacion.id != null
    }
}
