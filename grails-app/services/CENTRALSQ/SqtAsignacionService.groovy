package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCajeroTienda)
interface SqtAsignacionService {

    SqtCajeroTienda get(Serializable id)

    List<SqtCajeroTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCajeroTienda save(SqtCajeroTienda sqtAsignacion)

}