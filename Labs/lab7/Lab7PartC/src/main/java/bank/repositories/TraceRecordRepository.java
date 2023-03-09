package bank.repositories;

import bank.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TraceRecordRepository extends JpaRepository<TraceRecord,Long> {
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    TraceRecord save(TraceRecord tr);
}
