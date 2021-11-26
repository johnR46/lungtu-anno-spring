package com.example.demo.controller;

import com.example.demo.annotation.JohnDataResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "john-rest")
@RequiredArgsConstructor
public class JohnController {


    @GetMapping("1")
    public LungTu showLungTo1() {
        return buildLungTu();
    }

    @GetMapping("2")
    @JohnDataResponse
    public LungTu showLungTo2() {
        return buildLungTu();
    }

    private LungTu buildLungTu() {
        LungTu lungTu = new LungTu();
        lungTu.setName("Lung Tu Pai tai Ca");
        lungTu.setClassNo("ที่ 1 ของรุ่นว่ะครับ");
        return lungTu;
    }

    @Getter
    @Setter
    static
    class LungTu {
        private String name;
        private String classNo;
    }
}
