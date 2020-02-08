package Ad.repository

import Ad.model.AdEvent
import org.springframework.stereotype.Repository

@Repository
class DB(var db: MutableList<AdEvent>) : AdRepository {
    override fun findAll(): List<AdEvent> {
        return db
    }

    override fun insert(adEvent: AdEvent) {
        db.add(adEvent)
    }

    override fun saveAll(all: List<AdEvent>) {
        db = all.toMutableList()
    }

}