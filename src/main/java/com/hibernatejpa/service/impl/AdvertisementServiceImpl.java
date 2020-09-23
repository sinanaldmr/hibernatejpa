package com.hibernatejpa.service.impl;

import com.hibernatejpa.model.Advertisement;
import com.hibernatejpa.repository.AdvertisementRepository;
import com.hibernatejpa.repository.impl.AdvertisementRepositoryImpl;
import com.hibernatejpa.service.AdvertisementService;

import java.util.List;

public class AdvertisementServiceImpl implements AdvertisementService {
    private AdvertisementRepository advertisementRepository=new AdvertisementRepositoryImpl();

    @Override
    public boolean saveAdvertisement(Advertisement advertisement) {
        return this.advertisementRepository.saveAdvertisement(advertisement);
    }

    @Override
    public boolean updateAdvertisement(Advertisement advertisement) {
        return this.advertisementRepository.updateAdvertisement(advertisement);
    }

    @Override
    public boolean removeAdvertisement(Advertisement advertisement) {
        return this.advertisementRepository.removeAdvertisement(advertisement);
    }

    @Override
    public Advertisement findById(Integer id) {
        return this.advertisementRepository.findById(id);
    }

    @Override
    public List<Advertisement> findByUsername(String username) {
        return this.advertisementRepository.findByUsername(username);
    }

    @Override
    public List<Advertisement> findAdvertisements() {
        return this.advertisementRepository.findAdvertisements();
    }

    @Override
    public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
        return this.advertisementRepository.findAdvertisementEntities(firstResult,maxResult);
    }
}
