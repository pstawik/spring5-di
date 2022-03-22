package pl.pstawik.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.pstawik.sfgdi.config.FakeDataSource;
import pl.pstawik.sfgdi.config.SfgConstructorConfiguration;
import pl.pstawik.sfgdi.config.SfgPropertiesConfiguration;
import pl.pstawik.sfgdi.controllers.*;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("----- Primary");
		System.out.println(myController.sayHello());

		System.out.println(" ------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println(" ------- Setter");
		SetterInjectionController setterInjectionController = (SetterInjectionController) ctx.getBean("setterInjectionController");
		System.out.println(setterInjectionController.getGreeting());

		System.out.println(" ------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println(" ------ FakeDataSource...");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println(" ---- Config props bean");
		SfgPropertiesConfiguration sfgPropertiesConfiguration = ctx.getBean(SfgPropertiesConfiguration.class);
		System.out.println(sfgPropertiesConfiguration.getUsername());
		System.out.println(sfgPropertiesConfiguration.getPassword());
		System.out.println(sfgPropertiesConfiguration.getJdbcurl());

		System.out.println(" ---- Constructor Binding");
		SfgConstructorConfiguration sfgConstructorConfiguration = ctx.getBean(SfgConstructorConfiguration.class);
		System.out.println(sfgConstructorConfiguration.getUsername());
		System.out.println(sfgConstructorConfiguration.getPassword());
		System.out.println(sfgConstructorConfiguration.getJdbcurl());

	}
}
