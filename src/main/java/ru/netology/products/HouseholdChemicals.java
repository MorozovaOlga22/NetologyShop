package ru.netology.products;

public class HouseholdChemicals extends Product {
    private final boolean isToxic;

    public HouseholdChemicals(String name, int price, boolean isToxic) {
        super(name, price);
        this.isToxic = isToxic;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", isToxic=" + isToxic;
    }
}
