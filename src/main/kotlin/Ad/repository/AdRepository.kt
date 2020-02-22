//package Ad.repository
//
//import Ad.model.AdEvent
//import org.springframework.data.mongodb.repository.DeleteQuery
//import org.springframework.data.mongodb.repository.MongoRepository
//import org.springframework.data.mongodb.repository.Query
//import org.springframework.data.repository.CrudRepository
//import org.springframework.stereotype.Repository
//import java.util.*
//
//@Repository
//interface AdRepository : MongoRepository<AdEvent, String> {
//
//    @Query("{'requestId' : ?0}")
//    fun findAd(requestId: String): AdEvent?
//
//    @DeleteQuery("{'requestId' : ?0}")
//    fun deleteAd(p0: String)
//
////    fun saveNew(adEvent: AdEvent) {
////        deleteByRequestId(adEvent.requestId)
////        save(adEvent)
////    }
//
//
//}