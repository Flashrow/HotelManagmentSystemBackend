package pl.polsl.hotelmanagementsystem.service.expense;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private Long id;
    private Double amount;
    private Date date;
    private ExpenseType expenseType;
    private Long roomId;

    public ExpenseDTO(Expense expense){
        this.id = expense.getId();
        this.amount = expense.getAmount();
        this.date = expense.getDate();
        this.expenseType = expense.getExpenseType();
        this.roomId = expense.getRoom().getId();
    }
}
