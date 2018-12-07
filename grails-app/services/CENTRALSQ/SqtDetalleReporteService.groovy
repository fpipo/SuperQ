package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleReporte)
interface SqtDetalleReporteService {

    SqtDetalleReporte get(Serializable id)

    List<SqtDetalleReporte> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleReporte save(SqtDetalleReporte sqtDetalleReporte)

}