package CENRALSQ

import grails.gorm.services.Service

@Service(SqtAlmacenTienda)
interface SqtAlmacenTiendaService {

    SqtAlmacenTienda get(Serializable id)

    List<SqtAlmacenTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAlmacenTienda save(SqtAlmacenTienda sqtAlmacenTienda)

}