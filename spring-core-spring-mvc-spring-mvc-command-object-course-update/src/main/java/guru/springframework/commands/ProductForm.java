package guru.springframework.commands;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * Created by jt on 12/24/15.
 */
public class ProductForm {

    private Integer id;
    private Integer version;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String description;

    @NotNull
    @Min(0)
    @Max(5000)
    private BigDecimal price;

    @NotEmpty
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
