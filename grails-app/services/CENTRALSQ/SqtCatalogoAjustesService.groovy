package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCatalogoAjustes)
interface SqtCatalogoAjustesService {

    SqtCatalogoAjustes get(Serializable id)

    List<SqtCatalogoAjustes> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCatalogoAjustes save(SqtCatalogoAjustes sqtCatalogoAjustes)

}