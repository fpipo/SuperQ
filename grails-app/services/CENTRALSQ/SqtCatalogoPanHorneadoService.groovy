package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCatalogoPanHorneado)
interface SqtCatalogoPanHorneadoService {

    SqtCatalogoPanHorneado get(Serializable id)

    List<SqtCatalogoPanHorneado> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCatalogoPanHorneado save(SqtCatalogoPanHorneado sqtCatalogoPanHorneado)

}