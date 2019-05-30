package com.pokemon.pokemontest.data.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("id")
    @Expose
    private double id;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("type")
    @Expose
    private List<String> type = null;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("candy")
    @Expose
    private String candy;
    @SerializedName("candy_count")
    @Expose
    private double candyCount;
    @SerializedName("egg")
    @Expose
    private String egg;
    @SerializedName("spawn_chance")
    @Expose
    private double spawnChance;
    @SerializedName("avg_spawns")
    @Expose
    private double avgSpawns;
    @SerializedName("spawn_time")
    @Expose
    private String spawnTime;
    @SerializedName("multipliers")
    @Expose
    private Object multipliers;
    @SerializedName("weaknesses")
    @Expose
    private List<String> weaknesses = null;
    @SerializedName("next_evolution")
    @Expose
    private List<NextEvolution> nextEvolution = null;
    @SerializedName("prev_evolution")
    @Expose
    private List<PrevEvolution> prevEvolution = null;

    public Pokemon() {
    }

    public Pokemon(double id, String num, String name, String img, List<String> type, String height, String weight, String candy, double candyCount, String egg, double spawnChance, double avgSpawns, String spawnTime, Object multipliers, List<String> weaknesses, List<NextEvolution> nextEvolution, List<PrevEvolution> prevEvolution) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.img = img;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.candy = candy;
        this.candyCount = candyCount;
        this.egg = egg;
        this.spawnChance = spawnChance;
        this.avgSpawns = avgSpawns;
        this.spawnTime = spawnTime;
        this.multipliers = multipliers;
        this.weaknesses = weaknesses;
        this.nextEvolution = nextEvolution;
        this.prevEvolution = prevEvolution;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCandy() {
        return candy;
    }

    public void setCandy(String candy) {
        this.candy = candy;
    }

    public double getCandyCount() {
        return candyCount;
    }

    public void setCandyCount(double candyCount) {
        this.candyCount = candyCount;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    public double getSpawnChance() {
        return spawnChance;
    }

    public void setSpawnChance(double spawnChance) {
        this.spawnChance = spawnChance;
    }

    public double getAvgSpawns() {
        return avgSpawns;
    }

    public void setAvgSpawns(double avgSpawns) {
        this.avgSpawns = avgSpawns;
    }

    public String getSpawnTime() {
        return spawnTime;
    }

    public void setSpawnTime(String spawnTime) {
        this.spawnTime = spawnTime;
    }

    public Object getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(Object multipliers) {
        this.multipliers = multipliers;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<NextEvolution> getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(List<NextEvolution> nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    public List<PrevEvolution> getPrevEvolution() {
        return prevEvolution;
    }

    public void setPrevEvolution(List<PrevEvolution> prevEvolution) {
        this.prevEvolution = prevEvolution;
    }

}
