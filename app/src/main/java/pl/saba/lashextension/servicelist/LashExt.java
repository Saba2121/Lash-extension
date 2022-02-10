package pl.saba.lashextension.servicelist;

import pl.saba.lashextension.EffectType;

public class LashExt {
    private final String lashExtName;
    private final String lashExtImage;
    private final String lashExtPrice;
    private final String lashExtTime;
    private final String lashExtVariant;
    private final EffectType effectType;

    public LashExt(String lashExtName, String lashExtImage, String lashExtPrice, String lashExtTime,
                   String lashExtVariant, EffectType effectType) {

        this.lashExtName = lashExtName;
        this.lashExtImage = lashExtImage;
        this.lashExtPrice = lashExtPrice;
        this.lashExtTime = lashExtTime;
        this.lashExtVariant = lashExtVariant;
        this.effectType = effectType;

    }

    public String getLashExtName() {
        return lashExtName;
    }


    public String getLashExtImage() {
        return this.lashExtImage;
    }

    public String getLashExtPrice() {
        return this.lashExtPrice;
    }

    public String getLashExtTime() {
        return this.lashExtTime;
    }

    public String getLashExtVariant() {
        return this.lashExtVariant;
    }

    public EffectType getEffectType() {
        return this.effectType;
    }


}
