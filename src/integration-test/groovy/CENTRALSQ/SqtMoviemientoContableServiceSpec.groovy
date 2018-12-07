package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtMoviemientoContableServiceSpec extends Specification {

    SqtMoviemientoContableService sqtMoviemientoContableService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtMoviemientoContable(...).save(flush: true, failOnError: true)
        //new SqtMoviemientoContable(...).save(flush: true, failOnError: true)
        //SqtMoviemientoContable sqtMoviemientoContable = new SqtMoviemientoContable(...).save(flush: true, failOnError: true)
        //new SqtMoviemientoContable(...).save(flush: true, failOnError: true)
        //new SqtMoviemientoContable(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtMoviemientoContable.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtMoviemientoContableService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtMoviemientoContable> sqtMoviemientoContableList = sqtMoviemientoContableService.list(max: 2, offset: 2)

        then:
        sqtMoviemientoContableList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtMoviemientoContableService.count() == 5
    }

    void "test delete"() {
        Long sqtMoviemientoContableId = setupData()

        expect:
        sqtMoviemientoContableService.count() == 5

        when:
        sqtMoviemientoContableService.delete(sqtMoviemientoContableId)
        sessionFactory.currentSession.flush()

        then:
        sqtMoviemientoContableService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtMoviemientoContable sqtMoviemientoContable = new SqtMoviemientoContable()
        sqtMoviemientoContableService.save(sqtMoviemientoContable)

        then:
        sqtMoviemientoContable.id != null
    }
}
