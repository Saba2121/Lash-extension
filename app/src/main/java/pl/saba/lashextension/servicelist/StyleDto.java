package pl.saba.lashextension.servicelist;

import android.graphics.drawable.Drawable;

import pl.saba.lashextension.EffectType;

public class StyleDto {
    private final String serviceName;
    private final Drawable serviceImage;
    private final String servicePrice;
    private final String serviceTime;
    private final EffectType effectType;
    private Boolean isServiceAddedToOrder = false;
    private final String serviceVariant;

    public StyleDto(String serviceName, Drawable serviceImage, String servicePrice, String serviceTime, EffectType effectType, String serviceVariant) {
        this.serviceName = serviceName;
        this.serviceImage = serviceImage;
        this.servicePrice = servicePrice;
        this.serviceTime = serviceTime;
        this.effectType = effectType;
        this.serviceVariant = serviceVariant;
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

    public String getServiceVariant() {
        return this.serviceVariant;
    }

}
