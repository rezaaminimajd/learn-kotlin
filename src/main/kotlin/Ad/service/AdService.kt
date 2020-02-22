package Ad.service

import Ad.model.AdEvent
import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.repository.CassandraRepo
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service

@Service
class AdService(private val repository: CassandraRepo,
                private val objectReader: ObjectMapper) {

    @KafkaListener(topics = ["task"], groupId = "adEvent")
    fun listener(jsonEvent: String, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: String) {
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
        val ad = repository.findByIdOrNull(clickEvent.requestId)
        if (ad != null) {
            ad.clickTime = clickEvent.clickTime
            repository.save(ad)
        }
    }
}