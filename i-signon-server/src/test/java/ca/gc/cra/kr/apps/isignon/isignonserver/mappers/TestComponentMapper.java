package ca.gc.cra.kr.apps.isignon.isignonserver.mappers;

import ca.gc.cra.kr.apps.isignon.isignonserver.dao.PacmanComponentDao;
import ca.gc.cra.kr.apps.isignon.isignonserver.domain.PacmanComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestComponentMapper
{
    @Autowired
    private PacmanComponentDao PacmanComponentDao;


    @DisplayName("Simple test to retrieve all components")
    @Test
    void findAllComponents() {

        // ======
        // Given
        // ======

        int expectedSize = 2891;
        int maxNumberOfRecords = 100;

        // =====
        // When
        // =====

        List<PacmanComponent> components = PacmanComponentDao.findAllComponents();

        // =====
        // Then
        // =====

        assertNotNull(components);
        //assertThat(components, not(emptyCollectionOf(PacmanComponent.class)));
        assertTrue(!components.isEmpty());
        assertThat(expectedSize, equalTo(expectedSize));
        System.out.println("Size = " + components.size());
        components.stream().limit(maxNumberOfRecords).forEach( comp -> System.out.println(comp));

    }

}
