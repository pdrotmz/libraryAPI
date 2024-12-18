package io.github.pdrotmz.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driver;

    // @Bean
    public DataSource dataSource() {

        // Não recomendado para produção, pode causar lentidão
        DriverManagerDataSource dms = new DriverManagerDataSource();

        dms.setUrl(url);
        dms.setUsername(username);
        dms.setPassword(password);
        dms.setDriverClassName(driver);

        return dms;
    }

    /*
    *
    *  Documentação do Hikari
    *  https://github.com/brettwooldridge/HikariCP
    *
    * */

    @Bean
    public DataSource hikariDataSoruce() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10); // No máximo quando o server estiver lotado vai liberar 10 conexões
        config.setMinimumIdle(1); // Tamanho inicial do pool (tamanho minimo)
        config.setPoolName("library-db-pool"); // Nome da pool
        config.setMaxLifetime(600000); // Tempo máximo de vida de uma conexão dentro da pool
        config.setConnectionTimeout(100000); // Tempo pro timeout
        config.setConnectionTestQuery("select 1"); // Query de teste pra testar conexão

        return new HikariDataSource(config);

    }
}
