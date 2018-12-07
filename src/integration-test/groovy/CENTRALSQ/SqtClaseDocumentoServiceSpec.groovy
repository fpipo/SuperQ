package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtClaseDocumentoServiceSpec extends Specification {

    SqtClaseDocumentoService sqtClaseDocumentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtClaseDocumento(...).save(flush: true, failOnError: true)
        //new SqtClaseDocumento(...).save(flush: true, failOnError: true)
        //SqtClaseDocumento sqtClaseDocumento = new SqtClaseDocumento(...).save(flush: true, failOnError: true)
        //new SqtClaseDocumento(...).save(flush: true, failOnError: true)
        //new SqtClaseDocumento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtClaseDocumento.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtClaseDocumentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtClaseDocumento> sqtClaseDocumentoList = sqtClaseDocumentoService.list(max: 2, offset: 2)

        then:
        sqtClaseDocumentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtClaseDocumentoService.count() == 5
    }

    void "test delete"() {
        Long sqtClaseDocumentoId = setupData()

        expect:
        sqtClaseDocumentoService.count() == 5

        when:
        sqtClaseDocumentoService.delete(sqtClaseDocumentoId)
        sessionFactory.currentSession.flush()

        then:
        sqtClaseDocumentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtClaseDocumento sqtClaseDocumento = new SqtClaseDocumento()
        sqtClaseDocumentoService.save(sqtClaseDocumento)

        then:
        sqtClaseDocumento.id != null
    }
}
