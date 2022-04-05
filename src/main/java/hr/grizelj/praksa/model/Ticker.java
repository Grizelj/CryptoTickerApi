package hr.grizelj.praksa.model;


import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "ticker")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class Ticker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="pair")
    private String pair;

    @Column(name="timestamp")
    private Instant timestamp;

    @Type(type = "list-array")
    @Column(name="a", columnDefinition = "text[]")
    private List<String> a;

    @Type(type = "list-array")
    @Column(name="b", columnDefinition = "text[]")
    private List<String> b;

    @Type(type = "list-array")
    @Column(name="c", columnDefinition = "text[]")
    private List<String> c;

    @Type(type = "list-array")
    @Column(name="v", columnDefinition = "text[]")
    private List<String> v;

    @Type(type = "list-array")
    @Column(name="p", columnDefinition = "text[]")
    private List<String> p;

    @Type(type = "list-array")
    @Column(name="t", columnDefinition = "bigint[]")
    private List<Long> t;

    @Type(type = "list-array")
    @Column(name="l", columnDefinition = "text[]")
    private List<String> l;

    @Type(type = "list-array")
    @Column(name="h", columnDefinition = "text[]")
    private List<String> h;

    @Column(name="o")
    private String o;
}
