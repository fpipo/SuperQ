package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtHistoricoPrecio)
interface SqtHistoricoPrecioService {

    SqtHistoricoPrecio get(Serializable id)

    List<SqtHistoricoPrecio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtHistoricoPrecio save(SqtHistoricoPrecio sqtHistoricoPrecio)

}