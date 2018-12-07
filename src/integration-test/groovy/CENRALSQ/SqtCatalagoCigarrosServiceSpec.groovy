package CENRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtCatalagoCigarrosServiceSpec extends Specification {

    SqtCatalagoCigarrosService sqtCatalagoCigarrosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtCatalagoCigarros(...).save(flush: true, failOnError: true)
        //new SqtCatalagoCigarros(...).save(flush: true, failOnError: true)
        //SqtCatalagoCigarros sqtCatalagoCigarros = new SqtCatalagoCigarros(...).save(flush: true, failOnError: true)
        //new SqtCatalagoCigarros(...).save(flush: true, failOnError: true)
        //new SqtCatalagoCigarros(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtCatalagoCigarros.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtCatalagoCigarrosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtCatalagoCigarros> sqtCatalagoCigarrosList = sqtCatalagoCigarrosService.list(max: 2, offset: 2)

        then:
        sqtCatalagoCigarrosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtCatalagoCigarrosService.count() == 5
    }

    void "test delete"() {
        Long sqtCatalagoCigarrosId = setupData()

        expect:
        sqtCatalagoCigarrosService.count() == 5

        when:
        sqtCatalagoCigarrosService.delete(sqtCatalagoCigarrosId)
        sessionFactory.currentSession.flush()

        then:
        sqtCatalagoCigarrosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtCatalagoCigarros sqtCatalagoCigarros = new SqtCatalagoCigarros()
        sqtCatalagoCigarrosService.save(sqtCatalagoCigarros)

        then:
        sqtCatalagoCigarros.id != null
    }
}
