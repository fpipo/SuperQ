package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtUnidadMedidaServiceSpec extends Specification {

    SqtUnidadMedidaService sqtUnidadMedidaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtUnidadMedida(...).save(flush: true, failOnError: true)
        //new SqtUnidadMedida(...).save(flush: true, failOnError: true)
        //SqtUnidadMedida sqtUnidadMedida = new SqtUnidadMedida(...).save(flush: true, failOnError: true)
        //new SqtUnidadMedida(...).save(flush: true, failOnError: true)
        //new SqtUnidadMedida(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtUnidadMedida.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtUnidadMedidaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtUnidadMedida> sqtUnidadMedidaList = sqtUnidadMedidaService.list(max: 2, offset: 2)

        then:
        sqtUnidadMedidaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtUnidadMedidaService.count() == 5
    }

    void "test delete"() {
        Long sqtUnidadMedidaId = setupData()

        expect:
        sqtUnidadMedidaService.count() == 5

        when:
        sqtUnidadMedidaService.delete(sqtUnidadMedidaId)
        sessionFactory.currentSession.flush()

        then:
        sqtUnidadMedidaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtUnidadMedida sqtUnidadMedida = new SqtUnidadMedida()
        sqtUnidadMedidaService.save(sqtUnidadMedida)

        then:
        sqtUnidadMedida.id != null
    }
}
