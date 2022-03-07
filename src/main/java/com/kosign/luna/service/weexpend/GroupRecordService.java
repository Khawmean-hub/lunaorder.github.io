package com.kosign.luna.service.weexpend;

import com.kosign.luna.model.weexpend.GroupRecord;
import com.kosign.luna.model.weexpend.GroupRecordRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface GroupRecordService {
    Page<GroupRecordRes> getAll(Pageable pageable, int id);
    List<GroupRecordRes> getAllByDate(int id, String startDate, String endDate );
    boolean save(GroupRecord groupRecord);
    boolean update(GroupRecord groupRecord);
    boolean delete(int id);

}
