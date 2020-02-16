package Ad.controller

import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.service.AdService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/event")
class AdController(private val service: AdService,
                   private val kafkaTemplate: KafkaTemplate<String, String>,
                   private val objectMapper: ObjectMapper ) {

    @PostMapping("/impression")
    fun getImpression(@RequestBody request: ImpressionEvent) {
        val json = objectMapper.writeValueAsString(request)
        println(json)
        kafkaTemplate.send("task", "impression" ,json)
    }

    @PostMapping("/click")
    fun getClick(@RequestBody request: ClickEvent) {
        val json = objectMapper.writeValueAsString(request)
        println(json)
        kafkaTemplate.send("task", "click" ,json)
    }
}