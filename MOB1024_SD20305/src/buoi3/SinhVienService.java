/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.ArrayList;

/**
 *
 * @author Huyen
 */
public class SinhVienService {
    ArrayList<SinhVien> lstSinhViens= new ArrayList<>();
    //ctrl cách enter
    public SinhVienService() {
        fakeData();//khởi tạo sẵn dữ liệu
    }
    private void fakeData(){
        //đi tạo dữ liệu sẵn có cho lstSinhViens
        lstSinhViens.add(new SinhVien("PH111", "Anh", 18, "HN", true));
        lstSinhViens.add(new SinhVien("PH222", "Trang", 20, "HN", false));
        lstSinhViens.add(new SinhVien("PH333", "Minh", 18, "HN", true));
        lstSinhViens.add(new SinhVien("PH444", "Hang", 19, "HN", false));
        lstSinhViens.add(new SinhVien("PH555", "Dung", 22, "HN", true));
    }
    public ArrayList<SinhVien> getAll(){
        return lstSinhViens;
    }
    //tham số là 1 đối tượng SV
    //thêm 1 đối tượng sv vào danh sách SV //=> kết nối csdl thì sẽ khác chút
    public void add(SinhVien sv){
        lstSinhViens.add(sv);//thêm đối tượng SV được truyền từ tham số vào DS
    }
}
