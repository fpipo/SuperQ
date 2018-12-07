package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtInventarioCompensacionServiceSpec extends Specification {

    SqtInventarioCompensacionService sqtInventarioCompensacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtInventarioCompensacion(...).save(flush: true, failOnError: true)
        //new SqtInventarioCompensacion(...).save(flush: true, failOnError: true)
        //SqtInventarioCompensacion sqtInventarioCompensacion = new SqtInventarioCompensacion(...).save(flush: true, failOnError: true)
        //new SqtInventarioCompensacion(...).save(flush: true, failOnError: true)
        //new SqtInventarioCompensacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtInventarioCompensacion.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtInventarioCompensacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtInventarioCompensacion> sqtInventarioCompensacionList = sqtInventarioCompensacionService.list(max: 2, offset: 2)

        then:
        sqtInventarioCompensacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtInventarioCompensacionService.count() == 5
    }

    void "test delete"() {
        Long sqtInventarioCompensacionId = setupData()

        expect:
        sqtInventarioCompensacionService.count() == 5

        when:
        sqtInventarioCompensacionService.delete(sqtInventarioCompensacionId)
        sessionFactory.currentSession.flush()

        then:
        sqtInventarioCompensacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtInventarioCompensacion sqtInventarioCompensacion = new SqtInventarioCompensacion()
        sqtInventarioCompensacionService.save(sqtInventarioCompensacion)

        then:
        sqtInventarioCompensacion.id != null
    }
}
