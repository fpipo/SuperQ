package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRoles)
interface SqtRolesService {

    SqtRoles get(Serializable id)

    List<SqtRoles> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRoles save(SqtRoles sqtRoles)

}