package com.smoothstack.utopia.airplane;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "max_seats_first")
    private Integer maxSeatsFirst;

    @Column(name = "max_seats_business")
    private Integer maxSeatsBusiness;

    @Column(name = "max_seats_economy")
    private Integer maxSeatsEconomy;

    // Parameterless constructor is for JPA
    protected Airplane() {}

    // Public constructor is for developer use
    public Airplane(Integer maxSeatsFirst, Integer maxSeatsBusiness, Integer maxSeatsEconomy) {
        this.maxSeatsFirst = maxSeatsFirst;
        this.maxSeatsBusiness = maxSeatsBusiness;
        this.maxSeatsEconomy = maxSeatsEconomy;
    }

    @Override
    public String toString() {
        return String.format(
                "Airplane{ id=%d, maxSeatsFirst='%d', maxSeatsBusiness='%d', maxSeatsEconomy='%d' }",
                id, maxSeatsFirst, maxSeatsBusiness, maxSeatsEconomy);
    }

    public Integer getId() {
        return id;
    }

    public Integer getMaxSeatsFirst() {
        return maxSeatsFirst;
    }

    public Integer getMaxSeatsBusiness() {
        return maxSeatsBusiness;
    }

    public Integer getMaxSeatsEconomy() {
        return maxSeatsEconomy;
    }

    public void setId(Integer id) { this.id = id; }

    public void setMaxSeatsFirst(Integer maxSeatsFirst) { this.maxSeatsFirst = maxSeatsFirst; }

    public void setMaxSeatsBusiness(Integer maxSeatsBusiness) { this.maxSeatsBusiness = maxSeatsBusiness; }

    public void setMaxSeatsEconomy(Integer maxSeatsEconomy) { this.maxSeatsEconomy = maxSeatsEconomy; }
}
