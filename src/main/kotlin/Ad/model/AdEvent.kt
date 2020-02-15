package Ad.model

import org.springframework.data.annotation.Id
//import org.springframework.data.cassandra.core.mapping.PrimaryKey
//import org.springframework.data.cassandra.core.mapping.Table
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class AdEvent(@Id val requestId: String,
                   val adId: String,
                   val adTitle: String,
                   val advertiserCost: Double,
                   val appId: String,
                   val appTitle: String,
                   val impressionTime: Long,
                   var clickTime: Long)