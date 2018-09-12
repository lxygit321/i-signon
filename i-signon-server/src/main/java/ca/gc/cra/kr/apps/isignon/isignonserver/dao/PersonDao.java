package ca.gc.cra.kr.apps.isignon.isignonserver.dao;

import ca.gc.cra.kr.apps.isignon.isignonserver.domain.Person;
import ca.gc.cra.kr.apps.isignon.isignonserver.ldap.ActiveDirectoryAttributes;
import ca.gc.cra.kr.apps.isignon.isignonserver.ldap.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.ContainerCriteria;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Component
public class PersonDao
{
    private static final int DEFAULT_COUNT_LIMIT = 100;
    private static final int DEFAULT_TIME_LIMIT = 5000; // Time in milliseconds

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LdapTemplate ldapTemplate;

    // Useful LDAP filters

    private static final ContainerCriteria IS_USER = query()
            .where(ActiveDirectoryAttributes.OBJECT_CLASS.getFieldAttributeName())
            .is(ActiveDirectoryAttributes.USER_OBJECT_CLASS.getFieldAttributeName());

    private static final ContainerCriteria IS_IN_CRA = query()
            .where(ActiveDirectoryAttributes.DISTINGUISHED_NAME.getFieldAttributeName())
            .is("*OU=CRA-ARC*");
    /*
    private static class PersonContextMapper extends AbstractContextMapper
    {

        @Override
        public Person doMapFromContext(DirContextOperations ctx)
        {
            DirContextAdapter context = (DirContextAdapter)ctx;
            Person p = new Person();
            p.setDisplayName(context.getStringAttribute(ActiveDirectoryAttributes.DISPLAY_NAME.getFieldAttributeName
            ()));
            p.setEmail(context.getStringAttribute(ActiveDirectoryAttributes.EMAIL_ADDRESS.getFieldAttributeName()));
            p.setFirstName(context.getStringAttribute(ActiveDirectoryAttributes.FIRST_NAME.getFieldAttributeName()));
            p.setLastName(context.getStringAttribute(ActiveDirectoryAttributes.LAST_NAME.getFieldAttributeName()));
            p.setPagerNumber(context.getStringAttribute(ActiveDirectoryAttributes.PAGER_NUMBER.getFieldAttributeName
            ()));
            p.setPhone(context.getStringAttribute(ActiveDirectoryAttributes.TELEPHONE_NUMBER.getFieldAttributeName()));
            p.setUserId(context.getStringAttribute(ActiveDirectoryAttributes.CANONIZED_NAME.getFieldAttributeName()));
            p.setDn(context.getDn());
            return p;
        }
    }
*/

    @PostConstruct
    void postConstructHandler()
    {
        this.ldapTemplate.setDefaultCountLimit(DEFAULT_COUNT_LIMIT);
        this.ldapTemplate.setDefaultTimeLimit(DEFAULT_TIME_LIMIT);
    }

    public Person findByUserId(String userId)
    {

        return personRepository.findByUserId(userId);
    }

    public List<Person> findMultipleUserIds(List<String> userIdList)
    {

        return null;
    }

    /**
     * Find users using a search pattern on the display name.
     *
     * @param searchPattern
     *         The search pattern. A space in the search pattern string is interpreted
     *         as a wild card ("*"). For example: a search patter of:
     *         <code>" userid X "</code>
     *         is interpreted as:
     *         <code>"*userid*x*"</code>.
     *
     * @return List of {@codePerson}, or empty list is none is found.
     */
    public List<Person> findUserByName(String searchPattern)
    {
        final ContainerCriteria searchCriteria = query()
                .where(ActiveDirectoryAttributes.DISPLAY_NAME.getFieldAttributeName())
                .whitespaceWildcardsLike(searchPattern);

        List<Person> tempResults = ldapTemplate.find(IS_USER.and(searchCriteria), Person.class);

        return tempResults.stream()
                .filter(p -> p.getDn().toString().contains("OU=CRA-ARC"))
                .collect(Collectors.toList());
    }
}
