package com.example.demo.service.impl;

import com.example.demo.entities.Asset;
import com.example.demo.entities.AssetOffice;
import com.example.demo.entities.Office;
import com.example.demo.repository.AssetOfficeRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.OfficeRepository;
import com.example.demo.service.AssetOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetOfficeServiceImpl implements AssetOfficeService {
    @Autowired
    AssetOfficeRepository assetOfficeRepository;
    @Autowired
    AssetRepository assetRepository;
    @Autowired
    OfficeRepository officeRepository;
    @Override
    public AssetOffice createAssetOffice(AssetOffice assetOffice) {
        if (assetOffice.getAsset() == null || assetOffice.getOffice() == null) {
            throw new RuntimeException("nullll");
        }
        Asset asset = assetRepository.findById(assetOffice.getAsset().getId().intValue())
                .orElseThrow(() -> new RuntimeException("Asset id: " + assetOffice.getAsset().getId()));
        Office office = officeRepository.findById(assetOffice.getOffice().getId())
                .orElseThrow(() -> new RuntimeException("Office id: " + assetOffice.getOffice().getId()));
        assetOffice.setAsset(asset);
        assetOffice.setOffice(office);
        return assetOfficeRepository.save(assetOffice);
    }
}
