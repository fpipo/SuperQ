package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtSubgrupo)
interface SqtSubgrupoService {

    SqtSubgrupo get(Serializable id)

    List<SqtSubgrupo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtSubgrupo save(SqtSubgrupo sqtSubgrupo)

}