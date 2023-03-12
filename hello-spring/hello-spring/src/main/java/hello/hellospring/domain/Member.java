package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //시스템 아이디 객체 구별

    @Column(name = "username")
    private String name;


    //get /set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
