package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPresupuestoVentasServiceSpec extends Specification {

    SqtPresupuestoVentasService sqtPresupuestoVentasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPresupuestoVentas(...).save(flush: true, failOnError: true)
        //new SqtPresupuestoVentas(...).save(flush: true, failOnError: true)
        //SqtPresupuestoVentas sqtPresupuestoVentas = new SqtPresupuestoVentas(...).save(flush: true, failOnError: true)
        //new SqtPresupuestoVentas(...).save(flush: true, failOnError: true)
        //new SqtPresupuestoVentas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPresupuestoVentas.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPresupuestoVentasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPresupuestoVentas> sqtPresupuestoVentasList = sqtPresupuestoVentasService.list(max: 2, offset: 2)

        then:
        sqtPresupuestoVentasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPresupuestoVentasService.count() == 5
    }

    void "test delete"() {
        Long sqtPresupuestoVentasId = setupData()

        expect:
        sqtPresupuestoVentasService.count() == 5

        when:
        sqtPresupuestoVentasService.delete(sqtPresupuestoVentasId)
        sessionFactory.currentSession.flush()

        then:
        sqtPresupuestoVentasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPresupuestoVentas sqtPresupuestoVentas = new SqtPresupuestoVentas()
        sqtPresupuestoVentasService.save(sqtPresupuestoVentas)

        then:
        sqtPresupuestoVentas.id != null
    }
}
