package com.rin1903.bookstoremanager.SQLite;

public class SACH {
    public String SQL_createtable(){
        return "create table if not exists SACH (" +
                "   MASACH               int                  not null," +
                "   MALOAI               char(50)             not null," +
                "   MATACGIA             varchar(100)         not null," +
                "   TENSACH              varchar(100)         null," +
                "   SOQUYEN              int                  null," +
                "   GIABAN               int          null," +
                " HINH_SACH            BLOB         null,"+
                "   constraint PK_SACH primary key (MASACH)" +
                ")";
    }

    public SACH(int MASACH) {
        this.MASACH = MASACH;
    }

    public SACH() {
    }

    public SACH(int MASACH, String MALOAI, String MATACGIA) {
        this.MASACH = MASACH;
        this.MALOAI = MALOAI;
        this.MATACGIA = MATACGIA;
    }

    public SACH(int MASACH, String MALOAI, String MATACGIA, String TENSACH, int SOQUYEN, int GIABAN, byte[] HINH_SACH) {
        this.MASACH = MASACH;
        this.MALOAI = MALOAI;
        this.MATACGIA = MATACGIA;
        this.TENSACH = TENSACH;
        this.SOQUYEN = SOQUYEN;
        this.GIABAN = GIABAN;
        this.HINH_SACH = HINH_SACH;
    }

    public int getMASACH() {
        return MASACH;
    }

    public void setMASACH(int MASACH) {
        this.MASACH = MASACH;
    }

    public String getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(String MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getMATACGIA() {
        return MATACGIA;
    }

    public void setMATACGIA(String MATACGIA) {
        this.MATACGIA = MATACGIA;
    }

    public String getTENSACH() {
        return TENSACH;
    }

    public void setTENSACH(String TENSACH) {
        this.TENSACH = TENSACH;
    }

    public int getSOQUYEN() {
        return SOQUYEN;
    }

    public void setSOQUYEN(int SOQUYEN) {
        this.SOQUYEN = SOQUYEN;
    }

    public int getGIABAN() {
        return GIABAN;
    }

    public void setGIABAN(int GIABAN) {
        this.GIABAN = GIABAN;
    }

    public byte[] getHINH_SACH() {
        return HINH_SACH;
    }

    public void setHINH_SACH(byte[] HINH_SACH) {
        this.HINH_SACH = HINH_SACH;
    }

    public String getTENBANG(){
        return "SACH";
    }
    private int MASACH;
    private String MALOAI,MATACGIA,TENSACH;
    private int SOQUYEN,GIABAN;
    private byte[] HINH_SACH;




}
