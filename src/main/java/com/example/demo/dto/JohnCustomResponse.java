package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class JohnCustomResponse extends JohnBaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient Object john;
}
