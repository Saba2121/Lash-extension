package pl.saba.lashextension.servicelist;

public class ServiceBaseDto {
    private String serviceName;
    private String servicePrice;


    public ServiceBaseDto(String serviceName, String servicePrice) {

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
