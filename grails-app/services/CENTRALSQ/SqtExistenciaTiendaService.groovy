package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtExistenciaTienda)
interface SqtExistenciaTiendaService {

    SqtExistenciaTienda get(Serializable id)

    List<SqtExistenciaTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtExistenciaTienda save(SqtExistenciaTienda sqtExistenciaTienda)

}