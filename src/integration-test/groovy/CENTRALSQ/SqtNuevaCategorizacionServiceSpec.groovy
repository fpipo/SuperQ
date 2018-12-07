package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtNuevaCategorizacionServiceSpec extends Specification {

    SqtNuevaCategorizacionService sqtNuevaCategorizacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtNuevaCategorizacion(...).save(flush: true, failOnError: true)
        //new SqtNuevaCategorizacion(...).save(flush: true, failOnError: true)
        //SqtNuevaCategorizacion sqtNuevaCategorizacion = new SqtNuevaCategorizacion(...).save(flush: true, failOnError: true)
        //new SqtNuevaCategorizacion(...).save(flush: true, failOnError: true)
        //new SqtNuevaCategorizacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtNuevaCategorizacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtNuevaCategorizacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtNuevaCategorizacion> sqtNuevaCategorizacionList = sqtNuevaCategorizacionService.list(max: 2, offset: 2)

        then:
        sqtNuevaCategorizacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtNuevaCategorizacionService.count() == 5
    }

    void "test delete"() {
        Long sqtNuevaCategorizacionId = setupData()

        expect:
        sqtNuevaCategorizacionService.count() == 5

        when:
        sqtNuevaCategorizacionService.delete(sqtNuevaCategorizacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtNuevaCategorizacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtNuevaCategorizacion sqtNuevaCategorizacion = new SqtNuevaCategorizacion()
        sqtNuevaCategorizacionService.save(sqtNuevaCategorizacion)

        then:
        sqtNuevaCategorizacion.id != null
    }
}
