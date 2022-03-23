package pl.saba.lashextension.remote.dto;

import pl.saba.lashextension.EffectType;

public class VisitAddDto {

    private Long visitTimestamp;
    private EffectType effectType;
    private String variant;

    public VisitAddDto(Long visitTimestamp, EffectType effectType, String variant) {
        this.visitTimestamp = visitTimestamp;
        this.effectType = effectType;
        this.variant = variant;
    }

    public Long getVisitTimestamp() {
        return visitTimestamp;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public String getVariant() {
        return variant;
    }

    public void setVisitTimestamp(long visitTimestamp) {
        this.visitTimestamp = visitTimestamp;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
