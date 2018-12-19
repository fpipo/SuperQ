package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInfoAdicionalIusa)
interface SqtInfoAdicionalIusaService {

    SqtInfoAdicionalIusa get(Serializable id)

    List<SqtInfoAdicionalIusa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInfoAdicionalIusa save(SqtInfoAdicionalIusa sqtInfoAdicionalIusa)

}