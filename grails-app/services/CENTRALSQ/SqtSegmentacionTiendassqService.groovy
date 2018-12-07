package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtSegmentacionTiendassq)
interface SqtSegmentacionTiendassqService {

    SqtSegmentacionTiendassq get(Serializable id)

    List<SqtSegmentacionTiendassq> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtSegmentacionTiendassq save(SqtSegmentacionTiendassq sqtSegmentacionTiendassq)

}