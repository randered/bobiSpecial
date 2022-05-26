package guru.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jt on 12/15/15.
 */
@Embeddable
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Address {

    @Column(name = "address_Line_1", insertable = false, updatable = false)
    private String addressLine1;

    @Column(name = "address_Line_2", insertable = false, updatable = false)
    private String addressLine2;

    @Column(name = "city", insertable = false, updatable = false)
    private String city;

    @Column(name = "state", insertable = false, updatable = false)
    private String state;

    @Column(name = "zipCode", insertable = false, updatable = false)
    private String zipCode;

}
