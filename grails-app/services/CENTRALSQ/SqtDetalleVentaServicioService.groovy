package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleVentaServicio)
interface SqtDetalleVentaServicioService {

    SqtDetalleVentaServicio get(Serializable id)

    List<SqtDetalleVentaServicio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleVentaServicio save(SqtDetalleVentaServicio sqtDetalleVentaServicio)

}