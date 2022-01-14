package pl.saba.lashextension.remote.dto;

import pl.saba.lashextension.EffectType;

public class LashExtDto {

    private String serviceName;
    private String serviceImage;
    private String servicePrice;
    private String serviceTime;
    private String serviceVariant;
    private EffectType effectType;


    public LashExtDto(String serviceName, String servicePrice,
                      String serviceTime, String serviceVariant, EffectType effectType) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceTime = serviceTime;
        this.effectType = effectType;
        this.serviceVariant = serviceVariant;

    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public String getServiceVariant() {
        return serviceVariant;
    }

    public String getServiceImage() {
        return serviceImage;
    }
}