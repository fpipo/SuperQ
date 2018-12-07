package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtVentaAcumuladaProductiva)
interface SqtVentaAcumuladaProductivaService {

    SqtVentaAcumuladaProductiva get(Serializable id)

    List<SqtVentaAcumuladaProductiva> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtVentaAcumuladaProductiva save(SqtVentaAcumuladaProductiva sqtVentaAcumuladaProductiva)

}