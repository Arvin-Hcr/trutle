package com.hcr.turtle.service;

import java.util.List;
import java.util.Map;

public interface ContractService {

    /**
     * 合同
     */

    List<Map<String,Object>> getContract(Integer hid);
}
