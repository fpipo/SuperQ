package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPresupuestoVentas)
interface SqtPresupuestoVentasService {

    SqtPresupuestoVentas get(Serializable id)

    List<SqtPresupuestoVentas> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPresupuestoVentas save(SqtPresupuestoVentas sqtPresupuestoVentas)

}