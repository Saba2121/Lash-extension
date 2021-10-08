package pl.saba.lashextension.servicelist;

import android.graphics.drawable.Drawable;

import pl.saba.lashextension.EffectType;

public class ServiceDto {
    private final String serviceName;
    private final Drawable serviceImage;
    private final String servicePrice;
    private final String serviceTime;
    private final EffectType effectType;
    private Boolean isServiceAddedToOrder = false;

    public ServiceDto(String serviceName, Drawable serviceImage, String servicePrice, String serviceTime, EffectType effectType) {
        this.serviceName = serviceName;
        this.serviceImage = serviceImage;
        this.servicePrice = servicePrice;
        this.serviceTime = serviceTime;
        this.effectType = effectType;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public Drawable getServiceImage() {
        return this.serviceImage;
    }

    public String getServicePrice() {
        return this.servicePrice;
    }

    public String getServiceTime() {
        return this.serviceTime;
    }

    public EffectType getEffectType() {
        return this.effectType;
    }


    public void addServiceToOrder() {
        isServiceAddedToOrder = true;

    }

    public void deleteServiceFromOrder() {
        isServiceAddedToOrder = false;
    }

    public Boolean getServiceAddedToOrder() {
        return isServiceAddedToOrder;

    }

}
