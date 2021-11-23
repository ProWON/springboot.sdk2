package kr.co.linkhub.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.CashbillService;
import com.popbill.api.cashbill.CashbillServiceImp;

import kr.co.linkhub.autoconfigure.properties.CashbillProperties;
import kr.co.linkhub.autoconfigure.properties.CommonProperties;

@Configuration
@ConditionalOnClass(CashbillService.class)
@EnableConfigurationProperties({ CommonProperties.class, CashbillProperties.class })
public class CashbillAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(CashbillAutoConfiguration.class);
    
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CashbillProperties cashbillProperties;
    
    @Lazy
    @Bean(name = "CashbillService")
    @ConditionalOnMissingBean
    public CashbillService cashbillServiceConfig() {
        CashbillServiceImp cashbillServiceImp = new CashbillServiceImp();
        
        cashbillServiceImp.setLinkID(cashbillProperties.getLinkId() == null || cashbillProperties.getLinkId().isEmpty() ?
                commonProperties.getLinkId() : cashbillProperties.getLinkId());
        cashbillServiceImp .setSecretKey(cashbillProperties.getSecretKey() == null || cashbillProperties.getLinkId().isEmpty() ?
                commonProperties.getSecretKey() : cashbillProperties.getSecretKey());
        cashbillServiceImp.setTest(cashbillProperties.isTest() == null ? 
                commonProperties.isTest() : cashbillProperties.isTest());
        cashbillServiceImp.setUseStaticIP(commonProperties.isUseStaticIp());
        cashbillServiceImp.setUseGAIP(commonProperties.isUseGaIp());
        cashbillServiceImp.setUseLocalTimeYN(commonProperties.isUseLocalTimeYn());
        cashbillServiceImp.setIPRestrictOnOff(commonProperties.isIpRestrectOnOff());
        cashbillServiceImp.setAuthURL(commonProperties.getAuthUrl());
        cashbillServiceImp.setServiceURL(commonProperties.getServiceUrl());
        cashbillServiceImp.setTestServiceURL(commonProperties.getTestServiceUrl());
        cashbillServiceImp.setProxyIP(commonProperties.getProxyIp());
        cashbillServiceImp.setProxyPort(commonProperties.getProxyPort());
        
        logger.info("POPBiLL Initialized CashbillService");

        return cashbillServiceImp;
    }

}
