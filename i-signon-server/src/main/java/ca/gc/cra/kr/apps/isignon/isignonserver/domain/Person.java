package ca.gc.cra.kr.apps.isignon.isignonserver.domain;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(objectClasses = {"user"})
public class Person
{
    @Id
    private Name dn;

    @Attribute(name = "telephoneNumber")
    private String phone;

    @Attribute(name = "cn")
    private String userId;

    @Attribute(name = "displayName")
    private String displayName;

    @Attribute(name = "givenName")
    private String firstName;

    @Attribute(name = "sn")
    private String lastName;

    @Attribute(name = "mail")
    private String email;

    @Attribute(name = "pager")
    private String pagerNumber;
}