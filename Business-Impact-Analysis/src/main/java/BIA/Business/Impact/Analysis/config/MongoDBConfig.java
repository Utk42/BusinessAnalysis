package BIA.Business.Impact.Analysis.config;

import BIA.Business.Impact.Analysis.Model.Employees;
import BIA.Business.Impact.Analysis.Repository.EmployeesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = EmployeesRepository.class)
@Configuration
public class MongoDBConfig {

    //TODO: already 1 Admin should automatically be made
    @Bean
    CommandLineRunner commandLineRunner(EmployeesRepository employeesRepository){
        return strings->{
            employeesRepository.save(new Employees(1, "USER", "pass"));
            employeesRepository.save(new Employees(2, "ADMIN", "pass"));
        };
    }

}
