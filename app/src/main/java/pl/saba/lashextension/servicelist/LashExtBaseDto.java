package pl.saba.lashextension.servicelist;

public class LashExtBaseDto {
    private String serviceName;
    private String servicePrice;


    public LashExtBaseDto(String serviceName, String servicePrice) {

        this.serviceName = serviceName;
        this.servicePrice = servicePrice;

    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getServicePrice() {
        return this.servicePrice;
    }

}
