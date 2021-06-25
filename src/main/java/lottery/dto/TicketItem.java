package lottery.dto;

import lottery.domain.Account;
import lottery.domain.Ticket;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TicketItem {

    private Long id;
    private Account owner;
    private List<Integer> numbers;
    private String timeStamp;

    public TicketItem(Ticket ticket) {
        this.id = ticket.getId();
        this.owner = ticket.getOwner();
        this.numbers = ticket.getNumbers().stream()
                .map(Integer::new).collect(Collectors.toList());
        this.timeStamp = ticket.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
