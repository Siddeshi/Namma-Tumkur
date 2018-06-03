package com.app.nammatumkur.subcategory.service;

import com.app.nammatumkur.attractions.model.Attractions;
import com.app.nammatumkur.attractions.repos.AttractionsRepository;
import com.app.nammatumkur.education.model.Education;
import com.app.nammatumkur.education.repos.EducationRepository;
import com.app.nammatumkur.hospitals.model.Hospitals;
import com.app.nammatumkur.hospitals.repos.HospitalsRepository;
import com.app.nammatumkur.hotspots.model.Hotspots;
import com.app.nammatumkur.hotspots.repos.HotspotsRepository;
import com.app.nammatumkur.logos.model.Logo;
import com.app.nammatumkur.restaurants.model.Restaurants;
import com.app.nammatumkur.restaurants.repos.RestaurantsRepository;
import com.app.nammatumkur.subcategory.model.SubCategory;
import com.app.nammatumkur.subcategory.repos.SubCategoryRepository;
import com.app.nammatumkur.temples.model.Temples;
import com.app.nammatumkur.temples.repos.TemplesRepository;
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

    private final SubCategoryRepository subCategoryRepository;

    private final EducationRepository educationRepository;

    private final AttractionsRepository attractionsRepository;

    private final RestaurantsRepository restaurantsRepository;

    private final TemplesRepository templesRepository;

    private final HospitalsRepository hospitalsRepository;

    private final HotspotsRepository hotspotsRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, EducationRepository educationRepository, AttractionsRepository attractionsRepository, RestaurantsRepository restaurantsRepository, TemplesRepository templesRepository, HospitalsRepository hospitalsRepository, HotspotsRepository hotspotsRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.educationRepository = educationRepository;

        this.attractionsRepository = attractionsRepository;
        this.restaurantsRepository = restaurantsRepository;
        this.templesRepository = templesRepository;
        this.hospitalsRepository = hospitalsRepository;
        this.hotspotsRepository = hotspotsRepository;
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

            Object object = objectMapper.readValue(new JSONObject(subcatStr).getJSONObject(new JSONObject(subcatStr).getJSONObject("category").getString("type")).toString(), Education.class);

            Logo logo = new Logo(file.getBytes(), file.getOriginalFilename(), file.getContentType(), new Date());

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
                    Restaurants restaurants = (Restaurants) object;
                    if (!restaurantsRepository.existsByName(restaurants.getName())) { //verify if its exists

                        restaurantsRepository.save(restaurants);

                    } else {

                        // udpate to existing repo
                        Restaurants restaurants1 = restaurantsRepository.findByName(restaurants.getName());
                        restaurants1.setAbout(restaurants.getAbout());
                        restaurants1.setContactDetails(restaurants.getContactDetails());
                        restaurantsRepository.save(restaurants1);

                    }
                    break;
                case "Attractions":
                    Attractions attractions = (Attractions) object;
                    if (!attractionsRepository.existsByName(attractions.getName())) { //verify if its exists

                        attractionsRepository.save(attractions);

                    } else {

                        // udpate to existing repo
                        Attractions attractions1 = attractionsRepository.findByName(attractions.getName());
                        attractions1.setAbout(attractions.getAbout());
                        attractions1.setContactDetails(attractions.getContactDetails());
                        attractionsRepository.save(attractions1);

                    }
                    break;
                case "Temples":
                    Temples temples = (Temples) object;
                    if (!templesRepository.existsByName(temples.getName())) { //verify if its exists

                        templesRepository.save(temples);

                    } else {

                        // udpate to existing repo
                        Temples temples1 = templesRepository.findByName(temples.getName());
                        temples1.setAbout(temples.getAbout());
                        temples1.setContactDetails(temples.getContactDetails());
                        templesRepository.save(temples1);

                    }
                    break;
                case "Hospitals":
                    Hospitals hospitals = (Hospitals) object;
                    if (!hospitalsRepository.existsByName(hospitals.getName())) { //verify if its exists

                        hospitalsRepository.save(hospitals);

                    } else {

                        // udpate to existing repo
                        Hospitals hospitals1 = hospitalsRepository.findByName(hospitals.getName());
                        hospitals1.setAbout(hospitals.getAbout());
                        hospitals1.setContactDetails(hospitals.getContactDetails());
                        hospitalsRepository.save(hospitals1);

                    }
                    break;
                case "Hotspots":
                    Hotspots hotspots = (Hotspots) object;
                    if (!hotspotsRepository.existsByName(hotspots.getName())) { //verify if its exists

                        hotspotsRepository.save(hotspots);

                    } else {

                        // udpate to existing repo
                        Hotspots hotspots1 = hotspotsRepository.findByName(hotspots.getName());
                        hotspots1.setAbout(hotspots.getAbout());
                        hotspots1.setContactDetails(hotspots.getContactDetails());
                        hotspotsRepository.save(hotspots1);

                    }
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
    public Object findByTypeAndName(String type, String name) throws Exception {
        try {

            switch (type) {

                case "Education":
                    if (!educationRepository.existsByName(name))
                        return "Name with " + name + "not exist";
                    else
                        return educationRepository.findByName(name);
                case "Restaurants":
                    if (!restaurantsRepository.existsByName(name))
                        return "Name with " + name + "not exist";
                    else
                        return restaurantsRepository.findByName(name);
                case "Attractions":
                    if (!attractionsRepository.existsByName(name))
                        return "Name with " + name + "not exist";
                    else
                        return attractionsRepository.findByName(name);
                case "Temples":
                    if (!templesRepository.existsByName(name))
                        return "Name with " + name + "not exist";
                    else
                        return templesRepository.findByName(name);
                case "Hospitals":
                    if (!hospitalsRepository.existsByName(name))
                        return "Name with " + name + "not exist";
                    else
                        return hospitalsRepository.findByName(name);
                case "Hotspots":
                    if (!hotspotsRepository.existsByName(name))
                        return "Name with " + name + "not exist";
                    else
                        return hotspotsRepository.findByName(name);
                default:
                    return null;
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

        }
        return null;
    }

    @Override
    public void deleteAll() throws Exception {

        educationRepository.deleteAll();
    }
}
