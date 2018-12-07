package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtLogServicel)
interface SqtLogServicelService {

    SqtLogServicel get(Serializable id)

    List<SqtLogServicel> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtLogServicel save(SqtLogServicel sqtLogServicel)

}