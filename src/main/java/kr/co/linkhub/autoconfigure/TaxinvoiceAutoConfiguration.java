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

import com.popbill.api.TaxinvoiceService;
import com.popbill.api.taxinvoice.TaxinvoiceServiceImp;

import kr.co.linkhub.autoconfigure.properties.CommonProperties;
import kr.co.linkhub.autoconfigure.properties.TaxinvoiceProperties;

@Configuration
@ConditionalOnClass(TaxinvoiceService.class)
@EnableConfigurationProperties({ CommonProperties.class, TaxinvoiceProperties.class })
public class TaxinvoiceAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(TaxinvoiceAutoConfiguration.class);
    
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private TaxinvoiceProperties taxinvoiceProperties;
    
    @Lazy
    @Bean(name = "TaxinvoiceService")
    @ConditionalOnMissingBean
    public TaxinvoiceService taxinvoiceServiceConfig() {
        TaxinvoiceServiceImp taxinvoiceServiceImp = new TaxinvoiceServiceImp();
        
        taxinvoiceServiceImp.setLinkID(taxinvoiceProperties.getLinkId() == null || taxinvoiceProperties.getLinkId().isEmpty() ?
                commonProperties.getLinkId() : taxinvoiceProperties.getLinkId());
        taxinvoiceServiceImp .setSecretKey(taxinvoiceProperties.getSecretKey() == null || taxinvoiceProperties.getLinkId().isEmpty() ?
                commonProperties.getSecretKey() : taxinvoiceProperties.getSecretKey());
        taxinvoiceServiceImp.setTest(taxinvoiceProperties.isTest() == null ? 
                commonProperties.isTest() : taxinvoiceProperties.isTest());
        taxinvoiceServiceImp.setUseStaticIP(commonProperties.isUseStaticIp());
        taxinvoiceServiceImp.setUseGAIP(commonProperties.isUseGaIp());
        taxinvoiceServiceImp.setUseLocalTimeYN(commonProperties.isUseLocalTimeYn());
        taxinvoiceServiceImp.setIPRestrictOnOff(commonProperties.isIpRestrectOnOff());
        taxinvoiceServiceImp.setAuthURL(commonProperties.getAuthUrl());
        taxinvoiceServiceImp.setServiceURL(commonProperties.getServiceUrl());
        taxinvoiceServiceImp.setTestServiceURL(commonProperties.getTestServiceUrl());
        taxinvoiceServiceImp.setProxyIP(commonProperties.getProxyIp());
        taxinvoiceServiceImp.setProxyPort(commonProperties.getProxyPort());
        
        logger.info("POPBiLL Initialized TaxinvoiceService");

        return taxinvoiceServiceImp;
    }

}
