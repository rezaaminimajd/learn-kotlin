package Ad.repository

import Ad.model.AdEvent
import org.springframework.stereotype.Repository

@Repository
interface AdRepository {
    fun findAll(): List<AdEvent>

    fun insert(adEvent: AdEvent)

    fun saveAll(all: List<AdEvent>)
}