package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleDevolucion)
interface SqtDetalleDevolucionService {

    SqtDetalleDevolucion get(Serializable id)

    List<SqtDetalleDevolucion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleDevolucion save(SqtDetalleDevolucion sqtDetalleDevolucion)

}