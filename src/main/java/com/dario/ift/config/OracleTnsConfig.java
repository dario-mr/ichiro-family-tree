package com.dario.ift.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import static java.lang.String.format;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
public class OracleTnsConfig implements ApplicationListener<ApplicationPreparedEvent> {

    private static final String ORACLE_TNS_ADMIN = "oracle.net.tns_admin";
    private static final String TNS_ADMIN = "TNS_ADMIN";

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        configure();
    }

    private void configure() {
        if (!configureFromOracleTnsAdmin() && !configureFromTnsAdmin()) {
            throw new IllegalStateException(format("System property '%s' or '%s' must be set in order to setup the Oracle DB connection.",
                    ORACLE_TNS_ADMIN, TNS_ADMIN));
        }
        log.info("System property '{}' set to '{}'", ORACLE_TNS_ADMIN, System.getProperty(ORACLE_TNS_ADMIN));
    }

    private boolean configureFromOracleTnsAdmin() {
        String oracleTnsAdmin = System.getProperty(ORACLE_TNS_ADMIN);
        log.info("Retrieved Oracle TNS admin from system property '{}' with value '{}'", ORACLE_TNS_ADMIN, oracleTnsAdmin);
        return hasText(oracleTnsAdmin);
    }

    private boolean configureFromTnsAdmin() {
        String tnsAdmin = System.getenv(TNS_ADMIN);
        log.info("Retrieved Oracle TNS admin from system property '{}' with value '{}'", TNS_ADMIN, tnsAdmin);
        if (hasText(tnsAdmin)) {
            System.setProperty(ORACLE_TNS_ADMIN, tnsAdmin);
            return true;
        }
        return false;
    }

}