package ca.gc.cra.kr.apps.isignon.isignonserver.ldap;

/**
 * Provides list of LDAP servers that can be accessed. Each entry has a primary and a secondary server. An attempt to
 * access the secondary server is made when access to the primary server failed.
 */
public enum ActiveDirectoryDomain
{
    DEV("LDAP://DEVLDAP1.DEV.DCE-EIR.NET",
        "LDAP://DEVLDAP2.DEV.DCE-EIR.NET",
        "DC=DEV, DC=DCE-EIR, DC=NET",
        "DEV.DCE-EIR.NET"
    ),
    TST("LDAP://TSTLDAP1.TST.DCE-EIR.NET",
        "LDAP://TSTLDAP2.TST.DCE-EIR.NET",
        "DC=TST, DC=DCE-EIR, DC=NET",
        "TST.DCE-EIR.NET"
    ),
    OMEGA("LDAP://OMEGALDAP1", "LDAP://OMEGALDAP2", "DC=OMEGA, DC=DCE-EIR, DC=NET", "OMEGA.DCE-EIR.NET");

    private String primaryServer;
    private String secondaryServer;
    private String searchScope;
    private String textValue;

    ActiveDirectoryDomain(String primaryServer, String secondaryServer, String searchScope, String textValue)
    {
        this.primaryServer = primaryServer;
        this.secondaryServer = secondaryServer;
        this.searchScope = searchScope;
        this.textValue = textValue;
    }

    public String getPrimaryServer()
    {
        return primaryServer;
    }

    public String getSecondaryServer()
    {
        return secondaryServer;
    }

    public String getSearchScope()
    {
        return searchScope;
    }

    public String getTextValue()
    {
        return textValue;
    }
}
