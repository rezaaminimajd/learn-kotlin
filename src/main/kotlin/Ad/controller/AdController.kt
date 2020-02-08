package Ad.controller

import Ad.model.ClickEvent
import Ad.model.ImpressionEvent
import Ad.service.AdService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class AdController(private val service: AdService) {

    @GetMapping("/impression")
    fun getImpression(@RequestBody request: ImpressionEvent): String {
        return service.saveImpressionEvent(request)
    }

    @GetMapping("/click")
    fun getClick(@RequestBody request: ClickEvent): String {
        return service.saveClickEvent(request)
    }
}