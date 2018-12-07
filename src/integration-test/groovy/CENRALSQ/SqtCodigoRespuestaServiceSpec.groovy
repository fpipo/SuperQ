package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCodigoRespuestaServiceSpec extends Specification {

    SqtCodigoRespuestaService sqtCodigoRespuestaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCodigoRespuesta(...).save(flush: true, failOnError: true)
        //new SqtCodigoRespuesta(...).save(flush: true, failOnError: true)
        //SqtCodigoRespuesta sqtCodigoRespuesta = new SqtCodigoRespuesta(...).save(flush: true, failOnError: true)
        //new SqtCodigoRespuesta(...).save(flush: true, failOnError: true)
        //new SqtCodigoRespuesta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCodigoRespuesta.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCodigoRespuestaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCodigoRespuesta> sqtCodigoRespuestaList = sqtCodigoRespuestaService.list(max: 2, offset: 2)

        then:
        sqtCodigoRespuestaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCodigoRespuestaService.count() == 5
    }

    void "test delete"() {
        Long sqtCodigoRespuestaId = setupData()

        expect:
        sqtCodigoRespuestaService.count() == 5

        when:
        sqtCodigoRespuestaService.delete(sqtCodigoRespuestaId)
        sessionFactory.currentSession.flush()

        then:
        sqtCodigoRespuestaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCodigoRespuesta sqtCodigoRespuesta = new SqtCodigoRespuesta()
        sqtCodigoRespuestaService.save(sqtCodigoRespuesta)

        then:
        sqtCodigoRespuesta.id != null
    }
}
