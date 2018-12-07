package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtBolsaPreventaServiceSpec extends Specification {

    SqtBolsaPreventaService sqtBolsaPreventaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtBolsaPreventa(...).save(flush: true, failOnError: true)
        //new SqtBolsaPreventa(...).save(flush: true, failOnError: true)
        //SqtBolsaPreventa sqtBolsaPreventa = new SqtBolsaPreventa(...).save(flush: true, failOnError: true)
        //new SqtBolsaPreventa(...).save(flush: true, failOnError: true)
        //new SqtBolsaPreventa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtBolsaPreventa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtBolsaPreventaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtBolsaPreventa> sqtBolsaPreventaList = sqtBolsaPreventaService.list(max: 2, offset: 2)

        then:
        sqtBolsaPreventaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtBolsaPreventaService.count() == 5
    }

    void "test delete"() {
        Long sqtBolsaPreventaId = setupData()

        expect:
        sqtBolsaPreventaService.count() == 5

        when:
        sqtBolsaPreventaService.delete(sqtBolsaPreventaId)
        sessionFactory.currentSession.flush()

        then:
        sqtBolsaPreventaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtBolsaPreventa sqtBolsaPreventa = new SqtBolsaPreventa()
        sqtBolsaPreventaService.save(sqtBolsaPreventa)

        then:
        sqtBolsaPreventa.id != null
    }
}
