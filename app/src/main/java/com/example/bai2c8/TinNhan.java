package com.example.bai2c8;

public class TinNhan {
    private String ThoiGian;
    private String SoDienThoai;
    private String NoiDung;

    public TinNhan() {
    }

    public TinNhan(String thoiGian, String soDienThoai, String noiDung) {
        ThoiGian = thoiGian;
        SoDienThoai = soDienThoai;
        NoiDung = noiDung;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    @Override
    public String toString() {
        return "So dien thoai: "+this.SoDienThoai+"\n"+
                "Thoi gian: "+this.ThoiGian+"\n"+
        "Noi dung: "+this.NoiDung+"\n";
    }
}
