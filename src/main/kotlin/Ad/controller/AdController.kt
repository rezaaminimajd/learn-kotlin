package Ad.controller

import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.service.AdService
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event")
class AdController(private val service: AdService) {

    @PostMapping("/impression")
    fun getImpression(@RequestBody request: ImpressionEvent): String {
        println(request.requestId)
        return service.saveImpressionEvent(request)
    }

    @PostMapping("/click")
    fun getClick(@RequestBody request: ClickEvent): String {
        println(request.requestId)
        return service.setClickEventTime(request)
    }
}