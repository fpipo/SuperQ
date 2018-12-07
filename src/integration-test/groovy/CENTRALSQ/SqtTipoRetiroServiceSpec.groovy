package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtTipoRetiroServiceSpec extends Specification {

    SqtTipoRetiroService sqtTipoRetiroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtTipoRetiro(...).save(flush: true, failOnError: true)
        //new SqtTipoRetiro(...).save(flush: true, failOnError: true)
        //SqtTipoRetiro sqtTipoRetiro = new SqtTipoRetiro(...).save(flush: true, failOnError: true)
        //new SqtTipoRetiro(...).save(flush: true, failOnError: true)
        //new SqtTipoRetiro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtTipoRetiro.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtTipoRetiroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtTipoRetiro> sqtTipoRetiroList = sqtTipoRetiroService.list(max: 2, offset: 2)

        then:
        sqtTipoRetiroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtTipoRetiroService.count() == 5
    }

    void "test delete"() {
        Long sqtTipoRetiroId = setupData()

        expect:
        sqtTipoRetiroService.count() == 5

        when:
        sqtTipoRetiroService.delete(sqtTipoRetiroId)
        sessionFactory.currentSession.flush()

        then:
        sqtTipoRetiroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtTipoRetiro sqtTipoRetiro = new SqtTipoRetiro()
        sqtTipoRetiroService.save(sqtTipoRetiro)

        then:
        sqtTipoRetiro.id != null
    }
}
