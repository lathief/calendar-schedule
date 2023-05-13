package com.lathief.calendar.utils;

import com.lathief.calendar.enums.RequestReplyType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class EngagementEmailStuff {
    private static final String engagementUpdateApi = "http://localhost:8080/api/schedule/";
    private String title;
    private String description;
    private String[] recipient;
    private Long scheduleId;
    private Long engagementId;
    public EngagementEmailStuff(String title, String description, String[] recipient, Long scheduleId, Long engagementId) {
        this.title = title;
        this.description = description;
        this.recipient = recipient;
        this.scheduleId = scheduleId;
        this.engagementId = engagementId;
    }
    public Map<String, Object> getProps() {
        final Map<String, Object> props = new HashMap<>();
        props.put("subject", title);
        props.put("description", description);
        props.put("acceptUrl", engagementUpdateApi + scheduleId + "/engagement/" + engagementId + "?type=" + RequestReplyType.ACCEPT.name());
        props.put("rejectUrl", engagementUpdateApi + scheduleId + "/engagement/" + engagementId + "?type=" + RequestReplyType.REJECT.name());
        return props;
    }
}
