package BIA.Business.Impact.Analysis.config;

import BIA.Business.Impact.Analysis.Model.Employees;
import BIA.Business.Impact.Analysis.Repository.EmployeesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {EmployeesRepository.class})
@Configuration
public class MongoDbConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeesRepository employeesRepository){
        return strings -> {
            employeesRepository.save(new Employees())
        };
    }


}
