package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDatosTiendaPMServiceSpec extends Specification {

    SqtDatosTiendaPMService sqtDatosTiendaPMService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDatosTiendaPM(...).save(flush: true, failOnError: true)
        //new SqtDatosTiendaPM(...).save(flush: true, failOnError: true)
        //SqtDatosTiendaPM sqtDatosTiendaPM = new SqtDatosTiendaPM(...).save(flush: true, failOnError: true)
        //new SqtDatosTiendaPM(...).save(flush: true, failOnError: true)
        //new SqtDatosTiendaPM(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDatosTiendaPM.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDatosTiendaPMService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDatosTiendaPM> sqtDatosTiendaPMList = sqtDatosTiendaPMService.list(max: 2, offset: 2)

        then:
        sqtDatosTiendaPMList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDatosTiendaPMService.count() == 5
    }

    void "test delete"() {
        Long sqtDatosTiendaPMId = setupData()

        expect:
        sqtDatosTiendaPMService.count() == 5

        when:
        sqtDatosTiendaPMService.delete(sqtDatosTiendaPMId)
        sessionFactory.currentSession.flush()

        then:
        sqtDatosTiendaPMService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDatosTiendaPM sqtDatosTiendaPM = new SqtDatosTiendaPM()
        sqtDatosTiendaPMService.save(sqtDatosTiendaPM)

        then:
        sqtDatosTiendaPM.id != null
    }
}
