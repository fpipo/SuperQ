package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtSegmentacionTiendassqServiceSpec extends Specification {

    SqtSegmentacionTiendassqService sqtSegmentacionTiendassqService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtSegmentacionTiendassq(...).save(flush: true, failOnError: true)
        //new SqtSegmentacionTiendassq(...).save(flush: true, failOnError: true)
        //SqtSegmentacionTiendassq sqtSegmentacionTiendassq = new SqtSegmentacionTiendassq(...).save(flush: true, failOnError: true)
        //new SqtSegmentacionTiendassq(...).save(flush: true, failOnError: true)
        //new SqtSegmentacionTiendassq(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtSegmentacionTiendassq.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtSegmentacionTiendassqService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtSegmentacionTiendassq> sqtSegmentacionTiendassqList = sqtSegmentacionTiendassqService.list(max: 2, offset: 2)

        then:
        sqtSegmentacionTiendassqList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtSegmentacionTiendassqService.count() == 5
    }

    void "test delete"() {
        Long sqtSegmentacionTiendassqId = setupData()

        expect:
        sqtSegmentacionTiendassqService.count() == 5

        when:
        sqtSegmentacionTiendassqService.delete(sqtSegmentacionTiendassqId)
        sessionFactory.currentSession.flush()

        then:
        sqtSegmentacionTiendassqService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtSegmentacionTiendassq sqtSegmentacionTiendassq = new SqtSegmentacionTiendassq()
        sqtSegmentacionTiendassqService.save(sqtSegmentacionTiendassq)

        then:
        sqtSegmentacionTiendassq.id != null
    }
}
