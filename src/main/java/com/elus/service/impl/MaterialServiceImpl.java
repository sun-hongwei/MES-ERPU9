package com.elus.service.impl;

import com.elus.repository.service.IMaterialRepoService;
import com.elus.service.IMaterialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MaterialServiceImpl implements IMaterialService {

    private IMaterialRepoService iMaterialService;

    @Override
    public Boolean MESERPMaterial() {
        return iMaterialService.MESERPMaterial();
    }
}
