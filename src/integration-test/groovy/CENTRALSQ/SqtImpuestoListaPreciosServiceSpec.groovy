package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtImpuestoListaPreciosServiceSpec extends Specification {

    SqtImpuestoListaPreciosService sqtImpuestoListaPreciosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtImpuestoListaPrecios(...).save(flush: true, failOnError: true)
        //new SqtImpuestoListaPrecios(...).save(flush: true, failOnError: true)
        //SqtImpuestoListaPrecios sqtImpuestoListaPrecios = new SqtImpuestoListaPrecios(...).save(flush: true, failOnError: true)
        //new SqtImpuestoListaPrecios(...).save(flush: true, failOnError: true)
        //new SqtImpuestoListaPrecios(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtImpuestoListaPrecios.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtImpuestoListaPreciosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtImpuestoListaPrecios> sqtImpuestoListaPreciosList = sqtImpuestoListaPreciosService.list(max: 2, offset: 2)

        then:
        sqtImpuestoListaPreciosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtImpuestoListaPreciosService.count() == 5
    }

    void "test delete"() {
        Long sqtImpuestoListaPreciosId = setupData()

        expect:
        sqtImpuestoListaPreciosService.count() == 5

        when:
        sqtImpuestoListaPreciosService.delete(sqtImpuestoListaPreciosId)
        sessionFactory.currentSession.flush()

        then:
        sqtImpuestoListaPreciosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtImpuestoListaPrecios sqtImpuestoListaPrecios = new SqtImpuestoListaPrecios()
        sqtImpuestoListaPreciosService.save(sqtImpuestoListaPrecios)

        then:
        sqtImpuestoListaPrecios.id != null
    }
}
