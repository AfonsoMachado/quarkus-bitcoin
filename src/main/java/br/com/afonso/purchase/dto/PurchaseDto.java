package br.com.afonso.purchase.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {

    @NotNull
    private Double price;

    @NotNull
    private String type;

    @NotNull
    private String status;

}
