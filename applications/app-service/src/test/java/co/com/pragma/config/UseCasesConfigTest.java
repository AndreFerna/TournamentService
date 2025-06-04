package co.com.pragma.config;

import co.com.pragma.model.tournament.gateways.*;
import co.com.pragma.model.view.gateways.ViewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCasesConfigTest {

    @Test
    void testUseCaseBeansExist() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class)) {
            String[] beanNames = context.getBeanDefinitionNames();

            boolean useCaseBeanFound = false;
            for (String beanName : beanNames) {
                if (beanName.endsWith("UseCase")) {
                    useCaseBeanFound = true;
                    break;
                }
            }

            assertTrue(useCaseBeanFound, "No beans ending with 'Use Case' were found");
        }
    }

    @Configuration
    @Import(UseCasesConfig.class)
    static class TestConfig {

        @Bean
        public TournamentRepository tournamentRepository(){
            return Mockito.mock(TournamentRepository.class);
        }
        @Bean
        public CategoryRepository categoryRepository(){
            return Mockito.mock(CategoryRepository.class);
        }
        @Bean
        public UserRepository userRepository(){
            return Mockito.mock(UserRepository.class);
        }
        @Bean
        public PlataformGateway plataformGateway(){
            return Mockito.mock(PlataformGateway.class);
        }
        @Bean
        public VideoGameGateway videoGameGateway(){
            return Mockito.mock(VideoGameGateway.class);
        }

        @Bean
        public ViewRepository viewRepository(){
            return Mockito.mock(ViewRepository.class);
        }
    }

}