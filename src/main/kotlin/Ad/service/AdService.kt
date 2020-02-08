package Ad.service

import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.repository.AdRepository
import org.springframework.stereotype.Service

@Service
class AdService(private val repository: AdRepository) {

    fun saveImpressionEvent(impressionEvent: ImpressionEvent): String {
        return "OK 200"
    }

    fun saveClickEvent(clickEvent: ClickEvent): String {
        return "OK 200"
    }
}