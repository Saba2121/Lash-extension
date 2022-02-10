package pl.saba.lashextension.remote.dto;

import pl.saba.lashextension.EffectType;


public class LashExtDto {

    private String lashExtName;
    private String lashExtImageBase64;
    private String lashExtPrice;
    private String lashExtTime;
    private String lashExtVariant;
    private EffectType effectType;


    public LashExtDto(String lashExtName, String lashExtImageBase64, String lashExtPrice,
                      String lashExtTime, String lashExtVariant, EffectType effectType) {

        this.lashExtName = lashExtName;
        this.lashExtImageBase64 = lashExtImageBase64;
        this.lashExtPrice = lashExtPrice;
        this.lashExtTime = lashExtTime;
        this.lashExtVariant = lashExtVariant;
        this.effectType = effectType;


    }

    public String getLashExtName() {
        return lashExtName;
    }

    public String getLashExtImage() {
        return lashExtImageBase64;
    }

    public String getLashExtPrice() {
        return lashExtPrice;
    }

    public String getLashExtTime() {
        return lashExtTime;
    }

    public String getLashExtVariant() {
        return lashExtVariant;
    }

    public EffectType getEffectType() {
        return effectType;
    }


}