package pl.saba.lashextension.servicelist;
import pl.saba.lashextension.EffectType;

public class LashExt {
    private final String serviceName;
    private final String serviceImage;
    private final String servicePrice;
    private final String serviceTime;
    private final EffectType effectType;
    private final String serviceVariant;

    public LashExt(String serviceName, String serviceImage, String servicePrice, String serviceTime,
                   EffectType effectType, String serviceVariant) {
        this.serviceName = serviceName;
        this.serviceImage = serviceImage;
        this.servicePrice = servicePrice;
        this.serviceTime = serviceTime;
        this.effectType = effectType;
        this.serviceVariant = serviceVariant;
    }

    public String getServiceName() {
        return serviceName;
    }


    public String getServiceImage() {
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


    public String getServiceVariant() {
        return this.serviceVariant;
    }

}
