package Ad.service

import Ad.model.AdEvent
import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.repository.AdRepository
import org.springframework.stereotype.Service

@Service
class AdService(private val repository: AdRepository) {

    fun saveImpressionEvent(impressionEvent: ImpressionEvent): String {
        val adEvent = AdEvent(impressionEvent.requestId,
                impressionEvent.adId,
                impressionEvent.adTitle,
                impressionEvent.advertiserCost,
                impressionEvent.appId,
                impressionEvent.appTitle,
                impressionEvent.impressionTime,
                0)
        repository.insert(adEvent)
        return "OK 200"
    }

    fun setClickEventTime(clickEvent: ClickEvent): String {
        var response = "Not Found Request Id"
        val all = repository.findAll()
        all.forEach { ad ->
            if (ad.requestId == clickEvent.requestId) {
                response = "OK 200"
                ad.clickTime = clickEvent.clickTime
            }
        }
        repository.saveAll(all)
        return "OK 200"
    }
}