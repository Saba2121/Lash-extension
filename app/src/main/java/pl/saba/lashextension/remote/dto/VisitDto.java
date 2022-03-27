package pl.saba.lashextension.remote.dto;

import pl.saba.lashextension.EffectType;

public class VisitDto {

    private String name;
    private String surname;
    private String numberPhone;
    private Long visitTimestamp;
    private EffectType effectType;
    private String variant;

    public VisitDto(String name, String surname, String numberPhone, Long visitTimestamp, EffectType effectType,
                    String variant) {

        this.name = name;
        this.surname = surname;
        this.numberPhone = numberPhone;
        this.visitTimestamp = visitTimestamp;
        this.effectType = effectType;
        this.variant = variant;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumberPhone() {
        return numberPhone;
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

    public void setName(String name) {
        this.name = name;
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
