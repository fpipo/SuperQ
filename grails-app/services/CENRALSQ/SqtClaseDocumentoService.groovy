package CENRALSQ

import grails.gorm.services.Service

@Service(SqtClaseDocumento)
interface SqtClaseDocumentoService {

    SqtClaseDocumento get(Serializable id)

    List<SqtClaseDocumento> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtClaseDocumento save(SqtClaseDocumento sqtClaseDocumento)

}