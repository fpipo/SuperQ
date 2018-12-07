package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtDatosTiendaCierrePmServiceSpec extends Specification {

    SqtDatosTiendaCierrePmService sqtDatosTiendaCierrePmService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtDatosTiendaCierrePm(...).save(flush: true, failOnError: true)
        //new SqtDatosTiendaCierrePm(...).save(flush: true, failOnError: true)
        //SqtDatosTiendaCierrePm sqtDatosTiendaCierrePm = new SqtDatosTiendaCierrePm(...).save(flush: true, failOnError: true)
        //new SqtDatosTiendaCierrePm(...).save(flush: true, failOnError: true)
        //new SqtDatosTiendaCierrePm(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtDatosTiendaCierrePm.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtDatosTiendaCierrePmService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtDatosTiendaCierrePm> sqtDatosTiendaCierrePmList = sqtDatosTiendaCierrePmService.list(max: 2, offset: 2)

        then:
        sqtDatosTiendaCierrePmList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtDatosTiendaCierrePmService.count() == 5
    }

    void "test delete"() {
        Long sqtDatosTiendaCierrePmId = setupData()

        expect:
        sqtDatosTiendaCierrePmService.count() == 5

        when:
        sqtDatosTiendaCierrePmService.delete(sqtDatosTiendaCierrePmId)
        sessionFactory.currentSession.flush()

        then:
        sqtDatosTiendaCierrePmService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtDatosTiendaCierrePm sqtDatosTiendaCierrePm = new SqtDatosTiendaCierrePm()
        sqtDatosTiendaCierrePmService.save(sqtDatosTiendaCierrePm)

        then:
        sqtDatosTiendaCierrePm.id != null
    }
}
