package com.lathief.calendar.payload.request;

import com.lathief.calendar.enums.RequestReplyType;
import lombok.Data;

@Data
public class EngangementRequest {
    private RequestReplyType type;
}
