package com.hibernatejpa.service.impl;

import com.hibernatejpa.model.Education;
import com.hibernatejpa.repository.EducationRepository;
import com.hibernatejpa.repository.impl.EducationRepositoryImpl;
import com.hibernatejpa.service.EducationService;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    EducationRepository educationRepository=new EducationRepositoryImpl();

    @Override
    public boolean saveEducation(Education education) {
        return this.educationRepository.saveEducation(education);
    }

    @Override
    public boolean updateEducation(Education education) {
        return this.educationRepository.updateEducation(education);
    }

    @Override
    public boolean removeEducation(Education education) {
        return this.educationRepository.removeEducation(education);
    }

    @Override
    public Education findById(Integer id) {
        return this.educationRepository.findById(id);
    }

    @Override
    public List<Education> findEducations() {
        return this.educationRepository.findEducations();
    }

    @Override
    public Education findWithAdvertisementById(Integer id) {
        return this.educationRepository.findWithAdvertisementById(id);
    }
}
