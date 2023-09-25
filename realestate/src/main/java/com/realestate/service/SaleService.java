package com.realestate.service;

import com.realestate.entities.Sale;
import com.realestate.payload.SaleDto;

public interface SaleService {
    public SaleDto saveSale(SaleDto saleDto);
}
