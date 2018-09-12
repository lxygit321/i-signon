package ca.gc.cra.kr.apps.isignon.isignonserver.ldap;

import ca.gc.cra.kr.apps.isignon.isignonserver.domain.Person;
import org.springframework.data.ldap.repository.LdapRepository;

import java.util.List;

//public interface PersonRepository extends LdapRepository<Person>
public interface PersonRepository extends LdapRepository<Person>
{
    /**
     * Find a person based upon a specified user id. The user id is not case sensitive.
     *
     * @param userId
     *         The user id to search on.
     *
     * @return The user with the specified userid.
     */
    Person findByUserId(String userId);
}