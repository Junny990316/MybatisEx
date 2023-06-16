package com.kh.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 의존성 주입
public class CompanyService {
    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll(); // list가 비어있는 상태
        if (companyList != null && companyList.size() > 0) {
            for (Company company : companyList) {
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
            }
        }
        return companyList;
    }
}
