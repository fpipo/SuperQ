package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRecargaServicios)
interface SqtRecargaServiciosService {

    SqtRecargaServicios get(Serializable id)

    List<SqtRecargaServicios> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRecargaServicios save(SqtRecargaServicios sqtRecargaServicios)

}