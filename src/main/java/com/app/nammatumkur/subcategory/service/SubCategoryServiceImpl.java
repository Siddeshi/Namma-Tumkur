package com.app.nammatumkur.subcategory.service;

import com.app.nammatumkur.education.model.Education;
import com.app.nammatumkur.education.repos.EducationRepository;
import com.app.nammatumkur.logos.model.Logo;
import com.app.nammatumkur.subcategory.model.SubCategory;
import com.app.nammatumkur.subcategory.repos.SubCategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    private final EducationRepository educationRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, EducationRepository educationRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.educationRepository = educationRepository;

    }

    @Override
    public List<SubCategory> findByType(String type) throws Exception {
        logger.debug("find category by id");
        return subCategoryRepository.findByType(type);
    }

    @Override
    public Object save(String subcatStr, MultipartFile file) throws Exception {

        try {

            logger.debug("Saving new category");
            ObjectMapper objectMapper = new ObjectMapper();
            SubCategory subCategory = objectMapper.readValue(new JSONObject(subcatStr).getJSONObject("category").toString(), SubCategory.class);

            Logo logoObj = objectMapper.readValue(new JSONObject(subcatStr).getJSONObject("logo").toString(), Logo.class);

            Object object = objectMapper.readValue(new JSONObject(subcatStr).getJSONObject(new JSONObject(subcatStr).getJSONObject("category").getString("type")).toString(), Education.class);

            Logo logo = new Logo(file.getBytes(), logoObj.getDescription(), logoObj.getFilename(), file.getContentType(), new Date());

            subCategory.setLogo(logo);

            String type = new JSONObject(subcatStr).getJSONObject("category").getString("type");

            switch (type) {

                case "Education":
                    Education education = (Education) object;
                    if (!educationRepository.existsByName(education.getName())) { //verify if its exists

                        educationRepository.save(education);

                    } else {

                        // udpate to existing repo
                        Education education1 = educationRepository.findByName(education.getName());
                        education1.setAbout(education.getAbout());
                        education1.setContactDetails(education.getContactDetails());
                        educationRepository.save(education1);

                    }
                    break;
                case "Restaurants":
                    break;
                default:
                    break;
            }

            return subCategoryRepository.save(subCategory).getName() + " saved successfully";

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {

        }
    }

    @Override
    public Object removeSubCat(String id) throws Exception {

        try {

            logger.debug("Removing subcategory: " + id);

            if (!subCategoryRepository.exists(id))
                return "Not exist";
            else
                subCategoryRepository.delete(id);

            return "Removed successfully";

        } catch (Exception ex) {

            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    public Education findByTypeAndName(String type, String name) throws Exception {
        try {

            switch (type) {

                case "Education":
                    return educationRepository.findByName(name);
                case "Restaurants":
                    break;
                default:
                    return null;
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

        }
        return null;
    }
}
