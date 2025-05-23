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
//Trả về 1 danh sách GV

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
            PreparedStatement ps = con.prepareStatement(sql);
            //ResultSet: nhận kết quả trả về dưới dạng bảng
            //executeQuery(): thực hiện câu truy vấn
            ResultSet rs = ps.executeQuery();
            //rs.next(): kiểm tra xem còn dòng dữ liệu ko
            while (rs.next()) {
                //1. khởi tạo đối tượng GV mới
                GiangVien gv = new GiangVien();
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

    //Tìm kiếm Gv theo mã => trả về 1 đối tượng
    public GiangVien getOne(String ma) {
        String sql = """
                     SELECT [ma]
                           ,[ten]
                           ,[loai]
                           ,[tuoi]
                           ,[bac]
                           ,[gioi_tinh]
                       FROM [dbo].[giang_vien]
                       WHERE ma like ?
                     """;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //set cái dấu ?
            ps.setObject(1, ma);//cho dấu ? số 1
            ResultSet rs = ps.executeQuery();
            //rs.next(): kiểm tra xem còn dòng dữ liệu ko
            while (rs.next()) {
                //1. khởi tạo đối tượng GV mới
                GiangVien gv = new GiangVien();
                //2. lấy dữ liệu từ bảng gán vào đối tượng GV
                gv.setMa(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setLoai(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setBac(rs.getInt(5));
                gv.setGioi_tinh(rs.getInt(6));
                //3. trả về 1 đối tượng 
                return gv;
            }
        } catch (Exception e) {
            e.printStackTrace();//in thông tin về lỗi
        }
        return null;
    }

    //Thêm 1 đối tượng vào bảng => INSERT
    /* 
    INSERT -> THÊM
    UPDATE -> SỬA
    DELETE -> XÓA
    => trả về số dòng được thực hiện => executeUpdate
     */
    public boolean addGV(GiangVien gv) {
        //gõ 3 lần dấu nháy kép
        String sql = """
                     INSERT INTO [dbo].[giang_vien]
                                ([ma]
                                ,[ten]
                                ,[loai]
                                ,[tuoi]
                                ,[bac]
                                ,[gioi_tinh])
                          VALUES
                                (?,?,?,?,?,?)
                     """;
        //try + ctrl + space
        int check = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //set dấu ?
            ps.setObject(1, gv.getMa());
            ps.setObject(2, gv.getTen());
            ps.setObject(3, gv.getLoai());
            ps.setObject(4, gv.getTuoi());
            ps.setObject(5, gv.getBac());
            ps.setObject(6, gv.getGioi_tinh());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
        // check = 1 -> 1>0 return true
        // check = 0 -> 0>0 return false
    }

    //tìm kiếm GV cần sửa theo mã gv
    //khi tìm thấy thì thay đổi 
    //thông tin theo đối tượng gv truyền vào
    public boolean updateGV(GiangVien gv) {
        //gõ 3 lần dấu nháy kép
        //không sửa mã GV
        String sql = """
                     UPDATE [dbo].[giang_vien]
                        SET [ten] = ?
                           ,[loai] = ?
                           ,[tuoi] = ?
                           ,[bac] = ?
                           ,[gioi_tinh] = ?
                      WHERE ma = ?
                     """;
        //try + ctrl + space
        int check = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //set dấu ?
            ps.setObject(1, gv.getTen());
            ps.setObject(2, gv.getLoai());
            ps.setObject(3, gv.getTuoi());
            ps.setObject(4, gv.getBac());
            ps.setObject(5, gv.getGioi_tinh());
            ps.setObject(6, gv.getMa());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
        // check = 1 -> 1>0 return true
        // check = 0 -> 0>0 return false
    }
//BTVN:làm nốt xóa
    //xóa theo mã => truyền tham số là 1 mã
    
    //main tab
    public static void main(String[] args) {
        GiangVienRepository repo = new GiangVienRepository();
        ArrayList<GiangVien> list = repo.getAll();
        for (GiangVien gv : list) {
            gv.inThongTin();
        }
        GiangVien gvTimKiem = repo.getOne("PhongTT35");//tìm GV theo mã
        System.out.println("Tìm kiếm giảng viên: ");
        gvTimKiem.inThongTin();
        //test 1 lần phần dưới này
//        GiangVien gvNew = new GiangVien("Huyen566", "Khanh Huyen",
//                "Loai 1", 18, 3, 1);
//        boolean test = repo.addGV(gvNew);
//        System.out.println("Thêm GV mới: " + test);
        //update Gv đã tồn tại
        //giữ nguyên mã-> ko sửa 
        boolean testUpdate = repo.updateGV(
            new GiangVien("TrangNTN12", 
                    "Như Trang","Loai 2", 45, 3, 0));
        System.out.println("Test update GV: "+ testUpdate);
        //test true -> quay lại sql kiểm tra
    }
}
