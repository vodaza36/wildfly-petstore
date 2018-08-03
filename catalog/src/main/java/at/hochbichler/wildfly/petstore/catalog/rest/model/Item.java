package at.hochbichler.wildfly.petstore.catalog.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="item")
@NamedQueries({
        @NamedQuery(name="Item.findById",
        query="SELECT i FROM Item i WHERE i.itemId = :itemId")
})
@Data
public class Item {
    @Id
    @JsonIgnore
    private int id;

    @Column(length = 30)
    private String itemId;

    @Column(length = 30)
    private String name;

    @Column
    private int quantity;

    @Column
    private String description;
}
