package CENRALSQ

import grails.gorm.services.Service

@Service(SqtAperturaTienda)
interface SqtAperturaTiendaService {

    SqtAperturaTienda get(Serializable id)

    List<SqtAperturaTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAperturaTienda save(SqtAperturaTienda sqtAperturaTienda)

}