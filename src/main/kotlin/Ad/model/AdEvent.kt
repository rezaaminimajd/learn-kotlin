package Ad.model

data class AdEvent(val requestId: String,
                   val adId: String,
                   val adTitle: String,
                   val advertiserCost: Double,
                   val appId: String,
                   val appTitle: String,
                   val impressionTime: Long,
                   var clickTime: Long)