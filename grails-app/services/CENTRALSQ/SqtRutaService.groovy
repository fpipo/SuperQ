package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRuta)
interface SqtRutaService {

    SqtRuta get(Serializable id)

    List<SqtRuta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRuta save(SqtRuta sqtRuta)

}