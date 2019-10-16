package com.zhdtedu.util;

public enum RcsArchiveStatus implements CodeEnum{
    DAIHESHI("1","待核实"),
    SHANGBAO("2","上报"),
    PAIQIANZHONG("3","派遣中"),
    BULIAN("4","不立案"),
    DAIYANSHOU("5","待验收"),
    YIJIEAN("6","已结案"),
    DAICHULI("7","待处理"),
    YICHULI("8","已处理");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    RcsArchiveStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
