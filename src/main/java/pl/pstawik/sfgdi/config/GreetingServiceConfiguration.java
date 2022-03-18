package pl.pstawik.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfiguration {

    @Bean
    FakeDataSource fakeDataSource (@Value("${pstawik.username}") String username,
                                   @Value("${pstawik.password}") String password,
                                   @Value("${pstawik.jdbcurl}") String jdbcurl) {

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }
}
