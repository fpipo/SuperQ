package CENTRALSQ

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SqtRolesServiceSpec extends Specification {

    SqtRolesService sqtRolesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SqtRoles(...).save(flush: true, failOnError: true)
        //new SqtRoles(...).save(flush: true, failOnError: true)
        //SqtRoles sqtRoles = new SqtRoles(...).save(flush: true, failOnError: true)
        //new SqtRoles(...).save(flush: true, failOnError: true)
        //new SqtRoles(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sqtRoles.id
    }

    void "test get"() {
        setupData()

        expect:
        sqtRolesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SqtRoles> sqtRolesList = sqtRolesService.list(max: 2, offset: 2)

        then:
        sqtRolesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sqtRolesService.count() == 5
    }

    void "test delete"() {
        Long sqtRolesId = setupData()

        expect:
        sqtRolesService.count() == 5

        when:
        sqtRolesService.delete(sqtRolesId)
        sessionFactory.currentSession.flush()

        then:
        sqtRolesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SqtRoles sqtRoles = new SqtRoles()
        sqtRolesService.save(sqtRoles)

        then:
        sqtRoles.id != null
    }
}
