package com.cgs.service.base;

import com.cgs.dao.CompanyDao;
import com.cgs.dao.ValuableCompanyDao;
import com.cgs.entity.model.spider.CompanyBase;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ValuableCompanyService {

  @Autowired
  private ValuableCompanyDao valuableCompanyDao;
  @Autowired
  private CompanyDao companyDao;

  public void findValuableCompany(){
    Map<String,List<CompanyBase>> baseCompanyMap = companyDao.findCompanyMap();
    if (ObjectUtils.isEmpty(baseCompanyMap)){
      return;
    }
    for (String key: baseCompanyMap.keySet()){
      List<CompanyBase> baseList = baseCompanyMap.get(key);
      boolean isValuable = isValuableCompany(baseList);
      if (isValuable){
        valuableCompanyDao.addCompany(key);
      }
    }
  }

  private boolean isValuableCompany(List<CompanyBase> companyBaseList){
    Collections.sort(companyBaseList);
    for (CompanyBase companyBase : companyBaseList){
      if (companyBase.getGrossRevenue() < 0){
        companyBaseList.remove(companyBase);
      }
    }
    if (companyBaseList.size() > 9){
      return true;
    }
    return false;
  }
}
