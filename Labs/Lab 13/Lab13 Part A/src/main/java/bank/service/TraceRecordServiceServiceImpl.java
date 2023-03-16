package bank.service;

import bank.domain.TraceRecord;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceRecordServiceServiceImpl implements TraceRecordService {
    @Autowired
    private TraceRecordRepository traceRecordRepository;
    @Override
    public void saveTraceRecord(TraceRecord traceRecord) {
        traceRecordRepository.save(traceRecord);
    }
}
