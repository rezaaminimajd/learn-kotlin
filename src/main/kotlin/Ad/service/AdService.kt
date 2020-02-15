package Ad.service

import Ad.model.AdEvent
import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.repository.AdRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class AdService(private val repository: AdRepository,
                private val objectReader: ObjectMapper) {

    @KafkaListener(topics = ["task"], groupId = "adEvent")
    fun saveImpressionEvent(jsonImpressionEvent: String) {
        println("--------READ--------")
        println(jsonImpressionEvent)
        println("--------READ--------")

        val impressionEvent = objectReader.readValue(jsonImpressionEvent, ImpressionEvent::class.java)
        val adEvent = AdEvent(impressionEvent.requestId,
                impressionEvent.adId,
                impressionEvent.adTitle,
                impressionEvent.advertiserCost,
                impressionEvent.appId,
                impressionEvent.appTitle,
                impressionEvent.impressionTime,
                0)
        repository.save(adEvent)
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
        return response
    }
}