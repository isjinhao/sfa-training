package headfirst._14_builder;

public class House {

    private String height;
    private String color;
    private String layers;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLayers() {
        return layers;
    }

    public void setLayers(String layers) {
        this.layers = layers;
    }


    @Override
    public String toString() {
        return "House{" +
            "baise='" + height + '\'' +
            ", wall='" + color + '\'' +
            ", roofed='" + layers + '\'' +
            '}';
    }
}
