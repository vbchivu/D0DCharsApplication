package com.dodgame.dodgame.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonsterCharacteristicsDTO {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("alignment")
    @Expose
    private String alignment;
    @SerializedName("armor_class")
    @Expose
    private int armorClass;
    @SerializedName("hit_points")
    @Expose
    private int hitPoints;
    @SerializedName("strength")
    @Expose
    private int strength;
    @SerializedName("dexterity")
    @Expose
    private int dexterity;
    @SerializedName("constitution")
    @Expose
    private int constitution;
    @SerializedName("intelligence")
    @Expose
    private int intelligence;
    @SerializedName("wisdom")
    @Expose
    private int wisdom;
    @SerializedName("charisma")
    @Expose
    private int charisma;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "MonsterCharacteristicsDTO{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", alignment='" + alignment + '\'' +
                ", armorClass=" + armorClass +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                '}';
    }
}
