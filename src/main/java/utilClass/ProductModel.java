package utilClass;

public class ProductModel {

    private final String mark;
    private final String name;
    private final String description;
    private final Integer price;
    private final Integer calification;
    private final String materials;
    private final String prodId;
    private final String referentialImage;

    public ProductModel(String mark, String name, String description, Integer price, Integer calification, String materials, String prodId, String referentialImage) {
        this.mark = mark;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calification = calification;
        this.materials = materials;
        this.prodId = prodId;
        this.referentialImage = referentialImage;
    }

    public String getMark() {
        return mark;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCalification() {
        return calification;
    }

    public String getMaterials() {
        return materials;
    }

    public String getProdId() {
        return prodId;
    }

    public String getReferentialImage() {
        return referentialImage;
    }
}
