package speakingclub.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Table(name = "lessons")
@SQLDelete(sql = "UPDATE lessons SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted = FALSE")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String videoLink;
    @Column(nullable = false)
    private String theory;
    @ManyToOne
    @JoinColumn(name = "thema_id", nullable = false)
    private Thema thema;
    @OneToMany(mappedBy = "lesson")
    private Set<Homework> homeworks = new HashSet<>();
    private boolean isDeleted = false;
}
