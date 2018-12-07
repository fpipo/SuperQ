package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtNuevoSubgrupo)
interface SqtNuevoSubgrupoService {

    SqtNuevoSubgrupo get(Serializable id)

    List<SqtNuevoSubgrupo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtNuevoSubgrupo save(SqtNuevoSubgrupo sqtNuevoSubgrupo)

}