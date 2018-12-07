package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtOperacionBanamexServiceSpec extends Specification {

    SqtOperacionBanamexService sqtOperacionBanamexService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtOperacionBanamex(...).save(flush: true, failOnError: true)
        //new SqtOperacionBanamex(...).save(flush: true, failOnError: true)
        //SqtOperacionBanamex sqtOperacionBanamex = new SqtOperacionBanamex(...).save(flush: true, failOnError: true)
        //new SqtOperacionBanamex(...).save(flush: true, failOnError: true)
        //new SqtOperacionBanamex(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtOperacionBanamex.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtOperacionBanamexService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtOperacionBanamex> sqtOperacionBanamexList = sqtOperacionBanamexService.list(max: 2, offset: 2)

        then:
        sqtOperacionBanamexList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtOperacionBanamexService.count() == 5
    }

    void "test delete"() {
        Long sqtOperacionBanamexId = setupData()

        expect:
        sqtOperacionBanamexService.count() == 5

        when:
        sqtOperacionBanamexService.delete(sqtOperacionBanamexId)
        sessionFactory.currentSession.flush()

        then:
        sqtOperacionBanamexService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtOperacionBanamex sqtOperacionBanamex = new SqtOperacionBanamex()
        sqtOperacionBanamexService.save(sqtOperacionBanamex)

        then:
        sqtOperacionBanamex.id != null
    }
}
