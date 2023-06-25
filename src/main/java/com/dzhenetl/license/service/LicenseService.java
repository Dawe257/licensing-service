package com.dzhenetl.license.service;

import com.dzhenetl.license.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    @Autowired
    private MessageSource messages;

    public License getLicense(String licenseId, String organizationId) {
        return License.builder()
                .id(new Random().nextInt(1000))
                .licenseId(licenseId)
                .organizationId(organizationId)
                .description("Software product")
                .productName("Ostock")
                .licenseType("full")
                .build();
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage(
                    "license.create.message", null, locale), license);
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage(
                    "license.update.message", null, null), license);
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format(
                "Deleting license with id %s for the organization %s",
                licenseId, organizationId);
    }
}
