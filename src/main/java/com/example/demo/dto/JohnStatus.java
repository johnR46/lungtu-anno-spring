package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class JohnStatus implements Serializable {
    private String code;
    private String desc;
}
