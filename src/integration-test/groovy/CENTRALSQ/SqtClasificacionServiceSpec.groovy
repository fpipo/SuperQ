package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtClasificacionServiceSpec extends Specification {

    SqtClasificacionService sqtClasificacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtClasificacion(...).save(flush: true, failOnError: true)
        //new SqtClasificacion(...).save(flush: true, failOnError: true)
        //SqtClasificacion sqtClasificacion = new SqtClasificacion(...).save(flush: true, failOnError: true)
        //new SqtClasificacion(...).save(flush: true, failOnError: true)
        //new SqtClasificacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtClasificacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtClasificacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtClasificacion> sqtClasificacionList = sqtClasificacionService.list(max: 2, offset: 2)

        then:
        sqtClasificacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtClasificacionService.count() == 5
    }

    void "test delete"() {
        Long sqtClasificacionId = setupData()

        expect:
        sqtClasificacionService.count() == 5

        when:
        sqtClasificacionService.delete(sqtClasificacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtClasificacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtClasificacion sqtClasificacion = new SqtClasificacion()
        sqtClasificacionService.save(sqtClasificacion)

        then:
        sqtClasificacion.id != null
    }
}
