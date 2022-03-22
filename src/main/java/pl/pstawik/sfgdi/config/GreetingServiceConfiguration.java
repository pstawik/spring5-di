package pl.pstawik.sfgdi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@PropertySource("classpath:datasource.properties")
@Configuration
@EnableConfigurationProperties(SfgConstructorConfiguration.class)
public class GreetingServiceConfiguration {

//    @Bean
//    FakeDataSource fakeDataSource (@Value("${pstawik.username}") String username,
//                                   @Value("${pstawik.password}") String password,
//                                   @Value("${pstawik.jdbcurl}") String jdbcurl) {
//
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(username);
//        fakeDataSource.setPassword(password);
//        fakeDataSource.setJdbcurl(jdbcurl);
//        return fakeDataSource;
//    }

//    @Bean
//    FakeDataSource fakeDataSource (SfgPropertiesConfiguration sfgPropertiesConfiguration) {
//
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(sfgPropertiesConfiguration.getUsername());
//        fakeDataSource.setPassword(sfgPropertiesConfiguration.getPassword());
//        fakeDataSource.setJdbcurl(sfgPropertiesConfiguration.getJdbcurl());
//        return fakeDataSource;
//    }

    @Bean
    FakeDataSource fakeDataSource (SfgConstructorConfiguration sfgConstructorConfiguration) {

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConstructorConfiguration.getUsername());
        fakeDataSource.setPassword(sfgConstructorConfiguration.getPassword());
        fakeDataSource.setJdbcurl(sfgConstructorConfiguration.getJdbcurl());
        return fakeDataSource;
    }
}
