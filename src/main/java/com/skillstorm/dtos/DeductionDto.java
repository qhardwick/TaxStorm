package com.skillstorm.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstorm.entities.Deduction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DeductionDto {

    private int id;
    private String name;
    private BigDecimal rate;

    public DeductionDto(Deduction deduction) {
        this.id = deduction.getId();
        this.name = deduction.getName();
        this.rate = deduction.getRate();
    }

    @JsonIgnore
    public Deduction getDeduction() {
        Deduction deduction = new Deduction();
        deduction.setId(this.id);
        deduction.setName(this.name);
        deduction.setRate(this.rate);

        return deduction;
    }
}
