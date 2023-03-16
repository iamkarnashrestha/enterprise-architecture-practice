package bank.event;

import bank.domain.TraceRecord;
import bank.service.TraceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountEventListener {
    @Autowired
    private TraceRecordService traceRecordService;
   @EventListener(TraceRecordEvent.class)
    public void onEvent(TraceRecordEvent event) {
        System.out.println("Saving trace record to database");

       traceRecordService.saveTraceRecord(new TraceRecord(event.getAccountNumber(), event.getOperation(), LocalDateTime.now(),event.getAmount()));
    }

    @EventListener(EmailEvent.class)
    public void onEvent(EmailEvent event) {
        System.out.println("==============================================");
        System.out.println("Sending Email");
        System.out.println("Amount "+event.getAmount()+" is performed as "+event.getOperation()+ " to account number: "+event.getAccountNumber());
    }

}
