package Ad.Configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories


@Configuration
class CassandraConfig : AbstractCassandraConfiguration() {
    override fun getKeyspaceName(): String {
        return "task1"
    }

    @Bean
    override fun cluster(): CassandraClusterFactoryBean {
        val cluster = CassandraClusterFactoryBean()
        cluster.setContactPoints("116.203.183.94")
        cluster.setPort(9042)
        return cluster
    }

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.CREATE_IF_NOT_EXISTS
    }

//    override fun getEntityBasePackages(): Array<String> {
//        return arrayOf("packagename")
//    }
}