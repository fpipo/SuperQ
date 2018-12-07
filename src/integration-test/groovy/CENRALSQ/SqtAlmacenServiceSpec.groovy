package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtAlmacenServiceSpec extends Specification {

    SqtAlmacenService sqtAlmacenService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtAlmacen(...).save(flush: true, failOnError: true)
        //new SqtAlmacen(...).save(flush: true, failOnError: true)
        //SqtAlmacen sqtAlmacen = new SqtAlmacen(...).save(flush: true, failOnError: true)
        //new SqtAlmacen(...).save(flush: true, failOnError: true)
        //new SqtAlmacen(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtAlmacen.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtAlmacenService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtAlmacen> sqtAlmacenList = sqtAlmacenService.list(max: 2, offset: 2)

        then:
        sqtAlmacenList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtAlmacenService.count() == 5
    }

    void "test delete"() {
        Long sqtAlmacenId = setupData()

        expect:
        sqtAlmacenService.count() == 5

        when:
        sqtAlmacenService.delete(sqtAlmacenId)
        sessionFactory.currentSession.flush()

        then:
        sqtAlmacenService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtAlmacen sqtAlmacen = new SqtAlmacen()
        sqtAlmacenService.save(sqtAlmacen)

        then:
        sqtAlmacen.id != null
    }
}
