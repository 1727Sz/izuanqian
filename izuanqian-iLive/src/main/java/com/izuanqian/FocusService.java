package com.izuanqian;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by sanlion on 2017/2/22.
 */
@Service
public class FocusService {

    @Autowired private FocusMapper focusMapper;

    /**
     * 关键词搜索关注点
     *
     * @param keyword
     * @return
     */
    public List<Focus> search(String keyword) {
        final List<DboFocus> dboFocuses = focusMapper.queryFocusesBySearch(keyword);
        List<Focus> focuses = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(dboFocuses)) {
            dboFocuses.forEach(dboFocus ->
                    focuses.add(
                            Focus.builder()
                                    .title(dboFocus.getTitle())
                                    .address(dboFocus.getAddress())
                                    .category(dboFocus.getCategory()
                                    ).build()));
        }
        return focuses;
    }
}
