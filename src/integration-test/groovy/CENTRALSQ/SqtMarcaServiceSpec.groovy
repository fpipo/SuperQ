package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMarcaServiceSpec extends Specification {

    SqtMarcaService sqtMarcaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMarca(...).save(flush: true, failOnError: true)
        //new SqtMarca(...).save(flush: true, failOnError: true)
        //SqtMarca sqtMarca = new SqtMarca(...).save(flush: true, failOnError: true)
        //new SqtMarca(...).save(flush: true, failOnError: true)
        //new SqtMarca(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMarca.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMarcaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMarca> sqtMarcaList = sqtMarcaService.list(max: 2, offset: 2)

        then:
        sqtMarcaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMarcaService.count() == 5
    }

    void "test delete"() {
        Long sqtMarcaId = setupData()

        expect:
        sqtMarcaService.count() == 5

        when:
        sqtMarcaService.delete(sqtMarcaId)
        sessionFactory.currentSession.flush()

        then:
        sqtMarcaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMarca sqtMarca = new SqtMarca()
        sqtMarcaService.save(sqtMarca)

        then:
        sqtMarca.id != null
    }
}
