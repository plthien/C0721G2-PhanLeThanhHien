package com.codegym.furamaresortmanagement.model.contract;

import com.codegym.furamaresortmanagement.model.customer.Customer;
import com.codegym.furamaresortmanagement.model.employee.Employee;
import com.codegym.furamaresortmanagement.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Entity(name = "contracts")
@Data @AllArgsConstructor @NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "check_in_date", columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checkInDate;
    @Column(name = "check_out_date", columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checkOutDate;
    private Double deposit;
    private Double total;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    @ManyToOne(targetEntity = Facility.class)
    private Facility facility;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ContractDetail> contractDetails;

    public Double getTotal(){
        double total = 0.0;

        for ( ContractDetail contractDetail: this.contractDetails) {
            total += contractDetail.getQuantity() * contractDetail.getExtraService().getPrice();
        }

        long period;
        switch (this.facility.getRentingType().getName()){
            case "Hour":
                period = Duration.between(this.checkInDate, this.checkOutDate).getSeconds()/60;
                break;
            case "Date":
                period =  Duration.between(this.checkInDate, this.checkOutDate).getSeconds()/(60 * 24);
                break;
            case "Month":
                period =  Duration.between(this.checkInDate, this.checkOutDate).getSeconds()/(60 * 24 * 30);
                break;
            default:
                period =  Duration.between(this.checkInDate, this.checkOutDate).getSeconds()/(60 * 24 * 365);
                break;
        }

        total += this.facility.getBasicCost() * period * this.facility.getRentingType().getFactorCost();

        return total;
    }

    public Double getDeposit(){
        this.deposit = this.total * 0.1;
        return deposit;
    }

}
