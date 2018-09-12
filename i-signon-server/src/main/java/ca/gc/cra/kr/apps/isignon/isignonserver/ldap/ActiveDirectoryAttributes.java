package ca.gc.cra.kr.apps.isignon.isignonserver.ldap;

public enum ActiveDirectoryAttributes
{
    ACCOUNT_STATUS("userAccountControl"),
    ADDRESS("streetAddress"),
    AGENCY_NAME("company"),
    ASSISTANT("msExchAssistantName"),
    ASSISTANT_NUMBER("telephoneAssistant"),
    CANONIZED_NAME("cn"),
    CITY("l"),
    COUNTRY("co"),
    DEPARTMENT("department"),
    DESCRIPTION("description"),
    DISPLAY_NAME("displayName"),
    DISTINGUISHED_NAME("distinguishedName"),
    EMAIL_ADDRESS("mail"),
    EXCHANGE_STORE("homeMDB"),
    FAX_NUMBER("facsimileTelephoneNumber"),
    FIRST_NAME("givenName"),
    GROUP_MEMBERSHIP("memberOf"),
    HOME_DIRECTORY("homeDirectory"),
    HOME_NUMBER("homePhone"),
    HOME_NUMBER2("otherHomePhone"),
    LAST_LOGON_TIMESTAMP("lastLogonTimestamp"),
    LAST_MODIFIED_TIMESTAMP("whenChanged"),
    LAST_NAME("sn"),
    MANAGEDBY("managedBy"),
    MANAGEDBY_MEMBERS("msExchCoManagedByLink"),
    MAIL_NICKNAME("mailNickname"),
    MAIL_NICKNAME2("extensionAttribute13"),
    MOBILE_NUMBER("mobile"),
    OBJECT_CLASS ("objectClass"),
    OFFICE_NAME("physicalDeliveryOfficeName"),
    OU("ou"),
    PAGER_NUMBER("pager"),
    POSTAL_CODE("postalCode"),
    PRIMARY_GROUP("primaryGroupId"),
    PROVINCE("st"),
    SID("objectSid"),
    TELEPHONE_NUMBER("telephoneNumber"),
    TELEPHONE_NUMBER2("otherTelephone"),
    TITLE("title"),
    USER_OBJECT_CLASS("user");


    private String fieldAttributeName;

    ActiveDirectoryAttributes(String fieldAttributeName)
    {
        this.fieldAttributeName = fieldAttributeName;
    }

    public String getFieldAttributeName()
    {
        return this.fieldAttributeName;
    }

}
