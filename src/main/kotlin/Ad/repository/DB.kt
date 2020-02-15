package Ad.repository

import Ad.model.AdEvent
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Repository

@Repository
class DB(var repository: AdRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val a = AdEvent("1",
                "1",
                "1",
                1.3,
                "1",
                "1",
                1,
                1)

        repository.deleteAll()
        repository.save(a)
        println("start")
    }

}