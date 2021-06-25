package lottery.dto;

import lottery.domain.Account;
import lottery.domain.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class AccountDetails {

    private Integer id;
    private String email;
    private String name;
    private List<TicketItem> ticketList;
    private String ipAddress;

    public AccountDetails(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.name = account.getName();
        this.ticketList = account.getTicketList().stream()
                        .map(TicketItem::new)
                        .collect(Collectors.toList());
        this.ipAddress = ipAddress;
    }
}
