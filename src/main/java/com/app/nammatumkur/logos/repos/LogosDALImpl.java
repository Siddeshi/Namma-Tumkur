package com.app.nammatumkur.logos.repos;

import com.app.nammatumkur.logos.model.Logo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@Repository
public class LogosDALImpl implements LogosDAL {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Transactional
    public List<Logo> getAllLogos() throws Exception {

        try {

            logger.debug("Get all the logos");
            return mongoTemplate.findAll(Logo.class);

        } catch (Exception ex) {

            logger.error("Exception while fetching all the logos: "+ ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }

    }

    @Override
    @Transactional
    public Logo getLogoById(String id) throws Exception {

        try {

            logger.debug("Get the logo by its id");
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));
            Logo logos = mongoTemplate.findOne(query, Logo.class);
            return logos != null ? logos : null;

        } catch (Exception ex) {

            logger.error("Exception while get the logo by id: "+ ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public void addLogo(Logo logos) throws Exception {

        try {

            logger.debug("Adding a logo");
            mongoTemplate.save(logos);

        } catch (Exception ex) {

            logger.error("Exception while adding a logo: "+ ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public Logo deleteLogoById(String id) throws Exception {

        try {

            logger.debug("Deleting a logo by id");

            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));
            Logo logos = mongoTemplate.findAndRemove(query, Logo.class);
            return logos != null ? logos : null;

        } catch (Exception ex) {

            logger.error("Exception while deleting logo");
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }
}
