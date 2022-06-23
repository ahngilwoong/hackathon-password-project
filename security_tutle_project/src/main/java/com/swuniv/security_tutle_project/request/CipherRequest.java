package com.swuniv.security_tutle_project.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CipherRequest {
    private String domain;
    private boolean isUpperCaseChecked;
    private boolean isSpecialCharacterChecked;
    private Long stringLength;
}
