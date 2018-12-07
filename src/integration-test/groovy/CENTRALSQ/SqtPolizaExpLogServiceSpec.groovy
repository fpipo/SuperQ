package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPolizaExpLogServiceSpec extends Specification {

    SqtPolizaExpLogService sqtPolizaExpLogService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPolizaExpLog(...).save(flush: true, failOnError: true)
        //new SqtPolizaExpLog(...).save(flush: true, failOnError: true)
        //SqtPolizaExpLog sqtPolizaExpLog = new SqtPolizaExpLog(...).save(flush: true, failOnError: true)
        //new SqtPolizaExpLog(...).save(flush: true, failOnError: true)
        //new SqtPolizaExpLog(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPolizaExpLog.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPolizaExpLogService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPolizaExpLog> sqtPolizaExpLogList = sqtPolizaExpLogService.list(max: 2, offset: 2)

        then:
        sqtPolizaExpLogList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPolizaExpLogService.count() == 5
    }

    void "test delete"() {
        Long sqtPolizaExpLogId = setupData()

        expect:
        sqtPolizaExpLogService.count() == 5

        when:
        sqtPolizaExpLogService.delete(sqtPolizaExpLogId)
        sessionFactory.currentSession.flush()

        then:
        sqtPolizaExpLogService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPolizaExpLog sqtPolizaExpLog = new SqtPolizaExpLog()
        sqtPolizaExpLogService.save(sqtPolizaExpLog)

        then:
        sqtPolizaExpLog.id != null
    }
}
