package com.imps.cms.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitationDto implements Serializable {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String text;
    private String token;
}
