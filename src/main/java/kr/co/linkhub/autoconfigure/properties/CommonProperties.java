package kr.co.linkhub.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "popbill")
public class CommonProperties {
    private String LinkID = null;
    private String SecretKey = null;
    private boolean isTest = false;
    private boolean useStaticIP = false;
    private boolean useGAIP = false;
    private boolean useLocalTimeYN = true;
    private boolean isIPRestrectOnOff = true;
    
    private String AuthURL = null;
    private String ServiceURL = null;
    private String TestServiceURL = null;
    
    private String ProxyIP = null;
    private Integer ProxyPort =null;

    public String getLinkId() {
        return this.LinkID;
    }
    public void setLinkId(String linkID) {
        this.LinkID = linkID;
    }

    public String getSecretKey() {
        return this.SecretKey;
    }
    public void setSecretKey(String secretKey) {
        this.SecretKey = secretKey;
    }

    public boolean isTest() {
        return this.isTest;
    }
    public void setTest(boolean isTest) {
        this.isTest = isTest;
    }

    public boolean isUseStaticIp() {
        return this.useStaticIP;
    }
    public void setUseStaticIp(boolean useStaticIP) {
        this.useStaticIP = useStaticIP;
    }

    public boolean isUseGaIp() {
        return useGAIP;
    }
    public void setUseGaIp(boolean useGAIP) {
        this.useGAIP = useGAIP;
    }

    public boolean isUseLocalTimeYn() {
        return useLocalTimeYN;
    }
    public void setUseLocalTimeYn(boolean useLocalTimeYN) {
        this.useLocalTimeYN = useLocalTimeYN;
    }

    public boolean isIpRestrectOnOff() {
        return isIPRestrectOnOff;
    }
    public void setIpRestrectOnOff(boolean isIPRestrectOnOff) {
        this.isIPRestrectOnOff = isIPRestrectOnOff;
    }

    public String getAuthUrl() {
        return this.AuthURL;
    }
    public void setAutUrl(String authURL) {
        this.AuthURL = authURL;
    }

    public String getServiceUrl() {
        return this.ServiceURL;
    }
    public void setServiceUrl(String serviceURL) {
        this.ServiceURL = serviceURL;
    }

    public String getTestServiceUrl() {
        return this.TestServiceURL;
    }
    public void setTestServiceUrl(String testServiceURL) {
        this.TestServiceURL = testServiceURL;
    }

    public String getProxyIp() {
        return this.ProxyIP;
    }
    public void setProxyIp(String proxyIP) {
        this.ProxyIP = proxyIP;
    }

    public Integer getProxyPort() {
        return this.ProxyPort;
    }
    public void setProxyPort(Integer proxyPort) {
        this.ProxyPort = proxyPort;
    }
}
