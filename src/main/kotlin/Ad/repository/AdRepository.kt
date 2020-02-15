package Ad.repository

import Ad.model.AdEvent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AdRepository : CrudRepository<AdEvent, String> {

}