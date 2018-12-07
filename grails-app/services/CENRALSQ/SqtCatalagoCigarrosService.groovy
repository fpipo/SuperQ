package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCatalagoCigarros)
interface SqtCatalagoCigarrosService {

    SqtCatalagoCigarros get(Serializable id)

    List<SqtCatalagoCigarros> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCatalagoCigarros save(SqtCatalagoCigarros sqtCatalagoCigarros)

}