/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi11;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Huyen
 */
public class GiangVienRepository {
//import java.sql.Connection;
    Connection con;

    public GiangVienRepository() {
        con = DBConnect.getConnection();
    }

    public ArrayList<GiangVien> getAll() {
        ArrayList<GiangVien> lstGVs = new ArrayList<>();
        //lấy dữ liệu từ sql
        //gõ 3 lần dấu nháy kép
        String sql = """
                     SELECT [ma]
                           ,[ten]
                           ,[loai]
                           ,[tuoi]
                           ,[bac]
                           ,[gioi_tinh]
                       FROM [dbo].[giang_vien]
                     """;
        //try- catch: xử lý ngoại lệ => try + ctrl space
        //try: chứa code có thể xảy ra lỗi
        //catch: bắt lỗi xảy ra trong try
        
        //import java.sql.PreparedStatement;
        try {
            //tạo đối tượng PS thực thi câu lệnh sql
            PreparedStatement ps= con.prepareStatement(sql);
            //ResultSet: nhận kết quả trả về dưới dạng bảng
            //executeQuery(): thực hiện câu truy vấn
            ResultSet rs = ps.executeQuery();
            //rs.next(): kiểm tra xem còn dòng dữ liệu ko
            while (rs.next()) {               
                //1. khởi tạo đối tượng GV mới
                GiangVien gv= new GiangVien();
                //2. lấy dữ liệu từ bảng gán vào đối tượng GV
                gv.setMa(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setLoai(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setBac(rs.getInt(5));
                gv.setGioi_tinh(rs.getInt(6));
                //3. thêm đối tượng vào danh sách
                lstGVs.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();//in thông tin về lỗi
        }
        return lstGVs;
    }
    //main tab
    public static void main(String[] args) {
        GiangVienRepository repo= new GiangVienRepository();
        ArrayList<GiangVien> list= repo.getAll();
        for (GiangVien gv : list) {
            gv.inThongTin();
        }
    }
}
