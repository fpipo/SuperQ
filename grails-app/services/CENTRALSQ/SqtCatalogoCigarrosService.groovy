package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCatalogoCigarros)
interface SqtCatalogoCigarrosService {

    SqtCatalogoCigarros get(Serializable id)

    List<SqtCatalogoCigarros> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCatalogoCigarros save(SqtCatalogoCigarros sqtCatalogoCigarros)

}