package Ad.repository

import Ad.model.AdEvent
import org.springframework.data.cassandra.repository.CassandraRepository

interface CassandraRepo : CassandraRepository<AdEvent, String>