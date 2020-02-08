package Ad.controller

import Ad.service.AdService
import org.springframework.stereotype.Controller

@Controller
class AdController(private val service: AdService) {

}