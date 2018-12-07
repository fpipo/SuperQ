package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPassword)
interface SqtPasswordService {

    SqtPassword get(Serializable id)

    List<SqtPassword> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPassword save(SqtPassword sqtPassword)

}