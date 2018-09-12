package ca.gc.cra.kr.apps.isignon.isignonserver.ldap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.DirContextAuthenticationStrategy;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.support.SimpleDirContextAuthenticationStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableLdapRepositories
public class LdapRepositoryConfig
{
    //----------------------
    // Some default values.
    // ---------------------

    private static final ActiveDirectoryDomain DEFAULT_DOMAIN = ActiveDirectoryDomain.OMEGA;
    private static final String DEFAULT_USER = "ZZZ999G";
    private static final String DEFAULT_PASSWORD = "Autumn$1";


    @Bean
    ContextSource contextSource(){
        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl(DEFAULT_DOMAIN.getPrimaryServer());
        ldapContextSource.setUserDn(DEFAULT_USER);
        ldapContextSource.setPassword(DEFAULT_PASSWORD);
        ldapContextSource.setReferral("follow");
        ldapContextSource.setAuthenticationStrategy(new SimpleDirContextAuthenticationStrategy());
        ldapContextSource.setBase(DEFAULT_DOMAIN.getSearchScope());
        Map<String, Object> env = new HashMap<>();
        env.put("com.sun.jndi.ldap.connect.timeout", "60000"); // one minute time-out
        env.put("java.naming.ldap.attributes.binary", "tokenGroups objectSid");
        ldapContextSource.setBaseEnvironmentProperties(env);

        return ldapContextSource;
    }

    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}