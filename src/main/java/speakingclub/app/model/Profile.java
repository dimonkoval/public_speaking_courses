package speakingclub.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
//import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "profiles")
@SQLDelete(sql = "UPDATE profiles SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted = FALSE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String photo;
    @Column(nullable = false)
    private boolean isDeleted = false;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Set<Notification> notifications = new HashSet<>();
}
