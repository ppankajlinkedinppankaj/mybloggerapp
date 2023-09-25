package com.realestate.service.impl;
import com.realestate.entities.ClientReg;
import com.realestate.entities.Sale;
import com.realestate.payload.SaleDto;
import com.realestate.repositories.ClientRegRepository;
import com.realestate.repositories.SaleRepository;
import com.realestate.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ClientRegRepository clientRegRepository;


    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository,
                           ClientRegRepository clientRegRepository
                          ) {
        this.saleRepository = saleRepository;
        this.clientRegRepository = clientRegRepository;

    }

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        ClientReg clientReg = clientRegRepository.findById(saleDto.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + saleDto.getClientId()));

        Sale sale = new Sale();
        sale.setId(saleDto.getClientId());
        sale.setClientReg(clientReg);
        sale.setAgentId(saleDto.getAgentId());
        sale.setSaleDate(saleDto.getSaleDate());

        Sale savedSale = saleRepository.save(sale);

        SaleDto dto = new SaleDto();
        dto.setClientId(savedSale.getId());
        dto.setClientReg(clientReg);
        dto.setAgentId(savedSale.getAgentId());
        dto.setSaleDate(savedSale.getSaleDate());

        return dto;
    }



}

