package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqTKardexTaServiceSpec extends Specification {

    SqTKardexTaService sqTKardexTaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqTKardexTa(...).save(flush: true, failOnError: true)
        //new SqTKardexTa(...).save(flush: true, failOnError: true)
        //SqTKardexTa sqTKardexTa = new SqTKardexTa(...).save(flush: true, failOnError: true)
        //new SqTKardexTa(...).save(flush: true, failOnError: true)
        //new SqTKardexTa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqTKardexTa.id
    }

    void "test get"() {
        setupData()

        expect:
        sqTKardexTaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqTKardexTa> sqTKardexTaList = sqTKardexTaService.list(max: 2, offset: 2)

        then:
        sqTKardexTaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqTKardexTaService.count() == 5
    }

    void "test delete"() {
        Long sqTKardexTaId = setupData()

        expect:
        sqTKardexTaService.count() == 5

        when:
        sqTKardexTaService.delete(sqTKardexTaId)
        sessionFactory.currentSession.flush()

        then:
        sqTKardexTaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqTKardexTa sqTKardexTa = new SqTKardexTa()
        sqTKardexTaService.save(sqTKardexTa)

        then:
        sqTKardexTa.id != null
    }
}
