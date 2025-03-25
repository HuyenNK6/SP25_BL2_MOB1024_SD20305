/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi7;

/**
 *
 * @author Huyen
 */
public class Pickleball {

    private String ma;
    private String ten;
    private String thuongHieu;
    private double gia;
    private int soLuong;
    private int trangThai;

    public Pickleball(String ma, String ten, String thuongHieu, double gia, int soLuong, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.thuongHieu = thuongHieu;
        this.gia = gia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public Pickleball() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Pickleball{" + "ma=" + ma + ", ten=" + ten + ", thuongHieu=" + thuongHieu + ", gia=" + gia + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }

    public void inThongTin(){
        System.out.println(toString());
    }
    
    
}
