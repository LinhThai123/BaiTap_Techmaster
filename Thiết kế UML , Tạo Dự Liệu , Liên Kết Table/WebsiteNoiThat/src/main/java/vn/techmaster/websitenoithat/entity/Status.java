package vn.techmaster.websitenoithat.entity;

public enum Status {
    CONHANG("Còn hàng") ,
    HETHANG("Hết hàng") ;
    public final String label;
    private Status(String label) {
        this.label = label;
    }
}
