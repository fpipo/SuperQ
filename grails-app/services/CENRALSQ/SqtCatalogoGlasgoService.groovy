package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCatalogoGlasgo)
interface SqtCatalogoGlasgoService {

    SqtCatalogoGlasgo get(Serializable id)

    List<SqtCatalogoGlasgo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCatalogoGlasgo save(SqtCatalogoGlasgo sqtCatalogoGlasgo)

}