package com.app.nammatumkur.logos.repos;

import com.app.nammatumkur.logos.model.Logo;

import java.util.List;

public interface LogosDAL {

    List<Logo> getAllLogos() throws Exception;

    Logo getLogoById(String id) throws Exception;

    void addLogo(Logo logos) throws Exception;

    Logo deleteLogoById(String id) throws Exception;
}
