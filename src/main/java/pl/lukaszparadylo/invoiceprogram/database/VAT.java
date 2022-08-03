package pl.lukaszparadylo.invoiceprogram.database;

public enum VAT {
    _23(23), _8(8), _5(5);
    private final int id;
    VAT(int id) {
        this.id = id;
    }
    public int getValue() {
        return id;
    }
}
