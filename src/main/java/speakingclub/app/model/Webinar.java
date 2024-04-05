package speakingclub.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "webinars")
public class Webinar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    private String link;
    @OneToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
}
