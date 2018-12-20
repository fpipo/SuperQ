package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtPosicionCodigoServiceSpec extends Specification {

    SqtPosionCodigoService sqtPosionCodigoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtPosicionCodigo(...).save(flush: true, failOnError: true)
        //new SqtPosicionCodigo(...).save(flush: true, failOnError: true)
        //SqtPosicionCodigo sqtPosionCodigo = new SqtPosicionCodigo(...).save(flush: true, failOnError: true)
        //new SqtPosicionCodigo(...).save(flush: true, failOnError: true)
        //new SqtPosicionCodigo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtPosionCodigo.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtPosionCodigoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtPosicionCodigo> sqtPosionCodigoList = sqtPosionCodigoService.list(max: 2, offset: 2)

        then:
        sqtPosionCodigoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtPosionCodigoService.count() == 5
    }

    void "test delete"() {
        Long sqtPosionCodigoId = setupData()

        expect:
        sqtPosionCodigoService.count() == 5

        when:
        sqtPosionCodigoService.delete(sqtPosionCodigoId)
        sessionFactory.currentSession.flush()

        then:
        sqtPosionCodigoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtPosicionCodigo sqtPosionCodigo = new SqtPosicionCodigo()
        sqtPosionCodigoService.save(sqtPosionCodigo)

        then:
        sqtPosionCodigo.id != null
    }
}
