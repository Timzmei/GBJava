public class Notebook {

    private int ram;
    private String manufacturer;
    private String cpuModel;
    private int displaySize;
    private String os;
    private String color;
    private String type;
    private String graphicsController;
    private int ssd;
    private int hdd;
    private int vRam;

    public Notebook(int ram, String manufacturer, String cpuModel, int displaySize, String os, String color, String type, String graphicsController, int ssd, int hdd, int vRam) {
        this.ram = ram;
        this.manufacturer = manufacturer;
        this.cpuModel = cpuModel;
        this.displaySize = displaySize;
        this.os = os;
        this.color = color;
        this.type = type;
        this.graphicsController = graphicsController;
        this.ssd = ssd;
        this.hdd = hdd;
        this.vRam = vRam;
    }

    public int getRam() {
        return ram;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getGraphicsController() {
        return graphicsController;
    }

    public int getSsd() {
        return ssd;
    }

    public int getHdd() {
        return hdd;
    }

    public int getvRam() {
        return vRam;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ноутбук ");
        sb.append(System.lineSeparator());
        sb.append(this.color);
        sb.append(" ");
        sb.append(this.manufacturer);
        sb.append(" ");
        sb.append(this.type);
        sb.append(System.lineSeparator());
        sb.append("OS " + this.os);
        sb.append(System.lineSeparator());
        sb.append("HDD " + this.hdd);
        sb.append(System.lineSeparator());
        sb.append("RAM " + this.ram);

        return (sb.toString());
    }
}
