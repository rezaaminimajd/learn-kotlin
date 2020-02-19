package Ad.service

import Ad.model.AdEvent
import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.repository.AdRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service

@Service
class AdService(private val repository: AdRepository,
                private val objectReader: ObjectMapper) {

    @KafkaListener(topics = ["task"], groupId = "adEvent")
    fun listener(jsonEvent: String, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: String) {
        println("--------READ--------")
        println("====> key : $key")
        println(jsonEvent)
        println("--------READ--------")
        if (key == "impression") {
            val impressionEvent = objectReader.readValue(jsonEvent, ImpressionEvent::class.java)
            saveImpressionEvent(impressionEvent)
        } else {
            val clickEvent = objectReader.readValue(jsonEvent, ClickEvent::class.java)
            setClickEventTime(clickEvent)
        }
    }

    fun saveImpressionEvent(impressionEvent: ImpressionEvent) {
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

    fun setClickEventTime(clickEvent: ClickEvent) {
        val ad = repository.findAd(clickEvent.requestId)
        ad?.clickTime = clickEvent.clickTime
        if (ad != null) {
            repository.deleteAd(clickEvent.requestId)
            repository.save(ad)
        }
    }
}