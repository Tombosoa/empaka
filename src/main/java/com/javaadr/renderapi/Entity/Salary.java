package com.javaadr.renderapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private double riseup;
    private Timestamp paiement_date;

    public Salary(int id, double amount, double riseup, Timestamp paiement_date) {
        this.id = id;
        this.amount = amount;
        this.riseup = riseup;
        this.paiement_date = paiement_date;
    }

    public Salary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRiseup() {
        return riseup;
    }

    public void setRiseup(double riseup) {
        this.riseup = riseup;
    }

    public Timestamp getPaiement_date() {
        return paiement_date;
    }

    public void setPaiement_date(Timestamp paiement_date) {
        this.paiement_date = paiement_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salary salary)) return false;
        return getId() == salary.getId() && Double.compare(getAmount(), salary.getAmount()) == 0 && Double.compare(getRiseup(), salary.getRiseup()) == 0 && Objects.equals(getPaiement_date(), salary.getPaiement_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getRiseup(), getPaiement_date());
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", amount=" + amount +
                ", riseup=" + riseup +
                ", paiement_date=" + paiement_date +
                '}';
    }
}
