package Ad.Configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext


@Configuration
class CassandraConfig : AbstractCassandraConfiguration() {
    override fun getKeyspaceName(): String {
        return "testKeySpace"
    }

    @Bean
    override fun cluster(): CassandraClusterFactoryBean {
        val cluster = CassandraClusterFactoryBean()
        cluster.setContactPoints("116.203.183.94")
        cluster.setPort(9042)
        return cluster
    }

    @Bean
    @Throws(ClassNotFoundException::class)
    override fun cassandraMapping(): CassandraMappingContext {
        return BasicCassandraMappingContext()
    }
}