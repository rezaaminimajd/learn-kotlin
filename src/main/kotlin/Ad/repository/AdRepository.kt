package Ad.repository

import Ad.model.AdEvent
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdRepository : MongoRepository<AdEvent, String> {

}