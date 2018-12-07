package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRemesasServiceSpec extends Specification {

    SqtRemesasService sqtRemesasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRemesas(...).save(flush: true, failOnError: true)
        //new SqtRemesas(...).save(flush: true, failOnError: true)
        //SqtRemesas sqtRemesas = new SqtRemesas(...).save(flush: true, failOnError: true)
        //new SqtRemesas(...).save(flush: true, failOnError: true)
        //new SqtRemesas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRemesas.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRemesasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRemesas> sqtRemesasList = sqtRemesasService.list(max: 2, offset: 2)

        then:
        sqtRemesasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRemesasService.count() == 5
    }

    void "test delete"() {
        Long sqtRemesasId = setupData()

        expect:
        sqtRemesasService.count() == 5

        when:
        sqtRemesasService.delete(sqtRemesasId)
        sessionFactory.currentSession.flush()

        then:
        sqtRemesasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRemesas sqtRemesas = new SqtRemesas()
        sqtRemesasService.save(sqtRemesas)

        then:
        sqtRemesas.id != null
    }
}
