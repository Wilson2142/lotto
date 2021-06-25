package lottery.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account owner;
    @Column(name = "numbers")
    private List<Integer> numbers;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Ticket(Long id, Account owner, List<Integer> numbers, LocalDateTime timestamp) {
        this.id = id;
        this.owner = owner;
        this.numbers = numbers;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
