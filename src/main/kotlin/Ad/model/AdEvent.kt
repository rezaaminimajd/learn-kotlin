package Ad.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
//import org.springframework.data.cassandra.core.mapping.PrimaryKey
//import org.springframework.data.cassandra.core.mapping.Table
import org.springframework.data.mongodb.core.mapping.Document

@Table
data class AdEvent(@PrimaryKey val requestId: String,
                   @Column val adId: String,
                   @Column val adTitle: String,
                   @Column val advertiserCost: Double,
                   @Column val appId: String,
                   @Column val appTitle: String,
                   @Column val impressionTime: Long,
                   @Column var clickTime: Long)