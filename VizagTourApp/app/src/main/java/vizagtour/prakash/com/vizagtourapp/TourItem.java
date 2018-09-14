package vizagtour.prakash.com.vizagtourapp;

public class TourItem {
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;
    private int name;
    private int address;

    public TourItem(int image, int name, int address) {
        this.image = image;
        this.name = name;
        this.address = address;
    }


    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
