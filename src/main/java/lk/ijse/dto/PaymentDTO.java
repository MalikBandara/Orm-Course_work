package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PaymentDTO {
    private String paymentId;
    private double amount;
    private double paidAmount;
    private double balance;


    public PaymentDTO(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return " " +paymentId ;
    }


}
