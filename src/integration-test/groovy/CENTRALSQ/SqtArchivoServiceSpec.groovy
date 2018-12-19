package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtArchivoServiceSpec extends Specification {

    SqtArchivoService sqtArchivoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtArchivo(...).save(flush: true, failOnError: true)
        //new SqtArchivo(...).save(flush: true, failOnError: true)
        //SqtArchivo sqtArchivo = new SqtArchivo(...).save(flush: true, failOnError: true)
        //new SqtArchivo(...).save(flush: true, failOnError: true)
        //new SqtArchivo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtArchivo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtArchivoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtArchivo> sqtArchivoList = sqtArchivoService.list(max: 2, offset: 2)

        then:
        sqtArchivoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtArchivoService.count() == 5
    }

    void "test delete"() {
        Long sqtArchivoId = setupData()

        expect:
        sqtArchivoService.count() == 5

        when:
        sqtArchivoService.delete(sqtArchivoId)
        sessionFactory.currentSession.flush()

        then:
        sqtArchivoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtArchivo sqtArchivo = new SqtArchivo()
        sqtArchivoService.save(sqtArchivo)

        then:
        sqtArchivo.id != null
    }
}
