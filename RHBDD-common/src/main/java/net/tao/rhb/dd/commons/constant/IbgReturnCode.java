package net.tao.rhb.dd.commons.constant;

public enum IbgReturnCode {
    R00("R00");
    
    private final String returnCode;
    
    IbgReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    
    public String returnCode() {
        return returnCode;
    }
}
