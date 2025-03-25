/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi7;

import java.util.ArrayList;

/**
 *
 * @author Huyen
 */
public class PickleballService {
    ArrayList<Pickleball> lstPicks= new ArrayList<>();

    public PickleballService() {
        fakeData();
    }
    public void fakeData(){
        lstPicks.add(new Pickleball("VNB023302", "Vợt Pickleball Joola Perseus 14mm Mod TA-15 Pro Player Edition", "Joola", 6990000, 5, 1));
        lstPicks.add(new Pickleball("VNB023793", "Vợt Pickleball Wilson Cadence Pro 16mm", "Wilson", 5090000, 10, 1));
        lstPicks.add(new Pickleball("VNB023792", "Vợt Pickleball Wilson Fierce Pro 13mm", "Wilson", 3180000, 8, 0));
        lstPicks.add(new Pickleball("VNB022333", "Vợt Pickleball Joola Ben Johns Hyperion 3S 14mm", "Joola", 6990000, 5, 0));
        lstPicks.add(new Pickleball("VNB023791", "Vợt Pickleball Wilson Blaze Tour 16mm", "Wilson", 5210000, 12, 1));
    }
    public ArrayList<Pickleball> getAll(){
        return lstPicks;
    }
    //add
    public void addPick(Pickleball pick){
        lstPicks.add(pick);
    }
    //update
    public void updatePick(int indexUpdate, Pickleball pickNew){
        //cần vị trí để update 
        //cần đối tượng mới -> thông tin mới
        Pickleball pick = lstPicks.get(indexUpdate);//lấy ra đối tượng tại vị tri cần update
        //update lần lượt các thông tin của đối tượng -> trừ mã
        //lấy thông tin của thằng mới-> cập nhật vào thằng cũ
        pick.setTen(pickNew.getTen());
        pick.setThuongHieu(pickNew.getThuongHieu());
        pick.setGia(pickNew.getGia());
        pick.setSoLuong(pickNew.getSoLuong());
        pick.setTrangThai(pickNew.getTrangThai());
    }
    //delete
    public void deletePick (int index){
         lstPicks.remove(index);
    }
}
