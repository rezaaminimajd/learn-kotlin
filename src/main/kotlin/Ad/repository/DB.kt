package Ad.repository

import Ad.model.AdEvent
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Repository

@Repository
class DB(var db: MutableList<AdEvent>) : CommandLineRunner {
    override fun run(vararg args: String?) {

    }

}