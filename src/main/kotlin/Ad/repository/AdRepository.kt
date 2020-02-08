package Ad.repository

import Ad.model.AdEvent
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface AdRepository : CassandraRepository<AdEvent, String> {
    override fun findAll(): List<AdEvent>

    fun insert(adEvent: AdEvent)

    fun saveAll(all: List<AdEvent>)
}