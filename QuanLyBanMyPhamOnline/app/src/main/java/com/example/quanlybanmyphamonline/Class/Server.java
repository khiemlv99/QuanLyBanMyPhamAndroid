package com.example.quanlybanmyphamonline.Class;

public class Server {
    public Server() {
    }

    public  static String localhost="192.168.56.1:8080";
    public  static String duongdanLoaiSP="http://"  + localhost + "/androidwebservice/getloaisp.php";
    public  static String duongdanALLSP="http://"  + localhost + "/androidwebservice/getallsp.php";
    public  static String duongDanSanPhammoinhat="http://"  + localhost + "/androidwebservice/getspmoinhat.php";
    public  static String duongdansanphamcungloai="http://"  + localhost + "/androidwebservice/getspcungloai.php";
}

