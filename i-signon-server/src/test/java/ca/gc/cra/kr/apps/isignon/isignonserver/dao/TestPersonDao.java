package ca.gc.cra.kr.apps.isignon.isignonserver.dao;

import ca.gc.cra.kr.apps.isignon.isignonserver.domain.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The purpose of this class is to test all the functionality of the {@code PersonDao}.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestPersonDao
{
    @Autowired
    private PersonDao personDao;

    /**
     * Testing the retrieval of a single LDAP user.
     */
    @DisplayName("Simple LDAP retrieval")
    @Test
    void findByUserId()
    {

        // ======
        // Given
        // ======

        String testUserId = "yxl123";
        String expectedFirstName = "Yvon";
        String expectedLastname = "Levesque";

        // =====
        // When
        // =====

        final Person person = personDao.findByUserId(testUserId);

        // =====
        // Then
        // =====

        assertNotNull(person);
        assertAll("Find by userId failed",
                () -> assertThat(person.getFirstName(), is(equalToIgnoringCase(expectedFirstName))),
                () -> assertThat(person.getLastName(), equalToIgnoringCase(expectedLastname))
                 );
        System.out.println("Person = " + person);
    }

    @DisplayName("Text search on display name")
    @ParameterizedTest(name = "{index} => Pattern: ''{0}''")
    @CsvSource({"leves ", "levesque yvon", "''"})
    void display_name_text_search(String testSearchPattern) {

        // ======
        // Given
        // ======

        // =====
        // When
        // =====

        List<Person> results = personDao.findUserByName(testSearchPattern);

        // =====
        // Then
        // =====

        assertNotNull(results);
        assertTrue(results.size() > 0);
        System.out.println("size = " + results.size());
        results.forEach(p -> System.out.println(p));
    }
}
