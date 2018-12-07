package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtOperacionBanamex)
interface SqtOperacionBanamexService {

    SqtOperacionBanamex get(Serializable id)

    List<SqtOperacionBanamex> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtOperacionBanamex save(SqtOperacionBanamex sqtOperacionBanamex)

}