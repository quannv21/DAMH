package com.nhom07.DAMH_LTUD.service;

import com.nhom07.DAMH_LTUD.repository.SizeProductRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@NoArgsConstructor
public class SizeProductService {
    @Autowired
    private SizeProductRepository sizeProductRepository;
}
