package CENRALSQ

import grails.gorm.services.Service

@Service(SqtAcreedor)
interface SqtAcreedorService {

    SqtAcreedor get(Serializable id)

    List<SqtAcreedor> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAcreedor save(SqtAcreedor sqtAcreedor)

}